package gaode.trajectory.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.TimeUtil;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import gaode.trajectory.bean.AlarmDetailBean;
import gaode.trajectory.widget.SpaceItemDecoration;
import gaode.trajectory.widget.TitleView;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class AlarmDetailActivity extends BaseActivity {

    @BindView(R.id.title_view)
    TitleView titleView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    String month;

    AlarmDetailBean alarmDetailBean;

    CommonRecycleViewAdapter commonRecycleViewAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_alarm_detail;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("报警详情");
        commonRecycleViewAdapter = new CommonRecycleViewAdapter<AlarmDetailBean.ObjBean.ContentBean>(this, R.layout.layout_item_alarm_detail) {
            @Override
            public void convert(ViewHolderHelper helper, AlarmDetailBean.ObjBean.ContentBean contentBean) {
                ((TextView) helper.getView(R.id.time)).setText(TimeUtil.formatData(TimeUtil.dateFormatYMDHMS, Long.valueOf(contentBean.getAlertStartTimes()) / 1000));
                ((TextView) helper.getView(R.id.address)).setText(contentBean.getPosition() + contentBean.getRegion());
                ((TextView) helper.getView(R.id.event)).setText(contentBean.getAlertEvent());
            }

        };
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview.addItemDecoration(new SpaceItemDecoration(10));
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(commonRecycleViewAdapter);
    }

    @Override
    protected void initData() {
        month = getIntent().getExtras().getString("month");
        getData();
    }


    final int pageSize = 15;
    int pageIndex = 1;

    private void getData() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("pageIndex", pageIndex + "");
        ajaxParams.put("pageSize", pageSize + "");
        ajaxParams.put("month", month);
        finalHttp.post("http://180.101.253.139:30002/asset/test/device/getAlerDetail", ajaxParams, new AjaxCallBack<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                if (AlarmDetailActivity.this.isFinishing() || AlarmDetailActivity.this.isDestroyed())
                    return;
                alarmDetailBean = new Gson().fromJson(s, AlarmDetailBean.class);
                if (alarmDetailBean.getObj() == null) return;
                commonRecycleViewAdapter.addAll(alarmDetailBean.getObj().getContent());

            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }


}
