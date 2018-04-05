package gaode.trajectory.ui.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseFragment;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import butterknife.BindView;
import gaode.trajectory.api.Api;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class BaseInfoFragment extends BaseFragment {

    @BindView(R.id.vehicle_information)
    TextView vehicleInformation;
    @BindView(R.id.vehicle_number)
    TextView vehicleNumber;
    @BindView(R.id.text_vehicle_number)
    TextView textVehicleNumber;
    @BindView(R.id.vehicle_state)
    TextView vehicleState;
    @BindView(R.id.text_vehicle_state)
    TextView textVehicleState;
    @BindView(R.id.iv_network)
    ImageView ivNetwork;
    @BindView(R.id.update_time)
    TextView updateTime;
    @BindView(R.id.text_update_time)
    TextView textUpdateTime;
    @BindView(R.id.last_location)
    TextView lastLocation;
    @BindView(R.id.text_last_location)
    TextView textLastLocation;
    @BindView(R.id.layout_vehicle_information)
    RelativeLayout layoutVehicleInformation;
    @BindView(R.id.user_information)
    TextView userInformation;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.text_username)
    TextView textUsername;
    @BindView(R.id.phone_number)
    TextView phoneNumber;
    @BindView(R.id.text_phone_number)
    TextView textPhoneNumber;
    @BindView(R.id.gender)
    TextView gender;
    @BindView(R.id.text_gender)
    TextView textGender;
    @BindView(R.id.area)
    TextView area;
    @BindView(R.id.text_area)
    TextView textArea;
    @BindView(R.id.Usage_Counter)
    TextView UsageCounter;
    @BindView(R.id.text_Usage_Counter)
    TextView textUsageCounter;
    @BindView(R.id.layout_user_information)
    RelativeLayout layoutUserInformation;

    public BaseInfoFragment() {
        // Required empty public constructor
    }

    public static BaseInfoFragment newInstance() {
        BaseInfoFragment fragment = new BaseInfoFragment();
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
        return R.layout.activity_base_infos;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        getData();
    }


    private void getData() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        finalHttp.post(Api.URL + "/monitor/car/getHeart", new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                if (BaseInfoFragment.newInstance().getActivity().isFinishing() || BaseInfoFragment.newInstance().getActivity().isDestroyed()) {
                    return;
                }

            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }

}
