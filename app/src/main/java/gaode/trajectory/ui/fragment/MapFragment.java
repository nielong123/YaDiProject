package gaode.trajectory.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.jaydenxiao.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import gaodedemo.nl.org.gaodedemoapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends BaseFragment {

    @BindView(R.id.car_id)
    TextView carId;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.location_time)
    TextView locationTime;
    @BindView(R.id.mapview)
    MapView mapview;

    AMap aMap;

    public MapFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_map;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mapview.onCreate(savedInstanceState);
        aMap = mapview.getMap();
    }

    @Override
    protected void initData() {

    }


}
