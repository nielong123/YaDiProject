package gaode.trajectory.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.utils.overlay.SmoothMoveMarker;
import com.bigkoo.pickerview.TimePickerView;
import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.commonutils.TimeUtil;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.squareup.picasso.Picasso;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import gaode.trajectory.adapter.TrajectRunnable;
import gaode.trajectory.api.Api;
import gaode.trajectory.bean.TrajectoryBean;
import gaodedemo.nl.org.gaodedemoapplication.R;

public class TrajectoryFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.start)
    TextView start;
    @BindView(R.id.end)
    TextView end;
    @BindView(R.id.search)
    Button search;
    @BindView(R.id.mapview)
    TextureMapView mapview;
    @BindView(R.id.play_image)
    ImageView playImage;
    @BindView(R.id.play_root)
    RelativeLayout playRoot;
    @BindView(R.id.seekbar)
    SeekBar seekbar;


    private Polyline polyline;

    private Marker startMarker;            //起点

    private Marker endMarker;              //终点

    private TrajectRunnable runnable;

    private boolean isPlaying = false;

    private int maxIndex = 0;

    private SmoothMoveMarker moveMarker;

    List<TrajectoryBean.ObjBean.DevStateListBean> data;

    String tv_start, tv_end;
    AMap aMap;

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
        mapview.onCreate(savedInstanceState);
        aMap = mapview.getMap();
        start.setOnClickListener(this);
        end.setOnClickListener(this);
        search.setOnClickListener(this);
        playImage.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        initMoveMarker();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv_start = TimeUtil.formatData(TimeUtil.dateFormatYMDHMS, date.getTime() / 1000);
                        start.setText(tv_start);
                    }
                }).build().show();
                break;
            case R.id.end:
                new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tv_end = TimeUtil.formatData(TimeUtil.dateFormatYMDHMS, date.getTime() / 1000);
                        end.setText(tv_end);
                    }
                }).build().show();
                break;
            case R.id.search:
                if (TextUtils.isEmpty(tv_end) || TextUtils.isEmpty(tv_start)) {
                    ToastUitl.show("请选择时间", Toast.LENGTH_SHORT);
                    break;
                }
                getTrajectoryHistory();
                break;
            case R.id.play_image:
                if (runnable != null) {
                    if (isPlaying) {
                        runnable.stopPlay();
                        Picasso.with(getActivity()).load(R.drawable.play).into(playImage);
                    } else {
                        runnable.reStartPlay();
                        Picasso.with(getActivity()).load(R.drawable.stop).into(playImage);
                    }
                    isPlaying = !isPlaying;
                } else {
                    Toast.makeText(getActivity(), "请选择一条轨迹", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    /***
     * 绘制轨迹线
     */
    private void displayPolyline() {
        List<LatLng> latlngList = new ArrayList<>();
        for (TrajectoryBean.ObjBean.DevStateListBean bean : data) {
            if (bean != null) {
                LatLng latlng = new LatLng((Double.valueOf(bean.getMapLatLng().getLat())),
                        Double.valueOf(bean.getMapLatLng().getLng()));
                latlngList.add(latlng);
            }
        }
        PolylineOptions option = new PolylineOptions();
        option.zIndex(9);
        option.color(Color.argb(255, 58, 125, 240));
        option.width(15);
        option.addAll(latlngList);
        if (polyline != null) {
            polyline.remove();
        }
        polyline = aMap.addPolyline(option);
    }


    void getTrajectoryHistory() {
        FinalHttp finalHttp = new FinalHttp();
        AjaxParams ajaxParams = new AjaxParams();
        ajaxParams.put("devNo", Api.CAR);
        ajaxParams.put("startTime", tv_start);
        ajaxParams.put("endTime", tv_end);
        ajaxParams.put("size", "10");
        ajaxParams.put("sort", "asc");
        finalHttp.post(Api.URL + "/monitor/car/track", ajaxParams, new AjaxCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                TrajectoryBean trajectoryBean = new Gson().fromJson(s, TrajectoryBean.class);
                data = trajectoryBean.getObj().getDevStateList();
                if (data == null) return;
                if (data.size() <= 2) return;
                maxIndex = data.size();
                displayPolyline();
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }


    private void addPolylineInPlayGround() {
        List<LatLng> list = readLatLngs();
        List<Integer> colorList = new ArrayList<Integer>();

        aMap.addPolyline(new PolylineOptions().setCustomTexture(BitmapDescriptorFactory.fromResource(R.drawable.custtexture)) //setCustomTextureList(bitmapDescriptors)
                .addAll(list)
                .useGradient(true)
                .width(18));
    }


    private void initMoveMarker() {
        addPolylineInPlayGround();
        // 获取轨迹坐标点
        List<LatLng> points = readLatLngs();
        LatLngBounds.Builder b = LatLngBounds.builder();
        for (int i = 0; i < points.size(); i++) {
            b.include(points.get(i));
        }
        LatLngBounds bounds = b.build();
        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));

        moveMarker = new SmoothMoveMarker(aMap);
        // 设置滑动的图标
        moveMarker.setDescriptor(BitmapDescriptorFactory.fromResource(R.drawable.pot));

        /*
        //当移动Marker的当前位置不在轨迹起点，先从当前位置移动到轨迹上，再开始平滑移动
        // LatLng drivePoint = points.get(0);//设置小车当前位置，可以是任意点，这里直接设置为轨迹起点
        LatLng drivePoint = new LatLng(39.980521,116.351905);//设置小车当前位置，可以是任意点
        Pair<Integer, LatLng> pair = PointsUtil.calShortestDistancePoint(points, drivePoint);
        points.set(pair.first, drivePoint);
        List<LatLng> subList = points.subList(pair.first, points.size());
        // 设置滑动的轨迹左边点
        smoothMarker.setPoints(subList);*/

        moveMarker.setPoints(points);//设置平滑移动的轨迹list
        moveMarker.setTotalDuration(40);//设置平滑移动的总时间

//        aMap.setInfoWindowAdapter(infoWindowAdapter);
        moveMarker.setMoveListener(
                new SmoothMoveMarker.MoveListener() {
                    @Override
                    public void move(final double distance) {

                        Log.i("MY", "distance:  " + distance);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                if (infoWindowLayout != null && title != null && moveMarker.getMarker().isInfoWindowShown()) {
//                                    title.setText("距离终点还有： " + (int) distance + "米");
//                                }
//                                if (distance == 0) {
//                                    moveMarker.getMarker().hideInfoWindow();
//                                    mMarkerStatus = FINISH_STATUS;
//                                    mStartButton.setText("开始");
//
//                                }
                            }
                        });
                    }
                });
        moveMarker.getMarker().showInfoWindow();
    }


    private List<LatLng> readLatLngs() {
        List<LatLng> points = new ArrayList<LatLng>();
        for (int i = 0; i < coords.length; i += 2) {
            points.add(new LatLng(coords[i + 1], coords[i]));
        }
        return points;
    }

    private double[] coords = {116.3499049793749, 39.97617053371078,
            116.34978804908442, 39.97619854213431, 116.349674596623,
            39.97623045687959, 116.34955525200917, 39.97626931100656,
            116.34943728748914, 39.976285626595036, 116.34930864705592,
            39.97628129172198, 116.34918981582413, 39.976260803938594,
            116.34906721558868, 39.97623535890678, 116.34895185151584,
            39.976214717128855, 116.34886935936889, 39.976280148755315,
            116.34873954611332, 39.97628182112874, 116.34860763527448,
            39.97626038855863, 116.3484658907622, 39.976306080391836,
            116.34834585430347, 39.976358252119745, 116.34831166130878,
            39.97645709321835, 116.34827643560175, 39.97655231226543,
            116.34824186261169, 39.976658372925556, 116.34825080406188,
            39.9767570732376, 116.34825631960626, 39.976869087779995,
            116.34822111635201, 39.97698451764595, 116.34822901510276,
            39.977079745909876, 116.34822234337618, 39.97718701787645,
            116.34821627457707, 39.97730766147824, 116.34820593515043,
            39.977417746816776, 116.34821013897107, 39.97753930933358
            , 116.34821304891533, 39.977652209132174, 116.34820923399242,
            39.977764016531076, 116.3482045955917, 39.97786190186833,
            116.34822159449203, 39.977958856930286, 116.3482256370537,
            39.97807288885813, 116.3482098441266, 39.978170063673524,
            116.34819564465377, 39.978266951404066, 116.34820541974412,
            39.978380693859116, 116.34819672351216, 39.97848741209275,
            116.34816588867105, 39.978593409607825, 116.34818489339459,
            39.97870216883567, 116.34818473446943, 39.978797222300166,
            116.34817728972234, 39.978893492422685, 116.34816491505472,
            39.978997133775266, 116.34815408537773, 39.97911413849568,
            116.34812908154862, 39.97920553614499, 116.34809495907906,
            39.979308267469264, 116.34805113358091, 39.97939658036473,
            116.3480310509613, 39.979491697188685, 116.3480082124968,
            39.979588529006875, 116.34799530586834, 39.979685789111635,
            116.34798818413954, 39.979801430587926, 116.3479996420353,
            39.97990758587515, 116.34798697544538, 39.980000796262615,
            116.3479912988137, 39.980116318796085, 116.34799204219203,
            39.98021407403913, 116.34798535084123, 39.980325006125696,
            116.34797702460183, 39.98042511477518, 116.34796288754136,
            39.98054129336908, 116.34797509821901, 39.980656820423505,
            116.34793922017285, 39.98074576792626, 116.34792586413015,
            39.98085620772756, 116.3478962642899, 39.98098214824056,
            116.34782449883967, 39.98108306010269, 116.34774758827285,
            39.98115277119176, 116.34761476652932, 39.98115430642997,
            116.34749135408349, 39.98114590845294, 116.34734772765582,
            39.98114337322547, 116.34722082902628, 39.98115066909245,
            116.34708205250223, 39.98114532232906, 116.346963237696,
            39.98112245161927, 116.34681500222743, 39.981136637759604,
            116.34669622104072, 39.981146248090866, 116.34658043260109,
            39.98112495260716, 116.34643721418927, 39.9811107163792,
            116.34631638374302, 39.981085081075676, 116.34614782996252,
            39.98108046779486, 116.3460256053666, 39.981049089345206,
            116.34588814050122, 39.98104839362087, 116.34575119741586,
            39.9810544889668, 116.34562885420186, 39.981040940565734,
            116.34549232235582, 39.98105271658809, 116.34537348820508,
            39.981052294975264, 116.3453513775533, 39.980956549928244
    };


}
