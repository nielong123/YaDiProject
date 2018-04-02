package gaode.trajectory.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jaydenxiao.common.base.BaseActivity;

import gaodedemo.nl.org.gaodedemoapplication.R;

public class BaseInfoActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_info;
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

    }
}
