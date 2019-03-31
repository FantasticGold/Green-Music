package com.example.hasee.greenmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;

public class MusicService extends Service {
  private int id;
  private MediaPlayer player = null;
  
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
  
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    id = intent.getIntExtra("id", 0);
    player = MediaPlayer.create(this, id);
    player.setLooping(true);
    player.start();
    return super.onStartCommand(intent, flags, startId);
  }
  
  @Override
  public void onDestroy() {
    player.stop();
    super.onDestroy();
  }
}
