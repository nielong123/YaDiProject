package gaode.trajectory.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by nl on 2016/11/22.
 */

public final class TrajectRunnable implements Runnable {

    private static final int MOVEMARKER = 0;           //移动点
    private static final int MOVEFINISH = 1;           //移动完成
    private static final int MOVESTOP = 2;             //停止移动
    private static final int MOVESTART = 3;            //开始移动
    private static final int MOVERESTART = 4;          //重启移动
    private static final int FORCERESTART = 5;            //强制更改到初始状态

    private static final int NOTINDEX = -1;

    private int playIndex, maxIndex;
    private long DELYED = 100l;
    private boolean isStop;
    private TrajectListener listener;
    private TrajectHandler handler;

    public TrajectRunnable(int maxIndex, TrajectListener trajectListener) {
        this.maxIndex = maxIndex - 1;       //数据的集合长度要比size小1
        this.listener = trajectListener;
        this.handler = new TrajectHandler(this);
    }

    /****
     * 停止播放
     */
    public void stopPlay() {
        isStop = true;

    }

    /***
     * 重启播放
     */
    public void reStartPlay() {
        isStop = false;
        handler.postDelayed(this, DELYED);
    }

    /****
     * 设置播放进度
     *
     * @param index
     */
    public void setPlayIndex(int index) {
        this.playIndex = index;
        isStop = true;
    }

    @Override
    public void run() {
        if (maxIndex != 0) {
            if (playIndex == 0) {
                sendMsg(MOVESTART, NOTINDEX);
            }
            sendMsg(MOVEMARKER, playIndex++);
            if (playIndex == maxIndex) {
                sendMsg(MOVEFINISH, NOTINDEX);
            }
            if (!isStop) {
                handler.postDelayed(this, DELYED);
            }
        }
    }

    /****
     * @param what
     * @param index != -1
     */
    private void sendMsg(int what, int index) {
        Message msg = new Message();
        msg.what = what;
        if (index != -1) {
            Bundle bundle = new Bundle();
            bundle.putInt("index", index);
            msg.setData(bundle);
        }
        handler.sendMessage(msg);
    }

    class TrajectHandler extends Handler {
        WeakReference<TrajectRunnable> trajectRunnable;

        public TrajectHandler(TrajectRunnable trajectRunnable) {
            super(Looper.getMainLooper());
            this.trajectRunnable = new WeakReference<TrajectRunnable>(trajectRunnable);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            TrajectRunnable runnable = trajectRunnable.get();
            switch (msg.what) {
                case MOVEMARKER:
                    Bundle bundle = msg.getData();
                    if (runnable.listener != null) {
                        runnable.listener.onUpdataPlaying(bundle.getInt("index"));
                    }
                    break;
                case MOVEFINISH:
                    playIndex = 0;
                    if (runnable.listener != null) {
                        isStop = true;
                        runnable.listener.onFinishPlaying();
                    }
                    break;
                case MOVESTOP:
                    if (runnable.listener != null) {
                        runnable.listener.onStopPlaying();
                    }
                    break;
                case MOVESTART:
                    if (runnable.listener != null) {
                        runnable.listener.onStartPlaying();
                    }
                    break;
//                case UPDATAMOVEINDEX:
//                    break;
                case MOVERESTART:
                    break;
                case FORCERESTART:
                    break;
            }
        }
    }

    public interface TrajectListener {

        public void onUpdataPlaying(int index);

        public void onStartPlaying();

        public void onStopPlaying();

        public void onFinishPlaying();
    }
}
