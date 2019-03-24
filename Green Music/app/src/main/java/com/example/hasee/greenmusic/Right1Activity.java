package com.example.hasee.greenmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class Right1Activity extends AppCompatActivity {
  private float width;
  private float height;
  private Bundle bundle = null;
  private ImageView bg_right1 = null;
  private ViewPager vp_right1 = null;
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
    vp_right1 = findViewById(R.id.vp_right1);
    btn_right1_back = findViewById(R.id.iv_right1_back);
  
    // vp_right1
    params = (RelativeLayout.LayoutParams) vp_right1.getLayoutParams();
    params.width = (int) width;
    params.topMargin = (int) (0.417 * height);
    params.bottomMargin = (int) (0.245 * height);
    vp_right1.setLayoutParams(params);
    vp_right1.bringToFront();
    
    final List<MyFragment> fragments = new ArrayList<>();
    final int[] iv_right1_btn_ids = {
            R.drawable.iv_right1_btn1,
            R.drawable.iv_right1_btn2
    };
    final int[] iv_right1_word_ids = {
            R.drawable.iv_right1_word1,
            R.drawable.iv_right1_word2
    };
    final Intent[] intents = {
            new Intent(Right1Activity.this, Right1InfoActivity.class),
            new Intent(Right1Activity.this, Right2InfoActivity.class)
    };
    for (Intent intent: intents) {
      intent.putExtra("size", bundle);
    }
    for (int i = 0; i < 2; ++i) {
      MyFragment fragment = new MyFragment();
      fragment.init(width, height);
      fragments.add(fragment);
    }
    
    final ImageView[] ivs = {
           findViewById(R.id.iv_p1),
           findViewById(R.id.iv_p2)
    };
    ivs[0].bringToFront();
    ivs[1].bringToFront();
    vp_right1.setPageTransformer(false, new MyPageTransformer(this));
    vp_right1.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
      @Override
      public Fragment getItem(int i) {
        i %= fragments.size();
        MyFragment fragment = fragments.get(i);
//        i %= 2;
//        MyFragment fragment = new MyFragment();
//        fragment.init(width, height);
        fragment.bindData(iv_right1_btn_ids[i], iv_right1_word_ids[i], intents[i]);
        return fragment;
      }
  
      @Override
      public int getCount() {
        return 2;
      }
    });
//    vp_right1.setCurrentItem(20000000);
    vp_right1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int i, float v, int i1) {
    
      }
  
      @Override
      public void onPageSelected(int i) {
        for (int j = 0; j < ivs.length; ++j) {
          if (i == j) {
            ivs[j].setImageResource(R.drawable.btn_main_left);
          } else {
            ivs[j].setImageResource(R.drawable.btn_main_right);
          }
        }
      }
  
      @Override
      public void onPageScrollStateChanged(int i) {
    
      }
    });
  
    // bg_right1
    params = (RelativeLayout.LayoutParams) bg_right1.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    bg_right1.setLayoutParams(params);
  
    // btn_right1_back
    params = (RelativeLayout.LayoutParams) btn_right1_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.048 * height);
    btn_right1_back.setLayoutParams(params);
    
    btn_right1_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        btn_right1_back.setImageResource(R.drawable.btn_right_back_click);
        Right1Activity.this.finish();
      }
    });
  }
}

