package com.example.hasee.greenmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static java.lang.Math.min;

public class MainActivity extends AppCompatActivity {
  private float width;
  private float height;
  private ImageView iv_main_bg = null;
  private ImageView iv_main_left = null;
  private ImageView iv_main_right = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    // data
    Bundle bundle = getIntent().getBundleExtra("data");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
  
    // views
    iv_main_bg = findViewById(R.id.iv_main_bg);
    iv_main_left = findViewById(R.id.iv_main_left);
    iv_main_right = findViewById(R.id.iv_main_right);
    
    // initialize
    init_iv_main_bg();
    init_iv_main_left();
    init_iv_main_right();
  }
  
  private void init_iv_main_bg() {
    params = (RelativeLayout.LayoutParams) iv_main_bg.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    iv_main_bg.setLayoutParams(params);
  }
  
  private void init_iv_main_left() {
    params = (RelativeLayout.LayoutParams) iv_main_left.getLayoutParams();
    params.width = (int) (0.135 * width);
    params.height = (int) (params.width * 457.0 / 372.0);
    params.leftMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.19 * height);
    iv_main_left.setLayoutParams(params);
  
    iv_main_left.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_main_left.setImageResource(R.drawable.btn_main_left_click);
        
        Bundle bundle = new Bundle();
        bundle.putFloat("width", width);
        bundle.putFloat("height", height);
        
        Intent intent = new Intent(MainActivity.this, LeftActivity.class);
        intent.putExtra("data", bundle);
        startActivity(intent);
      }
    });
  }
  private void init_iv_main_right() {
    params = (RelativeLayout.LayoutParams) iv_main_right.getLayoutParams();
    params.width = (int) (0.16 * width);
    params.height = (int) (params.width * 413.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.19 * height);
    iv_main_right.setLayoutParams(params);
  
    iv_main_right.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_main_right.setImageResource(R.drawable.btn_main_right_click);
        
        Bundle bundle = new Bundle();
        bundle.putFloat("width", width);
        bundle.putFloat("height", height);
        
        Intent intent = new Intent(MainActivity.this, RightActivity.class);
        intent.putExtra("data", bundle);
        startActivity(intent);
      }
    });
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    iv_main_right.setImageResource(R.drawable.btn_main_right);
    iv_main_left.setImageResource(R.drawable.btn_main_left);
  }
}