package gaode.trajectory.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.jaydenxiao.common.commonutils.SPUtils;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;
import gaode.trajectory.ui.activity.AlarmDetailActivity;
import gaode.trajectory.ui.activity.AlarmStatisticsActivity;

/**
 * Created by nielong123 on 2018/4/4.
 */

public class JPushNotificationReceiver extends BroadcastReceiver
{
    private static final String TAG = "JPushNotificationReceiver";
    private NotificationManager notificationManager;
    private String type;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (null == notificationManager)
        {
            notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        Bundle bundle = intent.getExtras();
        String registrationID = JPushInterface.getRegistrationID(context);

        SPUtils.setSharedStringData(context, "registrationID", registrationID);

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction()))
        {
            Logger.d(TAG, "JPush用户注册成功");

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction()))
        {
            Logger.d(TAG, "接受到推送下来的自定义消息");

        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction()))
        {
            Logger.d(TAG, "接受到推送下来的通知");

            receivingNotification(context, bundle);

        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()))
        {
            Logger.d(TAG, "用户点击打开了通知");

            openNotification(context, bundle);

        } else
        {
            Logger.d(TAG, "Unhandled intent - " + intent.getAction());
        }
    }

    private void receivingNotification(Context context, Bundle bundle)
    {
        String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        Logger.d(TAG, " title : " + title);
        String message = bundle.getString(JPushInterface.EXTRA_ALERT);
        Logger.d(TAG, "message : " + message);
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Logger.d(TAG, "extras : " + extras);
    }

    private void openNotification(Context context, Bundle bundle)
    {
        // 携带参数
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        // 标题
        String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        // 内容
        String content = bundle.getString(JPushInterface.EXTRA_ALERT);
        // 打印日志
        Log.e("Notification", extras + "," + title + "," + content);

        try
        {
            JSONObject extrasJson = new JSONObject(extras);
            type = extrasJson.optString("type");
        }
        catch (Exception e)
        {
            Logger.w(TAG, "Unexpected: extras is not a valid json", e);
            return;
        }

        if ("alert".equals(type))
        {
            Intent mIntent = new Intent(context, AlarmDetailActivity.class);
            mIntent.putExtras(bundle);
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mIntent);
        }
    }
}