package com.example.hasee.greenmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class InfoActivity extends AppCompatActivity {
  private int id;
  private float width;
  private float height;
  private String group = null;
  private Bundle bundle = null;
  private ImageView iv_info_bg = null;
  private ImageView iv_info_start = null;
  private ImageView iv_info_music = null;
  private ImageView iv_info_back = null;
  private Intent music = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);
  
    // bundle
    bundle = getIntent().getBundleExtra("data");
    group = bundle.getString("group");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
    id = bundle.getInt("id");

    // views
    iv_info_bg = findViewById(R.id.iv_start_bg);
    iv_info_start = findViewById(R.id.iv_start_switch);
    iv_info_music = findViewById(R.id.iv_start_back);
    iv_info_back = findViewById(R.id.iv_info_back);
    
    // initialize
    init_iv_info_bg();
    init_iv_info_start();
    init_iv_info_music();
    init_iv_info_back();
  }
  
  void init_iv_info_bg() {
    params = (RelativeLayout.LayoutParams) iv_info_bg.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    iv_info_bg.setLayoutParams(params);
    
    final int[] iv_info_bg_lefts = {
            R.drawable.iv_info_bg_left1,
            R.drawable.iv_info_bg_left2,
            R.drawable.iv_info_bg_left3,
            R.drawable.iv_info_bg_left4
    };
    final int[] iv_info_bg_rights = {
            R.drawable.iv_info_bg_right1,
            R.drawable.iv_info_bg_right2
    };
    
    if (group.equals("left")) {
      iv_info_bg.setImageResource(iv_info_bg_lefts[id]);
    } else if (group.equals("right")) {
      iv_info_bg.setImageResource(iv_info_bg_rights[id]);
    }
  }
  
  void init_iv_info_start() {
    params = (RelativeLayout.LayoutParams) iv_info_start.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 388.0 / 359.0);
    params.rightMargin = (int) (0.203 * width);
    params.topMargin = (int) (0.12 * height);
    iv_info_start.setLayoutParams(params);
    
    iv_info_start.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_info_start.setImageResource(R.drawable.btn_info_start_click);
        Intent intent = new Intent(InfoActivity.this, StartActivity.class);
        intent.putExtra("data", bundle);
        startActivity(intent);
      }
    });
  }
  
  void init_iv_info_music() {
    params = (RelativeLayout.LayoutParams) iv_info_music.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 388.0 / 359.0);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.19 * height);
    iv_info_music.setLayoutParams(params);
  
    final int[] music_lefts = {
            R.raw.music_left1,
            R.raw.music_left2,
            R.raw.music_left3,
            R.raw.music_left4,
    };
    final int[] music_rights = {
            R.raw.music_right1,
            R.raw.music_right2
    };
  
    music = new Intent(InfoActivity.this, MusicService.class);
    if (group.equals("left")) {
      music.putExtra("id", music_lefts[id]);
    } else if (group.equals("right")) {
      music.putExtra("id", music_rights[id]);
    }
    
    iv_info_music.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_info_music.setImageResource(R.drawable.btn_info_music_click);
        startService(music);
        Intent intent = new Intent(InfoActivity.this, MusicActivity.class);
        intent.putExtra("data", bundle);
        startActivity(intent);
      }
    });
  }
  
  void init_iv_info_back() {
    params = (RelativeLayout.LayoutParams) iv_info_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    iv_info_back.setLayoutParams(params);
  
    iv_info_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_info_back.setImageResource(R.drawable.btn_info_back_click);
        InfoActivity.this.finish();
      }
    });
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    iv_info_start.setImageResource(R.drawable.btn_info_start);
    iv_info_music.setImageResource(R.drawable.btn_info_music);
    stopService(music);
  }
  
  @Override
  protected void onDestroy() {
    super.onDestroy();
    stopService(music);
  }
}
