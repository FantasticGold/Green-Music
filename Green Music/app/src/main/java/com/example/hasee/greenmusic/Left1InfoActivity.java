package com.example.hasee.greenmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Left1InfoActivity extends AppCompatActivity {
  private float width;
  private float height;
  private Bundle bundle = null;
  private ImageView bg_left1_info = null;
  private ImageView btn_left1_info_back = null;
  private ImageView btn_left1_info_start = null;
  private ImageView btn_left1_info_music = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_left1_info);
  
    // initialize
    bundle = getIntent().getBundleExtra("size");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
  
    // views
    bg_left1_info = findViewById(R.id.iv_left1_info_bg);
    btn_left1_info_back = findViewById(R.id.iv_left1_info_back);
    btn_left1_info_start = findViewById(R.id.iv_left1_info_start);
    btn_left1_info_music = findViewById(R.id.iv_left1_info_music);
  
    // bg_left1_info
    params = (RelativeLayout.LayoutParams) bg_left1_info.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    bg_left1_info.setLayoutParams(params);
  
    // btn_left1_info_start
    params = (RelativeLayout.LayoutParams) btn_left1_info_start.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 388.0 / 359.0);
    params.rightMargin = (int) (0.203 * width);
    params.topMargin = (int) (0.12 * height);
    btn_left1_info_start.setLayoutParams(params);
  
    // btn_left1_info_music
    params = (RelativeLayout.LayoutParams) btn_left1_info_music.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 388.0 / 359.0);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.19 * height);
    btn_left1_info_music.setLayoutParams(params);
    
    btn_left1_info_music.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        btn_left1_info_music.setImageResource(R.drawable.btn_music_click);
        Intent intent = new Intent(Left1InfoActivity.this, Left1MusicActivity.class);
        intent.putExtra("size", bundle);
        startActivity(intent);
      }
    });
  
    // btn_left1_info_back
    params = (RelativeLayout.LayoutParams) btn_left1_info_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    btn_left1_info_back.setLayoutParams(params);
  
    btn_left1_info_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        btn_left1_info_back.setImageResource(R.drawable.btn_info_back_click);
        Left1InfoActivity.this.finish();
      }
    });
  
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    btn_left1_info_music.setImageResource(R.drawable.btn_music);
  }
}
