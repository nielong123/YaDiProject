package gaode.trajectory.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.utils.overlay.SmoothMoveMarker;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.jaydenxiao.common.commonutils.TimeUtil;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.squareup.picasso.Picasso;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gaode.trajectory.adapter.CustomInfoWindowAdapter;
import gaode.trajectory.adapter.TrajectRunnable;
import gaode.trajectory.api.Api;
import gaode.trajectory.bean.Bean;
import gaode.trajectory.bean.TrajectoryBean;
import gaode.trajectory.widget.TitleView;
import gaodedemo.nl.org.gaodedemoapplication.R;

/**
 * Created by nl on 2016/11/21.
 */

public final class TrajectoryActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.start)
    TextView start;
    @BindView(R.id.end)
    TextView end;
    @BindView(R.id.search)
    Button search;
    @BindView(R.id.mapview)
    TextureMapView mapview;
    @BindView(R.id.play_image)
    ImageView playImage;
    @BindView(R.id.play_root)
    RelativeLayout playRoot;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.title_view)
    TitleView titleView;


    AMap.InfoWindowAdapter infoWindowAdapter;

    private String TAG = TrajectoryActivity.class.getName().toString().trim();
    private AMap aMap;

    private Marker startMarker;            //起点

    private Marker endMarker;              //终点

    private SmoothMoveMarker moveMarker;             //可移动的点

    private List<Bean.ReturnValueBean.DataListBean> beanList = new ArrayList<>();

    String tv_start, tv_end;

    int index = 0;

    private static final int START_STATUS = 0;
    private static final int MOVE_STATUS = 1;
    private static final int PAUSE_STATUS = 2;
    private static final int FINISH_STATUS = 3;
    private int mMarkerStatus = START_STATUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trajectory);
        ButterKnife.bind(this);
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
        titleView.setTitle("历史轨迹");
        mapview.onCreate(savedInstanceState);
        aMap = mapview.getMap();
        start.setOnClickListener(this);
        end.setOnClickListener(this);
        search.setOnClickListener(this);
        playImage.setOnClickListener(this);
        aMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));
        seekbar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv_start = TimeUtil.formatData(TimeUtil.dateFormatYMDHMS, date.getTime() / 1000);
                        start.setText(tv_start);
                    }
                }).build().show();
                break;
            case R.id.end:
                new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv_end = TimeUtil.formatData(TimeUtil.dateFormatYMDHMS, date.getTime() / 1000);
                        end.setText(tv_end);
                    }
                }).build().show();
                break;
            case R.id.search:
                if (TextUtils.isEmpty(tv_end) || TextUtils.isEmpty(tv_start)) {
                    ToastUitl.show("请选择时间", Toast.LENGTH_SHORT);
                    break;
                }
                getTrajectoryHistory();
                break;
            case R.id.play_image:
                if (mMarkerStatus == START_STATUS) {
                    moveMarker.startSmoothMove();
                    mMarkerStatus = MOVE_STATUS;
                    Picasso.with(this).load(R.drawable.stop).into(playImage);
                } else if (mMarkerStatus == MOVE_STATUS) {
                    moveMarker.stopMove();
                    mMarkerStatus = PAUSE_STATUS;
                    Picasso.with(this).load(R.drawable.play).into(playImage);
                } else if (mMarkerStatus == PAUSE_STATUS) {
                    moveMarker.startSmoothMove();
                    mMarkerStatus = MOVE_STATUS;
                    Picasso.with(this).load(R.drawable.stop).into(playImage);
                } else if (mMarkerStatus == FINISH_STATUS) {
                    moveMarker.setPosition(points.get(0));
                    moveMarker.setPoints(points);
                    moveMarker.getMarker().showInfoWindow();
                    moveMarker.startSmoothMove();
                    mMarkerStatus = MOVE_STATUS;
                    Picasso.with(this).load(R.drawable.stop).into(playImage);
                }
                break;
        }
    }


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
    }

    /****
     * switchButton
     *
     * @param buttonView
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if (!isChecked && moveMarker.isInfoWindowShown()) {
//            moveMarker.hideInfoWindow();
//        } else {
//            moveMarker.showInfoWindow();
//        }
    }


    void getTrajectoryHistory() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("devNo", Api.CAR);
        ajaxParams.put("startTime", tv_start);
        ajaxParams.put("endTime", tv_end);
        ajaxParams.put("size", "10");
        ajaxParams.put("sort", "asc");
        finalHttp.post(Api.URL + "/monitor/test/car/track", ajaxParams, new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                if (TrajectoryActivity.this.isDestroyed() || TrajectoryActivity.this.isFinishing())
                    return;
                TrajectoryBean trajectoryBean = new Gson().fromJson(s, TrajectoryBean.class);
                if (trajectoryBean.getObj() != null) {
                    ToastUitl.showShort(trajectoryBean.getMsg());
                }
                if (trajectoryBean.getMsg() != null) {
                    ToastUitl.showShort(trajectoryBean.getMsg());
                }
                if (trajectoryBean.getObj() == null) return;
                if (trajectoryBean.getObj().getDevStateList() == null) return;
                ToastUitl.showShort("查询到" + trajectoryBean.getObj().getDevStateList().size() + "条数据");
                initMoveMarker(trajectoryBean.getObj().getDevStateList());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                ToastUitl.show("请求失败，请重试", Toast.LENGTH_SHORT);
            }
        });
    }

    private void initMoveMarker(final List<TrajectoryBean.ObjBean.DevStateListBean> data) {
        List<LatLng> list = readLatLngs(data);

        aMap.addPolyline(new PolylineOptions().setCustomTexture(BitmapDescriptorFactory.fromResource(R.drawable.custtexture)) //setCustomTextureList(bitmapDescriptors)
                .addAll(list)
                .useGradient(true)
                .width(18));
        // 获取轨迹坐标点
        List<LatLng> points = readLatLngs(data);
        LatLngBounds.Builder b = LatLngBounds.builder();
        for (int i = 0; i < points.size(); i++) {
            b.include(points.get(i));
        }
        LatLngBounds bounds = b.build();
        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));
        if (moveMarker != null) {
            moveMarker.removeMarker();
        }
        moveMarker = new SmoothMoveMarker(aMap);
        if (startMarker != null) {
            if (!startMarker.isRemoved()) {
                startMarker.remove();
            }
        }
        if (endMarker != null) {
            if (!endMarker.isRemoved()) {
                endMarker.remove();
            }
        }
        LatLng startLatLng = new LatLng(list.get(0).latitude, list.get(0).longitude);
        LatLng endLatLng = new LatLng(list.get(list.size() - 1).latitude, list.get(list.size() - 1).longitude);

        MarkerOptions startOpt = new MarkerOptions().position(startLatLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                .zIndex(10)
                .draggable(false);
        startMarker = aMap.addMarker(startOpt);
        MarkerOptions endOpt = new MarkerOptions().position(endLatLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.end))
                .zIndex(10)
                .draggable(false);
        endMarker = aMap.addMarker(endOpt);

        endMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.end));
        moveMarker.setDescriptor(BitmapDescriptorFactory.fromResource(R.drawable.pot));


        /*
        //当移动Marker的当前位置不在轨迹起点，先从当前位置移动到轨迹上，再开始平滑移动
        // LatLng drivePoint = points.get(0);//设置小车当前位置，可以是任意点，这里直接设置为轨迹起点
        LatLng drivePoint = new LatLng(39.980521,116.351905);//设置小车当前位置，可以是任意点
        Pair<Integer, LatLng> pair = PointsUtil.calShortestDistancePoint(points, drivePoint);
        points.set(pair.first, drivePoint);
        List<LatLng> subList = points.subList(pair.first, points.size());
        // 设置滑动的轨迹左边点
        smoothMarker.setPoints(subList);*/

        moveMarker.setPoints(points);//设置平滑移动的轨迹list
        moveMarker.setTotalDuration(40);//设置平滑移动的总时间

        startMarker.setPosition(startLatLng);
        endMarker.setPosition(endLatLng);

        aMap.setInfoWindowAdapter(infoWindowAdapter);
        moveMarker.getMarker().showInfoWindow();
        moveMarker.startSmoothMove();
        moveMarker.setMoveListener(new SmoothMoveMarker.MoveListener() {
            @Override
            public void move(double v) {

                seekbar.setProgress(moveMarker.getIndex());
                LogUtils.logd("lat = " + data.get(moveMarker.getIndex()).getLatLng().getLat() + "   lnt = " + data.get(moveMarker.getIndex()).getLatLng().getLng());
                LogUtils.logd("v = " + v);
                if (v == 0) {
                    moveMarker.getMarker().hideInfoWindow();
                    mMarkerStatus = FINISH_STATUS;
                    Picasso.with(TrajectoryActivity.this).load(R.drawable.stop).into(playImage);
                }
            }
        });
        seekbar.setMax(points.size());
    }

    List<LatLng> points = new ArrayList<>();

    private List<LatLng> readLatLngs(List<TrajectoryBean.ObjBean.DevStateListBean> data) {
        points = new ArrayList<>();
        for (TrajectoryBean.ObjBean.DevStateListBean bean : data) {
            points.add(new LatLng(Double.valueOf(bean.getMapLatLng().getLat()),
                    Double.valueOf(bean.getMapLatLng().getLng())));
        }
        return points;
    }

}
