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

public class RightActivity extends AppCompatActivity {
  private float width;
  private float height;
  private ViewPager vp_right = null;
  private ImageView iv_right_bg = null;
  private ImageView iv_right_back = null;
  private ImageView iv_right_point = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_right);
    
    // data
    Bundle bundle = getIntent().getBundleExtra("data");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
    
    // views
    vp_right = findViewById(R.id.vp_right);
    iv_right_bg = findViewById(R.id.iv_right_bg);
    iv_right_back = findViewById(R.id.iv_right_back);
    iv_right_point = findViewById(R.id.iv_right_point);
  
    // initialize
    init_vp_right();
    init_iv_right_bg();
    init_iv_right_back();
    init_iv_right_point();
  }
  
  private void init_vp_right() {
    params = (RelativeLayout.LayoutParams) vp_right.getLayoutParams();
    params.width = (int) width;
    params.topMargin = (int) (0.417 * height);
    params.bottomMargin = (int) (0.245 * height);
    vp_right.setLayoutParams(params);
    vp_right.bringToFront();
  
    final int[] iv_right_imgs = {
            R.drawable.iv_right_img1,
            R.drawable.iv_right_img2
    };
    final int[] iv_right_words = {
            R.drawable.iv_right_word1,
            R.drawable.iv_right_word2
    };
    final int[] iv_right_points = {
            R.drawable.iv_right_point1,
            R.drawable.iv_right_point2
    };
    final List<RightFragment> fragments = new ArrayList<>();
  
    for (int i = 0; i < iv_right_imgs.length; ++i) {
      Bundle bundle = new Bundle();
      bundle.putFloat("width", width);
      bundle.putFloat("height", height);
      bundle.putString("group", "right");
      bundle.putInt("id", i);
      
      Intent intent = new Intent(RightActivity.this, InfoActivity.class);
      intent.putExtra("data", bundle);
    
      RightFragment fragment = new RightFragment();
      fragment.bindData(width, height, iv_right_imgs[i], iv_right_words[i], intent);
      fragments.add(fragment);
    }
  
    vp_right.setPageTransformer(false, new MyPageTransformer(this));
    vp_right.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
  
    vp_right.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int i, float v, int i1) {
      
      }
    
      @Override
      public void onPageSelected(int i) {
        i %= iv_right_points.length;
        iv_right_point.setImageResource(iv_right_points[i]);
      }
    
      @Override
      public void onPageScrollStateChanged(int i) {
      
      }
    });
  }
  
  private void init_iv_right_bg() {
    params = (RelativeLayout.LayoutParams) iv_right_bg.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    iv_right_bg.setLayoutParams(params);
  }
  
  private void init_iv_right_back() {
    params = (RelativeLayout.LayoutParams) iv_right_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.048 * height);
    iv_right_back.setLayoutParams(params);
  
    iv_right_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_right_back.setImageResource(R.drawable.btn_right_back_click);
        RightActivity.this.finish();
      }
    });
  }
  
  private void init_iv_right_point() {
    params = (RelativeLayout.LayoutParams) iv_right_point.getLayoutParams();
    params.width = (int) ((1 - 0.401 * 2) * width);
    params.height = (int) (params.width * 111.0 / 681.0);
    params.bottomMargin = (int) (0.154 * height);
    iv_right_point.setLayoutParams(params);
    iv_right_point.bringToFront();
  }
  
}

