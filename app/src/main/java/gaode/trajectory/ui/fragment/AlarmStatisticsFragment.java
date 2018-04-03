package gaode.trajectory.ui.fragment;

import android.os.Bundle;

import com.jaydenxiao.common.base.BaseFragment;

import gaodedemo.nl.org.gaodedemoapplication.R;

public class AlarmStatisticsFragment extends BaseFragment {

    public AlarmStatisticsFragment() {
        // Required empty public constructor
    }

    public static AlarmStatisticsFragment newInstance() {
        AlarmStatisticsFragment fragment = new AlarmStatisticsFragment();
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
        return R.layout.fragment_alarm_statistics;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }


    @Override
    protected void initData() {

    }

}
