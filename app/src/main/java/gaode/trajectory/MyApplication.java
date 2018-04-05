package gaode.trajectory;

import android.text.TextUtils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.SPUtils;

import cn.jpush.android.api.JPushInterface;
import gaode.trajectory.api.Api;


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
        // 初始化 推送框架 JPush
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        Api.CAR = SPUtils.getSharedStringData(this, "carNum");
        if(TextUtils.isEmpty(Api.CAR)){
            Api.CAR = "013511112222";
        }
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