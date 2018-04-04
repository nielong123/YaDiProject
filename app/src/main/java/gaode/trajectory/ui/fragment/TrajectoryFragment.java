package gaode.trajectory.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.aspsine.irecyclerview.IRecyclerView;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseFragment;
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
import butterknife.Unbinder;
import gaode.trajectory.adapter.TrajectRunnable;
import gaode.trajectory.api.Api;
import gaode.trajectory.bean.Bean;
import gaode.trajectory.bean.TrajectoryBean;
import gaode.trajectory.config.Config;
import gaode.trajectory.ui.activity.TrajectoryActivity;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class TrajectoryFragment extends BaseFragment implements View.OnClickListener {

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


    private Polyline polyline;

    private Marker startMarker;            //起点

    private Marker endMarker;              //终点

    private Marker moveMarker;             //可移动的点

    private TrajectRunnable runnable;

    private boolean isPlaying = false;

    private int maxIndex = 0;

    List<TrajectoryBean.ObjBean.DevStateListBean> data;

    String tv_start, tv_end;
    AMap aMap;

    public TrajectoryFragment() {
        // Required empty public constructor
    }

    public static TrajectoryFragment newInstance() {
        TrajectoryFragment fragment = new TrajectoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_trajectory;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mapview.onCreate(savedInstanceState);
        aMap = mapview.getMap();
        start.setOnClickListener(this);
        end.setOnClickListener(this);
        search.setOnClickListener(this);
        playImage.setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv_start = TimeUtil.formatData(TimeUtil.dateFormatYMDHMS, date.getTime() / 1000);
                        start.setText(tv_start);
                    }
                }).build().show();
                break;
            case R.id.end:
                new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
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
                if (runnable != null) {
                    if (isPlaying) {
                        runnable.stopPlay();
                        Picasso.with(getActivity()).load(R.drawable.play).into(playImage);
                    } else {
                        runnable.reStartPlay();
                        Picasso.with(getActivity()).load(R.drawable.stop).into(playImage);
                    }
                    isPlaying = !isPlaying;
                } else {
                    Toast.makeText(getActivity(), "请选择一条轨迹", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    /***
     * 绘制轨迹线
     */
    private void displayPolyline() {
        List<LatLng> latlngList = new ArrayList<>();
        for (TrajectoryBean.ObjBean.DevStateListBean bean : data) {
            if (bean != null) {
                LatLng latlng = new LatLng((Double.valueOf(bean.getMapLatLng().getLat())),
                        Double.valueOf(bean.getMapLatLng().getLng()));
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


    void getTrajectoryHistory() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("devNo", "013655558888");
        ajaxParams.put("startTime", "2018-04-03 05:08:29");
        ajaxParams.put("endTime", "2018-04-04 06:08:29");
        ajaxParams.put("size", "10");
        ajaxParams.put("sort", "asc");
        finalHttp.post(Api.URL + "/monitor/car/track", ajaxParams, new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                TrajectoryBean trajectoryBean = new Gson().fromJson(s, TrajectoryBean.class);
                data = trajectoryBean.getObj().getDevStateList();
                if (data == null) return;
                if (data.size() <= 2) return;
                maxIndex = data.size();
                displayPolyline();
                displayMarkers();
                runnable = new TrajectRunnable(maxIndex, trajectListener);
                runnable.run();
                isPlaying = true;
                seekbar.setMax(maxIndex);
                seekbar.setProgress(0);
                Picasso.with(getActivity()).load(R.drawable.stop).into(playImage);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }


    private void displayMarkers() {

        LatLng startLatLng = new LatLng((Double.valueOf(data.get(0).getMapLatLng().getLat())),
                Double.valueOf(data.get(0).getMapLatLng().getLng()));
        LatLng endLatLng = new LatLng(Double.valueOf(data.get(maxIndex - 1).getMapLatLng().getLat()),
                Double.valueOf(data.get(maxIndex - 1).getMapLatLng().getLng()));

        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLatLng, Config.ZoomLevel));
        if (moveMarker == null) {
            MarkerOptions markerOptions = new MarkerOptions().setFlat(true).anchor(0.5f, 0.5f)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pot))
                    .position(startLatLng).zIndex(12).title("信息");
            moveMarker = aMap.addMarker(markerOptions);
            moveMarker.showInfoWindow();
        }
        moveMarker.setPosition(startLatLng);

        if (startMarker == null) {
            MarkerOptions odev = new MarkerOptions().position(startLatLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start))
                    .zIndex(10)
                    .draggable(false);
            startMarker = (aMap.addMarker(odev));
        }
        startMarker.setPosition(startLatLng);

        if (endMarker == null) {
            MarkerOptions odev1 = new MarkerOptions().position(endLatLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end)).zIndex(10).draggable(false);//
            endMarker = (aMap.addMarker(odev1));
        }
        endMarker.setPosition(endLatLng);
    }


    private void upDataMoveMarker(int index) {
        try {
            TrajectoryBean.ObjBean.DevStateListBean bean = data.get(index);
            LatLng latLng = new LatLng(Double.valueOf(bean.getMapLatLng().getLat()), Double.valueOf(bean.getMapLatLng().getLng()));
            if (moveMarker != null) {
                moveMarker.setPosition(latLng);
                moveMarker.setObject(bean);
            }
        } catch (Exception e) {
            LogUtils.loge(e.getMessage());
        }
    }


    private TrajectRunnable.TrajectListener trajectListener = new TrajectRunnable.TrajectListener() {
        @Override
        public void onUpdataPlaying(int index) {
            if (index == maxIndex) {
                seekbar.setProgress(maxIndex - 1);
                upDataMoveMarker(maxIndex - 1);
            } else {
                seekbar.setProgress(index);
                upDataMoveMarker(index);
            }
        }

        @Override
        public void onStartPlaying() {
            LogUtils.logd("startPlaying");
        }

        @Override
        public void onStopPlaying() {
            LogUtils.logd("onStopPlaying");
        }

        @Override
        public void onFinishPlaying() {
            Picasso.with(getActivity()).load(R.drawable.play).into(playImage);
            isPlaying = false;
        }
    };

}
