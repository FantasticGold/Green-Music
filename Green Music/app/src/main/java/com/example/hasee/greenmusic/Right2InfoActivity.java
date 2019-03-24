package com.example.hasee.greenmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Right2InfoActivity extends AppCompatActivity {
  private float width;
  private float height;
  private Bundle bundle = null;
  private ImageView bg_right2_info = null;
  private ImageView btn_right2_info_back = null;
  private ImageView btn_right2_info_start = null;
  private ImageView btn_right2_info_music = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_right2_info);
    
    // initialize
    bundle = getIntent().getBundleExtra("size");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
    
    // views
    bg_right2_info = findViewById(R.id.iv_right2_info_bg);
    btn_right2_info_back = findViewById(R.id.iv_right2_info_back);
    btn_right2_info_start = findViewById(R.id.iv_right2_info_start);
    btn_right2_info_music = findViewById(R.id.iv_right2_info_music);
    
    // bg_right2_info
    params = (RelativeLayout.LayoutParams) bg_right2_info.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    bg_right2_info.setLayoutParams(params);
    
    // btn_right2_info_start
    params = (RelativeLayout.LayoutParams) btn_right2_info_start.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 388.0 / 359.0);
    params.rightMargin = (int) (0.203 * width);
    params.topMargin = (int) (0.12 * height);
    btn_right2_info_start.setLayoutParams(params);
    
    // btn_right2_info_music
    params = (RelativeLayout.LayoutParams) btn_right2_info_music.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 388.0 / 359.0);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.19 * height);
    btn_right2_info_music.setLayoutParams(params);
    
    // btn_right2_info_back
    params = (RelativeLayout.LayoutParams) btn_right2_info_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    btn_right2_info_back.setLayoutParams(params);
    
    btn_right2_info_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        btn_right2_info_back.setImageResource(R.drawable.btn_info_back_click);
        Right2InfoActivity.this.finish();
      }
    });
    
  }
}
