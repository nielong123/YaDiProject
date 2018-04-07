package gaode.trajectory.ui.activity;

import android.os.Bundle;

import com.aspsine.irecyclerview.IRecyclerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.LogUtils;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import gaode.trajectory.api.Api;
import gaode.trajectory.bean.AlarmStatisticsBean;
import gaode.trajectory.widget.TitleView;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class AlarmStatisticsActivity extends BaseActivity {

    @BindView(R.id.title_view)
    TitleView titleView;
    @BindView(R.id.chart)
    BarChart chart;
    @BindView(R.id.recyclerview)
    IRecyclerView recyclerview;

    List<BarEntry> entries = new ArrayList<>();
    private List<List<String>> data;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_alarm_statistics;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("报警统计");

        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
//                LogUtils.logd("x = " + e.getX() + "y = " + e.getY());
                Bundle bundle = new Bundle();
                bundle.putString("month", data.get(((int) h.getX())).get(0));
                startActivity(AlarmDetailActivity.class, bundle);
            }

            @Override
            public void onNothingSelected() {
                LogUtils.logd("nothing...");
            }
        });
    }

    @Override
    protected void initData() {
        getData();
    }


    private void getData() {
        FinalHttp finalHttp = new FinalHttp();
        finalHttp.post(Api.URL + "test/device/getAlertHistory", new AjaxCallBack<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                AlarmStatisticsBean bean = new Gson().fromJson(s, AlarmStatisticsBean.class);
                if (AlarmStatisticsActivity.this.isDestroyed() || AlarmStatisticsActivity.this.isFinishing())
                    return;
                if (bean.getObj() == null) return;
                data = bean.getObj().getContent();
                for (int i = 0; i < data.size(); i++) {
                    List<String> item = data.get(i);
                    entries.add(new BarEntry(i, Float.valueOf(item.get(1))));
                }
                BarDataSet set = new BarDataSet(entries, "BarDataSet");

                ArrayList<String> xValues = new ArrayList<String>();
                for (int i = 0; i < data.size(); i++) {
                    xValues.add(data.get(i).get(1) + "");
                }
                BarData barData = new BarData(set);
                barData.setBarWidth(0.7f); // 设置自定义条形宽度
                chart.setData(barData);
                chart.setFitBars(true); // 使x轴完全适合所有条形
                chart.invalidate(); // refresh
                Description description = new Description();
                description.setText("月度报表");
                chart.setDescription(description);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }
}
