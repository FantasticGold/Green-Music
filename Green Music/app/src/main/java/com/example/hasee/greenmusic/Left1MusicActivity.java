package com.example.hasee.greenmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Left1MusicActivity extends AppCompatActivity {
  private float width;
  private float height;
  private Bundle bundle = null;
  private ImageView bg_left1_music = null;
  private ImageView btn_left1_music_back = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_left1_music);
  
    // initialize
    bundle = getIntent().getBundleExtra("size");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
    
    // views
    bg_left1_music = findViewById(R.id.iv_left1_music_bg);
    btn_left1_music_back = findViewById(R.id.iv_left1_music_back);

    // bg_left1
    params = (RelativeLayout.LayoutParams) bg_left1_music.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    bg_left1_music.setLayoutParams(params);

    // btn_left1_music_back
    params = (RelativeLayout.LayoutParams) btn_left1_music_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    btn_left1_music_back.setLayoutParams(params);

    btn_left1_music_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        btn_left1_music_back.setImageResource(R.drawable.btn_music_back_click);
        Left1MusicActivity.this.finish();
      }
    });
  }
}
