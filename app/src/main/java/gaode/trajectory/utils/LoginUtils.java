package gaode.trajectory.utils;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

/**
 * Created by nielong123 on 2018/4/2.
 */

public class LoginUtils {

    public static void doLogin() {
        FinalHttp finalHttp = new FinalHttp();
        finalHttp.get("http://180.101.253.139:30002/asset/loginForApp2", new AjaxCallBack<Object>() {
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
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }
}
