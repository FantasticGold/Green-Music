package com.example.hasee.greenmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LeftFragment extends Fragment {
  private float width = 0;
  private float height = 0;
  private int id_left_img;
  private int id_left_word;
  private Intent intent = null;
  private ImageView iv_left_img = null;
  private ImageView iv_left_word = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_left, null);
  
    // views
    iv_left_img = rootView.findViewById(R.id.iv_left_img);
    iv_left_word = rootView.findViewById(R.id.iv_left_word);
  
    // initialize
    init_iv_left_img();
    init_iv_left_word();
  
    return rootView;
  }
  
  void init_iv_left_img() {
    params = (RelativeLayout.LayoutParams) iv_left_img.getLayoutParams();
    params.height = (int) ((1-0.417-0.4) * height);
    iv_left_img.setLayoutParams(params);
    iv_left_img.setImageResource(id_left_img);
    
    iv_left_img.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(intent);
      }
    });
  }
  
  void init_iv_left_word() {
    params = (RelativeLayout.LayoutParams) iv_left_word.getLayoutParams();
    params.bottomMargin = (int) (0.0285 * height);
    iv_left_word.setLayoutParams(params);
    iv_left_word.setImageResource(id_left_word);
  }
  
  void bindData(float width, float height, int iv_right_img, int iv_right_word, Intent intent) {
    this.width = width;
    this.height = height;
    this.id_left_img = iv_right_img;
    this.id_left_word = iv_right_word;
    this.intent = intent;
  }
}
