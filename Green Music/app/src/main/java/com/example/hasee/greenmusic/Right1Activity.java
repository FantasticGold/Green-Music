package com.example.hasee.greenmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Right1Activity extends AppCompatActivity {
  private float width;
  private float height;
  private Bundle bundle = null;
  private ImageView bg_right1 = null;
  private ImageView btn_right1_back = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_right1);
    
    // initialize
    bundle = getIntent().getBundleExtra("size");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
    
    // views
    bg_right1 = findViewById(R.id.iv_right1_bg);
    btn_right1_back = findViewById(R.id.iv_right1_back);
    
    // bg_right1
    params = (RelativeLayout.LayoutParams) bg_right1.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    bg_right1.setLayoutParams(params);
  
    // btn_right1_back
    params = (RelativeLayout.LayoutParams) btn_right1_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    btn_right1_back.setLayoutParams(params);
    
    btn_right1_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//        Right1Activity.this.finish();
        Intent intent = new Intent(Right1Activity.this, Right1MusicActivity.class);
        intent.putExtra("size", bundle);
        startActivity(intent);
      }
    });
  }
}

