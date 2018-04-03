package gaode.trajectory.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    TabFragmentPagerAdapter tabFragmentPagerAdapter;

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
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(AlarmStatisticsFragment.newInstance());
        fragments.add(BaseInfoFragment.newInstance());
        fragments.add(MapFragment.newInstance());
        fragments.add(TrajectoryFragment.newInstance());
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
            case R.id.base_info:
                viewPager.setCurrentItem(0);
                break;
            case R.id.monitoring:
                viewPager.setCurrentItem(1);
                break;
            case R.id.alarm_statistics:
                viewPager.setCurrentItem(2);
                break;
            case R.id.history:
                viewPager.setCurrentItem(3);
                break;
        }
    }

}
