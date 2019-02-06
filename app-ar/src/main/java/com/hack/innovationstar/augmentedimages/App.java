package com.hack.innovationstar.augmentedimages;

import android.app.Application;
import android.os.Looper;
import android.util.Log;

import com.samsung.multiscreen.Service;
import com.samsung.multiscreen.util.RunUtil;


public class App extends Application
{

    public static final String TAG = "ABHINAW-QUIZAPP";

    private static App instance;
    private static Config config;
    //private PhotoShareWebApplicationHelper photoShare;
    /**
     * The device to connect to;
     */
    public Service service = null;

    public static App getInstance() {
        return instance;
    }

    public App()
    {
        instance = this;
    }

    ///////////////////////////////////added for the Image to load @Author Abhinaw////////////////
    @Override
    public void onCreate()
    {
        super.onCreate();
        RunUtil.runInBackground(new Runnable() {

            @Override
            public void run() {
                long startTime = System.nanoTime();
                Looper.prepare();
                ImageInfoUtils.getImageInfos(getApplicationContext());
                long endTime = System.nanoTime();
                Log.d(TAG, "getImageInfos execution in " + ((float) (endTime - startTime) / 1000000f) + " ms");
            }
        });

        config = Config.newInstance(this);

        //  photoShare = PhotoShareWebApplicationHelper.getInstance(this);
        Log.d("Entrou", "---------------> App.java<---------------------------");
    }

    /*  public PhotoShareWebApplicationHelper getPhotoShare() {
          return photoShare;
      }*/
    public Config getConfig() {
        return config;
    }

    public static String str_deviceName;
    public static String str_userImagePath;
    public static String str_userName;
}
