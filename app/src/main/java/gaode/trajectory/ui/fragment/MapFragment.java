package gaode.trajectory.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.jaydenxiao.common.base.BaseFragment;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import butterknife.BindView;
import gaode.trajectory.api.Api;
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
//    @BindView(R.id.mapview)
//    TextureMapView mapview;
    @BindView(R.id.checkbox)
    CheckBox checkbox;


    AMap aMap;

    public MapFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
    protected void initView(Bundle savedInstanceState) {
//        mapview.onCreate(savedInstanceState);
//        if (aMap == null) {
//            aMap = mapview.getMap();
//        }
//        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                sendTerminalControl(b);
//            }
//        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        mapview.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
//        mapview.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
//        mapview.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (mapview != null) {
//            mapview.onDestroy();
//        }
//        aMap = null;
    }

    @Override
    protected void initData() {
        getCarData();
    }

    private void sendTerminalControl(boolean isStop) {

        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("clientId", "013511112222");
        if (isStop) {
            ajaxParams.put("defences", "0");
        } else {
            ajaxParams.put("defences", "1");
        }
        finalHttp.post(Api.URL + "test/device/terminalControl", ajaxParams, new AjaxCallBack<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });

    }


    private void getCarData() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("devNo", "013655558888");
        ajaxParams.put("startTime", "2018-04-03 05:08:29");
        ajaxParams.put("endTime", "2018-04-04 06:08:29");
        ajaxParams.put("size", "0");
        ajaxParams.put("sort", "asc");
        finalHttp.post(Api.URL + "/monitor/car/track", new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });

    }

}
