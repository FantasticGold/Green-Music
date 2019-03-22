package com.example.hasee.greenmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Left1Activity extends AppCompatActivity {
  private float width;
  private float height;
  private Bundle bundle = null;
  private ImageView bg_left1 = null;
  private ImageView btn_left1_next = null;
  private ImageView btn_left1_back = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_left1);
  
    // initialize
    bundle = getIntent().getBundleExtra("size");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
  
    // views
    bg_left1 = findViewById(R.id.iv_left1_bg);
    btn_left1_next = findViewById(R.id.iv_left1_next);
    btn_left1_back = findViewById(R.id.iv_left1_back);
  
    // bg_left1
    params = (RelativeLayout.LayoutParams) bg_left1.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    bg_left1.setLayoutParams(params);
  
    // btn_left1_next
    params = (RelativeLayout.LayoutParams) btn_left1_next.getLayoutParams();
    params.leftMargin = (int) (0.339 * width);
    params.rightMargin = (int) (0.339 * width);
    params.topMargin = (int) (0.417 * height);
    params.bottomMargin = (int) (0.4 * height);
    btn_left1_next.setLayoutParams(params);
  
    btn_left1_next.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(Left1Activity.this, Left1InfoActivity.class);
        intent.putExtra("size", bundle);
        startActivity(intent);
      }
    });
  
    // btn_left1_back
    params = (RelativeLayout.LayoutParams) btn_left1_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    btn_left1_back.setLayoutParams(params);
  
    btn_left1_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        btn_left1_back.setImageResource(R.drawable.btn_left_back_click);
        Left1Activity.this.finish();
      }
    });
    
  }
}
