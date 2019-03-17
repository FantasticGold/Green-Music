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
  private Bundle bundle = null;
  private ImageView bg_main = null;
  private ImageView btn_main_left = null;
  private ImageView btn_main_right = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    // initialize
    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    height = metrics.heightPixels;
    width = min(metrics.widthPixels, height * 9 / 16);
    
    bundle = new Bundle();
    bundle.putFloat("width", width);
    bundle.putFloat("height", height);
    
    // views
    bg_main = findViewById(R.id.iv_main_bg);
    btn_main_left = findViewById(R.id.iv_main_left);
    btn_main_right = findViewById(R.id.iv_main_right);
    
    // bg_main
    params = (RelativeLayout.LayoutParams) bg_main.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    bg_main.setLayoutParams(params);
    
    // btn_main_left
    params = (RelativeLayout.LayoutParams) btn_main_left.getLayoutParams();
    params.width = (int) (0.135 * width);
    params.leftMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.19 * height);
    btn_main_left.setLayoutParams(params);
  
    // btn_main_right
    params = (RelativeLayout.LayoutParams) btn_main_right.getLayoutParams();
    params.width = (int) (0.16 * width);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.19 * height);
    btn_main_right.setLayoutParams(params);
    
    btn_main_right.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Right1Activity.class);
        intent.putExtra("size", bundle);
        startActivity(intent);
      }
    });
  }
}
