package gaode.trajectory;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.jaydenxiao.common.baseapp.BaseApplication;


public class MyApplication extends BaseApplication {

    public static MyApplication myApp;
    private AMapLocationListener mLocListener = new MyLocationListener();
    private AMapLocationClient mLocationClient = null;
    private OnLocationReceiveListener mOnLocationReceiveListener;
    private AMapLocation aMLocation;

    public static MyApplication getApp() {
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        initLocation();
    }

    public AMapLocation getAppDBLocation() {
        return aMLocation;
    }

    //初始化定位
    private void initLocation() {
        mLocationClient = new AMapLocationClient(this);
        mLocationClient.setLocationListener(mLocListener);
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        option.setInterval(40000l);
        mLocationClient.setLocationOption(option);
        mLocationClient.startLocation();
    }


    public class MyLocationListener implements AMapLocationListener {

        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            // map view ���ٺ��ڴ����½��յ�λ��
            if (amapLocation == null) {
                return;
            }
            aMLocation = amapLocation;
            if (mOnLocationReceiveListener != null) {
                mOnLocationReceiveListener.onLbsReceive(amapLocation);
            }
        }
    }


    public interface OnLocationReceiveListener {
        void onLbsReceive(AMapLocation location);
    }
}