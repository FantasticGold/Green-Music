package com.example.hasee.greenmusic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class WelcomActivity extends AppCompatActivity {
  final private int WAIT_TIME = 2000;
  
  private float width;
  private float height;
  private ImageView iv_welcome_bg = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
    
    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    height = metrics.heightPixels;
    width = metrics.widthPixels;
    
    if (height > width * 16/9) {
      height = width * 16/9;
    } else {
      width = height * 9/16;
    }
    
    iv_welcome_bg = findViewById(R.id.iv_welcome_bg);
    params = (RelativeLayout.LayoutParams) iv_welcome_bg.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    iv_welcome_bg.setLayoutParams(params);
  
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Bundle bundle = new Bundle();
        bundle.putFloat("width", width);
        bundle.putFloat("height", height);
  
        Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
        intent.putExtra("data", bundle);
        WelcomActivity.this.finish();
        startActivity(intent);
      }
    }, WAIT_TIME);
  }
}
