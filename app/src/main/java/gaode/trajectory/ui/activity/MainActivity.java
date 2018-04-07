package gaode.trajectory.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.SPUtils;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import gaode.trajectory.api.Api;
import gaode.trajectory.bean.RegisterIdBean;
import gaode.trajectory.bean.UserInfosBean;
import gaode.trajectory.ui.fragment.AlarmStatisticsFragment;
import gaode.trajectory.ui.fragment.BaseInfoFragment;
import gaode.trajectory.ui.fragment.MapFragment;
import gaode.trajectory.ui.fragment.TrajectoryFragment;
import gaode.trajectory.widget.CustomViewPager;
import gaode.trajectory.widget.TabFragmentPagerAdapter;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.view_pager)
    CustomViewPager viewPager;
    @BindView(R.id.base_info)
    TextView baseInfo;
    @BindView(R.id.alarm_statistics)
    TextView alarmStatistics;
    @BindView(R.id.history)
    TextView history;
    @BindView(R.id.monitoring)
    TextView monitoring;
    @BindView(R.id.setting)
    LinearLayout setting;

    TabFragmentPagerAdapter tabFragmentPagerAdapter;

    @Override
    protected void onStart() {
        //傳送registerId
        String registrationID = SPUtils.getSharedStringData(mContext, "registrationID");
        setRegisterId(registrationID);
        super.onStart();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        baseInfo.setOnClickListener(this);
        alarmStatistics.setOnClickListener(this);
        history.setOnClickListener(this);
        monitoring.setOnClickListener(this);
        setting.setOnClickListener(this);
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(MapFragment.newInstance());
//        fragments.add(BaseInfoFragment.newInstance());
//        fragments.add(AlarmStatisticsFragment.newInstance());
//        fragments.add(TrajectoryFragment.newInstance());
        tabFragmentPagerAdapter = new TabFragmentPagerAdapter(fm, fragments);
        viewPager.setAdapter(tabFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setScanScroll(false);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.monitoring:
//                viewPager.setCurrentItem(0);
                changeImage(0);
                break;
            case R.id.base_info:
                startActivity(BaseInfoActivity.class);
//                viewPager.setCurrentItem(1);
//                changeImage(1);
                break;
            case R.id.alarm_statistics:
                startActivity(AlarmDetailActivity.class);
//                changeImage(2);
//                viewPager.setCurrentItem(2);
                break;
            case R.id.history:
                startActivity(TrajectoryActivity.class);
//                changeImage(3);
//                viewPager.setCurrentItem(3);
                break;
            case R.id.setting:
                startActivity(SettingActivity.class);
                break;
        }
    }


    void changeImage(int resId) {
        switch (resId) {
            case 0:
                setDrawT(monitoring, R.drawable.location_red, R.color.color_orange);
                setDrawT(baseInfo, R.drawable.car_gray, R.color.gray);
                setDrawT(alarmStatistics, R.drawable.police_gray, R.color.gray);
                setDrawT(history, R.drawable.history_gray, R.color.gray);
                break;
            case 1:
                setDrawT(monitoring, R.drawable.location_gray, R.color.gray);
                setDrawT(baseInfo, R.drawable.car_red, R.color.color_orange);
                setDrawT(alarmStatistics, R.drawable.police_gray, R.color.gray);
                setDrawT(history, R.drawable.history_gray, R.color.gray);
                break;
            case 2:
                setDrawT(monitoring, R.drawable.location_gray, R.color.gray);
                setDrawT(baseInfo, R.drawable.car_gray, R.color.gray);
                setDrawT(alarmStatistics, R.drawable.police_red, R.color.color_orange);
                setDrawT(history, R.drawable.history_gray, R.color.gray);
                break;
            case 3:
                setDrawT(monitoring, R.drawable.location_gray, R.color.gray);
                setDrawT(baseInfo, R.drawable.car_gray, R.color.gray);
                setDrawT(alarmStatistics, R.drawable.police_gray, R.color.gray);
                setDrawT(history, R.drawable.history_red, R.color.color_orange);
                break;
        }
    }


    private void setDrawT(TextView textView, int redId, int colorId) {
        Drawable top = getResources().getDrawable(redId);// 获取res下的图片drawable
        top.setBounds(0, 0, top.getMinimumWidth(), top.getMinimumHeight());// 一定要设置setBounds();
        textView.setCompoundDrawables(null, top, null, null);
        textView.setTextColor(getResources().getColor(colorId));
    }


    /**
     * 傳送registerId
     */
    public void setRegisterId(String regiId) {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("regiId", regiId);
        finalHttp.post(Api.URL + "test/device/registration", ajaxParams, new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                RegisterIdBean registerIdBean = new Gson().fromJson(s, RegisterIdBean.class);
                String msg = registerIdBean.getMsg();
                Log.e("MainActivity", msg);


            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }

}
