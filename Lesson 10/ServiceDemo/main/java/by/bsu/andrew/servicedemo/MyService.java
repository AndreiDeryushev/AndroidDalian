package by.bsu.andrew.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {
    MediaPlayer player;

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        player.setLooping(true);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this,R.raw.xiao_pingguo);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
