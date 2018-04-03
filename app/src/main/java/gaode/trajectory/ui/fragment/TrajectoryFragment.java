package gaode.trajectory.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaydenxiao.common.base.BaseFragment;

import gaodedemo.nl.org.gaodedemoapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrajectoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrajectoryFragment extends BaseFragment {

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

    }

    @Override
    protected void initData() {

    }

}
