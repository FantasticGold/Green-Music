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

public class MyFragment extends Fragment {
  private int iv_fragment_btn_id;
  private int iv_fragment_word_id;
  private float width = 0;
  private float height = 0;
  private RelativeLayout.LayoutParams params = null;
  private Intent intent;
  
  public void init(float width, float height) {
    this.width = width;
    this.height = height;
  }
  
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_item, null);
    
    // views
    ImageView iv_fragment_btn = rootView.findViewById(R.id.iv_fragment_btn);
    ImageView iv_fragment_word = rootView.findViewById(R.id.iv_fragment_word);
    
    // iv_fragment_btn
    params = (RelativeLayout.LayoutParams) iv_fragment_btn.getLayoutParams();
    params.height = (int) ((1-0.417-0.4) * height);
    iv_fragment_btn.setLayoutParams(params);
    iv_fragment_btn.setImageResource(iv_fragment_btn_id);
    
    iv_fragment_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(intent);
      }
    });
    
    // iv_fragment_word
    params = (RelativeLayout.LayoutParams) iv_fragment_word.getLayoutParams();
    params.topMargin = (int) (0.0285 * height);
    iv_fragment_word.setLayoutParams(params);
    iv_fragment_word.setImageResource(iv_fragment_word_id);
  
    return rootView;
  }
  
  void bindData(int iv_fragment_btn_id, int iv_fragment_word_id, Intent intent) {
    this.iv_fragment_btn_id = iv_fragment_btn_id;
    this.iv_fragment_word_id = iv_fragment_word_id;
    this.intent = intent;
  }
}
