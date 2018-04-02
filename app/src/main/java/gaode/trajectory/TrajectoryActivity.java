package gaode.trajectory;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.kyleduo.switchbutton.SwitchButton;
import com.squareup.picasso.Picasso;

import bean.Bean.ReturnValueBean.DataListBean;

import java.util.ArrayList;
import java.util.List;

import bean.Bean;
import config.Config;
import gaodedemo.nl.org.gaodedemoapplication.R;
import tools.ReadStringUtil;
import gaode.trajectory.TrajectRunnable.TrajectListener;

/**
 * Created by nl on 2016/11/21.
 */

public final class TrajectoryActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    private String TAG = TrajectoryActivity.class.getName().toString().trim();
    private Button btn1;
    private Button btn2;
    private String str;
    private Bean bean;
    private MapView mapview;
    private AMap aMap;
    private ImageView play_image;
    private RelativeLayout play_root;
    private SeekBar seekbar;
    private SwitchButton switchButton;

    private int maxIndex, index;

//    private View infoWindowView;

    private AMap.InfoWindowAdapter infoWindowAdapter;

    private Polyline polyline;

    private Marker startMarker;            //起点

    private Marker endMarker;              //终点

    private Marker moveMarker;             //可移动的点

    private List<DataListBean> beanList = new ArrayList<>();

    private TrajectRunnable runnable;

    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trajectory);
        initView(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapview.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapview.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapview.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapview.onSaveInstanceState(outState);
    }

    void initView(Bundle savedInstanceState) {

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        mapview = (MapView) findViewById(R.id.mapview);
        mapview.onCreate(savedInstanceState);
        aMap = mapview.getMap();
        aMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));
        UiSettings uiSettings = aMap.getUiSettings();
        play_image = (ImageView) findViewById(R.id.play_image);
        play_root = (RelativeLayout) findViewById(R.id.play_root);
        play_root.setOnClickListener(playClickListener);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener(this);
        switchButton = (SwitchButton) findViewById(R.id.switchButton);
        switchButton.setEnabled(true);
        switchButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                str = ReadStringUtil.ReadString(this, R.raw.trajectory1);
                break;
            case R.id.btn2:
                str = ReadStringUtil.ReadString(this, R.raw.trajectory2);
                break;
        }
        bean = new Gson().fromJson(str, Bean.class);
        if (bean != null) {
            beanList = bean.getReturnValue().getDataList();
        }
        if (beanList.size() > 2) {
            maxIndex = beanList.size();
            displayPolyline();
            displayMarkers();
            runnable = new TrajectRunnable(beanList.size(), trajectListener);
            runnable.run();
            isPlaying = true;
            seekbar.setMax(beanList.size());
            seekbar.setProgress(0);
            Picasso.with(this).load(R.drawable.stop).into(play_image);
        }
    }


    android.view.View.OnClickListener playClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (runnable != null) {
                if (isPlaying) {
                    runnable.stopPlay();
                    Picasso.with(TrajectoryActivity.this).load(R.drawable.triangle).into(play_image);
                } else {
                    runnable.reStartPlay();
                    Picasso.with(TrajectoryActivity.this).load(R.drawable.stop).into(play_image);
                }
                isPlaying = !isPlaying;
            } else {
                Toast.makeText(TrajectoryActivity.this, "请选择一条轨迹", Toast.LENGTH_SHORT).show();
            }

        }
    };


    /******************
     * seekbar
     ***************/

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.d(TAG, "seekBar.getProgress() = " + seekBar.getProgress());
        runnable.setPlayIndex(seekBar.getProgress());
    }

    /****
     * switchButton
     *
     * @param buttonView
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked && moveMarker.isInfoWindowShown()) {
            moveMarker.hideInfoWindow();
        } else {
            moveMarker.showInfoWindow();
        }
    }

    private TrajectListener trajectListener = new TrajectListener() {
        @Override
        public void onUpdataPlaying(int index) {
            TrajectoryActivity.this.index = index;
            seekbar.setProgress(TrajectoryActivity.this.index);
            upDataMoveMarker(TrajectoryActivity.this.index);
            Log.d(TAG, "index = " + TrajectoryActivity.this.index);
        }

        @Override
        public void onStartPlaying() {
            Log.d(TAG, "startPlaying");
        }

        @Override
        public void onStopPlaying() {
            Log.d(TAG, "onStopPlaying");
        }

        @Override
        public void onFinishPlaying() {
            Picasso.with(TrajectoryActivity.this).load(R.drawable.triangle).into(play_image);
            isPlaying = false;
            Log.d(TAG, "onFinishPlaying");
        }
    };

    /***
     * 绘制轨迹线
     */
    private void displayPolyline() {
        List<LatLng> latlngList = new ArrayList<>();
        for (DataListBean bean : beanList) {
            if (bean != null) {
                LatLng latlng = new LatLng(bean.getLat(), bean.getLon());
                latlngList.add(latlng);
            }
        }
        PolylineOptions option = new PolylineOptions();
        option.zIndex(9);
        option.color(Color.argb(255, 58, 125, 240));
        option.width(15);
        option.addAll(latlngList);
        if (polyline != null) {
            polyline.remove();
        }
        polyline = aMap.addPolyline(option);
    }


    private void displayMarkers() {
        LatLng startLatLng = new LatLng(beanList.get(0).getLat(), beanList.get(0).getLon());
        LatLng endLatLng = new LatLng(beanList.get(beanList.size() - 1).getLat(), beanList.get(beanList.size() - 1).getLon());

        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLatLng, Config.ZoomLevel));
        if (moveMarker == null) {
            MarkerOptions markerOptions = new MarkerOptions().setFlat(true).anchor(0.5f, 0.5f)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trajectory_dot_one))
                    .position(startLatLng).zIndex(12).title("信息");
            moveMarker = aMap.addMarker(markerOptions);
            moveMarker.showInfoWindow();
        }
        moveMarker.setPosition(startLatLng);

        if (startMarker == null) {
            MarkerOptions odev = new MarkerOptions().position(startLatLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trajectory_dot_start))
                    .zIndex(10)
                    .draggable(false);
            startMarker = (aMap.addMarker(odev));
        }
        startMarker.setPosition(startLatLng);

        if (endMarker == null) {
            MarkerOptions odev1 = new MarkerOptions().position(endLatLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.trajectory_dot_end)).zIndex(10).draggable(false);//
            endMarker = (aMap.addMarker(odev1));
        }
        endMarker.setPosition(endLatLng);
    }

    private void upDataMoveMarker(int index) {
        DataListBean bean = beanList.get(index);
        LatLng latLng = new LatLng(bean.getLat(), bean.getLon());
        if (moveMarker != null) {
            moveMarker.setPosition(latLng);
            moveMarker.setObject(bean);
            if (!switchButton.isChecked()) {
                moveMarker.showInfoWindow();
            } else {
                moveMarker.hideInfoWindow();
            }
        }
    }


}
