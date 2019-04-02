package com.example.hasee.greenmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class LeftActivity extends AppCompatActivity {
  private float width;
  private float height;
  private ViewPager vp_left = null;
  private ImageView iv_left_bg = null;
  private ImageView iv_left_back = null;
  private ImageView iv_left_point = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_left);
  
    // data
    Bundle bundle = getIntent().getBundleExtra("data");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
  
    // views
    vp_left = findViewById(R.id.vp_left);
    iv_left_bg = findViewById(R.id.iv_left_bg);
    iv_left_back = findViewById(R.id.iv_left_back);
    iv_left_point = findViewById(R.id.iv_left_point);
    
    // initialize
    init_vp_left();
    init_iv_left_bg();
    init_iv_left_back();
    init_iv_left_point();
  
  }
  
  private void init_vp_left() {
    params = (RelativeLayout.LayoutParams) vp_left.getLayoutParams();
    params.width = (int) width;
    params.topMargin = (int) (0.294 * height);
    params.bottomMargin = (int) (0.245 * height);
    vp_left.setLayoutParams(params);
    vp_left.bringToFront();
    
    final int[] iv_left_imgs = {
            R.drawable.iv_left_img1,
            R.drawable.iv_left_img2,
            R.drawable.iv_left_img3,
            R.drawable.iv_left_img4
    };
    final int[] iv_left_words = {
            R.drawable.iv_left_word1,
            R.drawable.iv_left_word2,
            R.drawable.iv_left_word3,
            R.drawable.iv_left_word4
    };
    final int[] iv_left_points = {
            R.drawable.iv_left_point1,
            R.drawable.iv_left_point2,
            R.drawable.iv_left_point3,
            R.drawable.iv_left_point4
    };
    final List<LeftFragment> fragments = new ArrayList<>();
    
    for (int i = 0; i < iv_left_imgs.length; ++i) {
      Bundle bundle = new Bundle();
      bundle.putFloat("width", width);
      bundle.putFloat("height", height);
      bundle.putString("group", "left");
      bundle.putInt("id", i);
      
      Intent intent = new Intent(LeftActivity.this, InfoActivity.class);
      intent.putExtra("data", bundle);
      
      LeftFragment fragment = new LeftFragment();
      fragment.bindData(width, height, iv_left_imgs[i], iv_left_words[i], intent);
      fragments.add(fragment);
    }
    
    vp_left.setPageTransformer(false, new MyPageTransformer(this));
    vp_left.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
      @Override
      public Fragment getItem(int i) {
        i %= fragments.size();
        return fragments.get(i);
      }
      
      @Override
      public int getCount() {
        return fragments.size();
      }
    });
    
    vp_left.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int i, float v, int i1) {
      
      }
      
      @Override
      public void onPageSelected(int i) {
        i %= iv_left_points.length;
        iv_left_point.setImageResource(iv_left_points[i]);
      }
      
      @Override
      public void onPageScrollStateChanged(int i) {
      
      }
    });
  }
  
  private void init_iv_left_bg() {
    params = (RelativeLayout.LayoutParams) iv_left_bg.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    iv_left_bg.setLayoutParams(params);
  }
  
  private void init_iv_left_back() {
    params = (RelativeLayout.LayoutParams) iv_left_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 413.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.bottomMargin = (int) (0.048 * height);
    iv_left_back.setLayoutParams(params);
    
    iv_left_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_left_back.setImageResource(R.drawable.btn_left_back_click);
        LeftActivity.this.finish();
      }
    });
  }
  
  private void init_iv_left_point() {
    params = (RelativeLayout.LayoutParams) iv_left_point.getLayoutParams();
    params.width = (int) ((1 - 0.401 * 2) * width);
    params.height = (int) (params.width * 111.0 / 681.0);
    params.bottomMargin = (int) (0.154 * height);
    iv_left_point.setLayoutParams(params);
    iv_left_point.bringToFront();
  }
}
