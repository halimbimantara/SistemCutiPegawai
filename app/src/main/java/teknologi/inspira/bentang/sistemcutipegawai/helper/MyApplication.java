package teknologi.inspira.bentang.sistemcutipegawai.helper;

import android.app.Application;

import teknologi.inspira.bentang.sistemcutipegawai.util.ConnectivityReceiver;

/**
 * Created by halim on 10/3/2016.
 */

public class MyApplication extends Application {
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
