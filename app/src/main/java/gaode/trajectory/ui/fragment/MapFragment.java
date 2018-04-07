package gaode.trajectory.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.commonutils.TimeUtil;
import com.jaydenxiao.common.commonutils.ToastUitl;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import gaode.trajectory.api.Api;
import gaode.trajectory.bean.CarOnTimeInfoBean;
import gaodedemo.nl.org.gaodedemoapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends BaseFragment {

    @BindView(R.id.car_id)
    TextView carId;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.location_time)
    TextView locationTime;
    @BindView(R.id.mapview)
    TextureMapView mapview;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.state)
    ImageView state;

    Marker marker;

    AMap aMap;

    static MapFragment mapFragment;


    static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            getCarData();
        }
    };

    public MapFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance() {
        if (mapFragment == null) {
            synchronized (MapFragment.class) {
                if (mapFragment == null) {
                    mapFragment = new MapFragment();
                    Bundle args = new Bundle();
                    mapFragment.setArguments(args);
                    return mapFragment;
                }
            }
        }
        return mapFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_map;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapview.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mapview.getMap();
        }
        aMap.moveCamera(CameraUpdateFactory.zoomTo(7f));
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sendTerminalControl(b);
            }
        });
        timer.schedule(timerTask, 2000, 5000);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapview.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapview.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapview.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mapview != null) {
            mapview.onDestroy();
        }
        aMap = null;
    }

    @Override
    protected void initData() {

    }

    private void sendTerminalControl(boolean isStop) {

        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("clientId", Api.CAR);
        if (isStop) {
            ajaxParams.put("defences", "1");
        } else {
            ajaxParams.put("defences", "0");
        }
        finalHttp.post(Api.URL + "test/device/terminalControl", ajaxParams, new AjaxCallBack<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                ToastUitl.showShort("操作成功");
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });

    }


    static private void getCarData() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("devNos[]", Api.CAR);
        finalHttp.post(Api.URL + "monitor/test/car/getHeart", ajaxParams, new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                CarOnTimeInfoBean carOnTimeInfoBean = null;
                try {
                    carOnTimeInfoBean = new Gson().fromJson(s, CarOnTimeInfoBean.class);
                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }
                if (carOnTimeInfoBean == null) return;
                if (carOnTimeInfoBean.getMsg() != null) {
                    ToastUitl.showShort(carOnTimeInfoBean.getMsg());
                }
                if (carOnTimeInfoBean.getObj() == null) {
                    return;
                }
                MapFragment.newInstance().updata(carOnTimeInfoBean);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });

    }

    private void updata(final CarOnTimeInfoBean carOnTimeInfoBean) {
        getMyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                carOnTimeInfoBean.getObj().getDetail().get(0).getStatus().getDetail
//                if( carOnTimeInfoBean.getObj().get(0).getDevState().ge defence){
//                    state
//                }
                carId.setText(carOnTimeInfoBean.getObj().getDetail().get(0).getDevNo());
                address.setText(carOnTimeInfoBean.getObj().getDetail().get(0).getPoi());
                locationTime.setText("时间:" + TimeUtil.formatDataFuck(carOnTimeInfoBean.getObj().getDetail().get(0).getGpsStamp()));
                if (marker != null) {
                    if (!marker.isRemoved()) {
                        marker.remove();
                    }
                }
                double lat = Double.valueOf(carOnTimeInfoBean.getObj().getDetail().get(0).getMapLatLng().getLat());
                double lng = Double.valueOf(carOnTimeInfoBean.getObj().getDetail().get(0).getMapLatLng().getLng());
                LatLng latLng = new LatLng(lat, lng);
                MarkerOptions startOpt = new MarkerOptions().position(latLng)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pot))
                        .zIndex(10)
                        .draggable(false);
                marker = MapFragment.newInstance().aMap.addMarker(startOpt);
                aMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        });
    }


    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            handler.sendEmptyMessage(0);
        }
    };

}
