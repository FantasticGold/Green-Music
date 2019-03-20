package com.example.hasee.greenmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Right1MusicActivity extends AppCompatActivity {
  private float width;
  private float height;
  private Bundle bundle = null;
  private ImageView bg_right1_music = null;
  private ImageView btn_right1_music_back = null;
  private ImageView btn_right1_music_start = null;
  private ImageView btn_right1_music_music = null;
  private RelativeLayout.LayoutParams params = null;
  private MediaPlayer player = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_right1_music);
  
    // initialize
    bundle = getIntent().getBundleExtra("size");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
  
    // initialize
    bundle = getIntent().getBundleExtra("size");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
  
    // views
    bg_right1_music = findViewById(R.id.iv_right1_music_bg);
    btn_right1_music_back = findViewById(R.id.iv_right1_music_back);
    btn_right1_music_start = findViewById(R.id.iv_right1_music_start);
    btn_right1_music_music = findViewById(R.id.iv_right1_music_music);
  
    // bg_right1_music
    params = (RelativeLayout.LayoutParams) bg_right1_music.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    bg_right1_music.setLayoutParams(params);
  
    // btn_right1_music_start
    params = (RelativeLayout.LayoutParams) btn_right1_music_start.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 388.0 / 359.0);
    params.rightMargin = (int) (0.203 * width);
    params.topMargin = (int) (0.12 * height);
    btn_right1_music_start.setLayoutParams(params);
  
    // btn_right1_music_music
    params = (RelativeLayout.LayoutParams) btn_right1_music_music.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 388.0 / 359.0);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.19 * height);
    btn_right1_music_music.setLayoutParams(params);
    
    // btn_right1_music_back
    params = (RelativeLayout.LayoutParams) btn_right1_music_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    btn_right1_music_back.setLayoutParams(params);
  
    btn_right1_music_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        btn_right1_music_back.setImageResource(R.drawable.btn_right_back_click);
        Right1MusicActivity.this.finish();
      }
    });
    
  }
}
