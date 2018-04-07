package gaode.trajectory.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.SPUtils;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.parse.codec.binary.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import gaode.trajectory.api.Api;
import gaode.trajectory.widget.TitleView;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.car_num)
    EditText carNum;
    @BindView(R.id.title_view)
    TitleView titleView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("编号");
    }

    @Override
    protected void initData() {

    }

    public void onSave(View view) {
        if (TextUtils.isEmpty(carNum.getText().toString().trim())) {
            ToastUitl.showShort("必填");
            return;
        }
        SPUtils.setSharedStringData(this, "carNum", carNum.getText().toString().trim());
        Api.CAR = carNum.getText().toString().trim();
        ToastUitl.showShort("保存成功");
        finish();
    }
}
