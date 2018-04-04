package gaode.trajectory.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.aspsine.irecyclerview.universaladapter.ViewHolderHelper;
import com.aspsine.irecyclerview.universaladapter.recyclerview.CommonRecycleViewAdapter;
import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.TimeUtil;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import butterknife.BindView;
import gaode.trajectory.bean.AlarmDetailBean;
import gaode.trajectory.widget.SpaceItemDecoration;
import gaode.trajectory.widget.TitleView;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class AlarmDetailActivity extends BaseActivity {

    @BindView(R.id.title_view)
    TitleView titleView;
    @BindView(R.id.recyclerview)
    IRecyclerView recyclerview;

    String month;

    AlarmDetailBean alarmDetailBean;

    CommonRecycleViewAdapter commonRecycleViewAdapter;


    final int pageSize = 15;
    int pageIndex = 1;

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
        recyclerview.setLoadMoreEnabled(true);
        recyclerview.setRefreshEnabled(true);
        recyclerview.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(View loadMoreView) {
                pageIndex++;
                getData();
            }
        });
        recyclerview.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageIndex = 1;
                getData();
            }
        });
    }

    @Override
    protected void initData() {
        month = getIntent().getExtras().getString("month");
        getData();
    }

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
                if (AlarmDetailActivity.this.isFinishing() || AlarmDetailActivity.this.isDestroyed()) {
                    return;
                }
                recyclerview.setRefreshing(false);
                alarmDetailBean = new Gson().fromJson(s, AlarmDetailBean.class);
                if (alarmDetailBean.getObj() == null) return;
                commonRecycleViewAdapter.addAll(alarmDetailBean.getObj().getContent());
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                recyclerview.setRefreshing(false);
            }
        });
    }


}
