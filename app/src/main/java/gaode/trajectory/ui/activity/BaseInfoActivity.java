package gaode.trajectory.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseActivity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import butterknife.BindView;
import butterknife.ButterKnife;
import gaode.trajectory.api.Api;
import gaode.trajectory.bean.UserInfosBean;
import gaode.trajectory.bean.VehicleInfosBean;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class BaseInfoActivity extends BaseActivity {

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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_infos;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        getCarData();
        getUserData();
    }

    private void getCarData() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("devNo", Api.CAR);
        ajaxParams.put("pageSize", "1");
        finalHttp.post("http://180.101.253.139:30002/asset/car/query", new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                if (BaseInfoActivity.this.isFinishing() || BaseInfoActivity.this.isDestroyed()) {
                    return;
                }
                VehicleInfosBean vehicleInfosBean = new Gson().fromJson(s, VehicleInfosBean.class);
                if (vehicleInfosBean == null) return;
                if (vehicleInfosBean.getObj() == null) return;
                if (vehicleInfosBean.getObj() == null && vehicleInfosBean.getObj().getContent() == null)
                    return;

                textVehicleNumber.setText(vehicleInfosBean.getObj().getContent().get(0).getPlateNum());
                textUpdateTime.setText(vehicleInfosBean.getObj().getContent().get(0).getModifyDate());
                textLastLocation.setText(vehicleInfosBean.getObj().getContent().get(0).getAddress());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });

    }

    public void getUserData() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        finalHttp.post(Api.URL + "user/query", new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);

                if (BaseInfoActivity.this.isFinishing() || BaseInfoActivity.this.isDestroyed()) {
                    return;
                }
                UserInfosBean userInfosBean = new Gson().fromJson(s, UserInfosBean.class);
                if (userInfosBean == null) return;
                if (userInfosBean.getObj() == null) return;
                if (userInfosBean.getObj() == null && userInfosBean.getObj().getContent() == null)
                    return;

                textUsername.setText(userInfosBean.getObj().getContent().get(0).getUserName());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }

}
