package com.example.hasee.greenmusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import pl.droidsonroids.gif.GifImageView;

public class MusicActivity extends AppCompatActivity {
  private int id;
  private float width;
  private float height;
  private String group = null;
  private GifImageView gif_music_bg = null;
  private ImageView iv_music_jump = null;
  private ImageView iv_music_back = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_music);
    
    // data
    Bundle bundle = getIntent().getBundleExtra("data");
    group = bundle.getString("group");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
    id = bundle.getInt("id");
    
    // views
    gif_music_bg = findViewById(R.id.gif_music_bg);
    iv_music_jump = findViewById(R.id.iv_music_jump);
    iv_music_back = findViewById(R.id.iv_music_back);
  
    // initialize
    init_gif_music_bg();
    init_iv_music_jump();
    init_iv_music_back();
  }
  
  void init_gif_music_bg() {
    final int[] gif_music_bg_lefts = {
            R.drawable.gif_music_left1,
            R.drawable.gif_music_left2,
            R.drawable.gif_music_left3,
            R.drawable.gif_music_left4
    };
    final int[] gif_music_bg_rights = {
            R.drawable.gif_music_right1,
            R.drawable.gif_music_right2
    };
  
    if (group.equals("left")) {
      gif_music_bg.setImageResource(gif_music_bg_lefts[id]);
    } else if (group.equals("right")) {
      gif_music_bg.setImageResource(gif_music_bg_rights[id]);
    }
    
    params = (RelativeLayout.LayoutParams) gif_music_bg.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    gif_music_bg.setLayoutParams(params);
  }
  
  void init_iv_music_jump() {
    params = (RelativeLayout.LayoutParams) iv_music_jump.getLayoutParams();
    params.width = (int) (0.135 * width);
    params.height = (int) (params.width * 345.0 / 393.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.15 * height);
    iv_music_jump.setLayoutParams(params);
    
    iv_music_jump.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putFloat("width", width);
        bundle.putFloat("height", height);
        
        Intent intent = new Intent(MusicActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("data", bundle);
        startActivity(intent);
      }
    });
  }
  
  void init_iv_music_back() {
    params = (RelativeLayout.LayoutParams) iv_music_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    iv_music_back.setLayoutParams(params);
  
    iv_music_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_music_back.setImageResource(R.drawable.btn_music_back_click);
        MusicActivity.this.finish();
      }
    });
  }
  
  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
}
