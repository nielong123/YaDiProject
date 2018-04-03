package gaode.trajectory.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaydenxiao.common.base.BaseFragment;

import gaodedemo.nl.org.gaodedemoapplication.R;

public class BaseInfoFragment extends BaseFragment {

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
        return R.layout.fragment_base_info;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
