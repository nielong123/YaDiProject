package gaode.trajectory.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.jaydenxiao.common.base.BaseActivity;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import butterknife.BindView;
import butterknife.ButterKnife;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class MapActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.mapview)
    MapView mapview;
    @BindView(R.id.car_id)
    TextView carId;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.location_time)
    TextView locationTime;
    @BindView(R.id.base_info)
    TextView baseInfo;
    @BindView(R.id.alarm_statistics)
    TextView alarmStatistics;
    @BindView(R.id.history)
    TextView history;

    AMap aMap;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_map;
    }

    @Override
    protected void initPresenter() {
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mapview.onCreate(savedInstanceState);
        aMap = mapview.getMap();
        baseInfo.setOnClickListener(this);
        alarmStatistics.setOnClickListener(this);
        history.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        getCars();
    }


    void getCars() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("pageIndex", "1");
        ajaxParams.put("pageSize", "1");
        ajaxParams.put("plateNumOrDev ", "1");
        ajaxParams.put("deptIds", "1");
        finalHttp.post("http://180.101.253.139:30002/asset/admin/monitor/car/query", ajaxParams, new AjaxCallBack<Object>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                if (MapActivity.this.isFinishing() || MapActivity.this.isDestroyed()) {

                }
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.base_info:
                startActivity(BaseInfoActivity.class);
                break;
            case R.id.alarm_statistics:
                startActivity(AlarmStatisticsActivity.class);
                break;
            case R.id.history:
                startActivity(TrajectoryActivity.class);
                break;
        }
    }
}
