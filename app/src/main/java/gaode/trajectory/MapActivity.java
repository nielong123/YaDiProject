package gaode.trajectory;

import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.jaydenxiao.common.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class MapActivity extends BaseActivity {

    @BindView(R.id.mapview)
    MapView mapview;

    AMap aMap;


    @Override
    protected int getLayoutId() {
        ;
        return R.layout.activity_map;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
    }


    @Override
    protected void initData() {

    }

}
