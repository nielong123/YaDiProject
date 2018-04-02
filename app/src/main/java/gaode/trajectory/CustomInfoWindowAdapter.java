package gaode.trajectory;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Marker;

import bean.Bean;
import gaodedemo.nl.org.gaodedemoapplication.R;

/**
 * Created by nl on 2016/11/23.
 */

public final class CustomInfoWindowAdapter implements AMap.InfoWindowAdapter {

    private Context context;

    public CustomInfoWindowAdapter(Context context) {
        this.context = context;
    }


    @Override
    public View getInfoWindow(Marker marker) {
        View infoWindowView = LayoutInflater.from(context).inflate(R.layout.history_map_info_window, null);
        setViewContent(marker, infoWindowView);
        return infoWindowView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }


    private void setViewContent(Marker marker, View view) {

        InfoWindowHolder infoWindowHolder = null;
        if (infoWindowHolder == null) {
            infoWindowHolder = new InfoWindowHolder();
            infoWindowHolder.vehNo = (TextView) view.findViewById(R.id.veh_no);
            infoWindowHolder.pointIndex = (TextView) view.findViewById(R.id.point_index);
            infoWindowHolder.status = (TextView) view.findViewById(R.id.status);
            infoWindowHolder.mileage = (TextView) view.findViewById(R.id.mileage);
            infoWindowHolder.driver = (TextView) view.findViewById(R.id.driver);
            infoWindowHolder.oil = (TextView) view.findViewById(R.id.oil);
            infoWindowHolder.time = (TextView) view.findViewById(R.id.time);
            infoWindowHolder.location = (TextView) view.findViewById(R.id.location);
            view.setTag(infoWindowHolder);
        } else {
            infoWindowHolder = (InfoWindowHolder) view.getTag();
        }
        Bean.ReturnValueBean.DataListBean data = (Bean.ReturnValueBean.DataListBean) marker.getObject();
        infoWindowHolder.vehNo.setText(data.getVehicleNo());
        infoWindowHolder.mileage.setText("总里程 : " + String.valueOf((float) data.getMileage() * 1.0 / 1000) + "km");
    }


    class InfoWindowHolder {

        TextView vehNo;
        TextView pointIndex;
        TextView status;
        TextView mileage;
        TextView driver;
        TextView oil;
        TextView time;
        TextView location;

    }
}
