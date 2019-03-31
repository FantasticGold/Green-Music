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

public class RightFragment extends Fragment {
  private float width = 0;
  private float height = 0;
  private int id_right_img;
  private int id_right_word;
  private Intent intent = null;
  private ImageView iv_right_img = null;
  private ImageView iv_right_word = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_right, null);
    
    // views
    iv_right_img = rootView.findViewById(R.id.iv_right_img);
    iv_right_word = rootView.findViewById(R.id.iv_right_word);
    
    // initialize
    init_iv_right_img();
    init_iv_right_word();
  
    return rootView;
  }
  
  void init_iv_right_img() {
    params = (RelativeLayout.LayoutParams) iv_right_img.getLayoutParams();
    params.height = (int) ((1-0.417-0.4) * height);
    iv_right_img.setLayoutParams(params);
    iv_right_img.setImageResource(id_right_img);
  
    iv_right_img.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(intent);
      }
    });
  }
  
  void init_iv_right_word() {
    params = (RelativeLayout.LayoutParams) iv_right_word.getLayoutParams();
    params.topMargin = (int) (0.0285 * height);
    iv_right_word.setLayoutParams(params);
    iv_right_word.setImageResource(id_right_word);
  }
  
  void bindData(float width, float height, int iv_right_img, int iv_right_word, Intent intent) {
    this.width = width;
    this.height = height;
    this.id_right_img = iv_right_img;
    this.id_right_word = iv_right_word;
    this.intent = intent;
  }
}
