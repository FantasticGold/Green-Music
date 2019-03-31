package com.example.hasee.greenmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class StartActivity extends AppCompatActivity {
  private final boolean POINT = false;
  private final boolean LINE = true;
  private final int[] iv_start_point_lefts = {
          R.drawable.iv_start_point_left1,
          R.drawable.iv_start_point_left2,
          R.drawable.iv_start_point_left3,
          R.drawable.iv_start_point_left4
  };
  private final int[] iv_start_point_rights = {
          R.drawable.iv_start_point_right1,
          R.drawable.iv_start_point_right2
  };
  private final int[] iv_start_line_lefts = {
          R.drawable.iv_start_line_left1,
          R.drawable.iv_start_line_left2,
          R.drawable.iv_start_line_left3,
          R.drawable.iv_start_line_left4
  };
  private final int[] iv_start_line_rights = {
          R.drawable.iv_start_line_right1,
          R.drawable.iv_start_line_right2
  };
  
  private int id;
  private float width;
  private float height;
  private String group = null;
  private boolean state;
  private ImageView iv_start_bg = null;
  private ImageView iv_start_switch = null;
  private ImageView iv_start_back = null;
  private RelativeLayout.LayoutParams params = null;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);
    
    // bundle
    Bundle bundle = getIntent().getBundleExtra("data");
    group = bundle.getString("group");
    width = bundle.getFloat("width");
    height = bundle.getFloat("height");
    id = bundle.getInt("id");
    
    // views
    iv_start_bg = findViewById(R.id.iv_start_bg);
    iv_start_switch = findViewById(R.id.iv_start_switch);
    iv_start_back = findViewById(R.id.iv_start_back);
    
    // initialize
    init_iv_start_bg();
    init_iv_start_switch();
    init_iv_start_back();
  
    state = POINT;
    set_state();
  }
  
  void set_state() {
    // iv_start_bg
    if (state == POINT) {
      if (group.equals("left")) {
        iv_start_bg.setImageResource(iv_start_point_lefts[id]);
      } else if (group.equals("right")) {
        iv_start_bg.setImageResource(iv_start_point_rights[id]);
      }
    } else if (state == LINE) {
      if (group.equals("left")) {
        iv_start_bg.setImageResource(iv_start_line_lefts[id]);
      } else if (group.equals("right")) {
        iv_start_bg.setImageResource(iv_start_line_rights[id]);
      }
    }
    
    // iv_start_switch
    if (state == POINT) {
      iv_start_switch.setImageResource(R.drawable.btn_start_point);
    } else if (state == LINE) {
      iv_start_switch.setImageResource(R.drawable.btn_start_line);
    }
  }
  
  void init_iv_start_bg() {
    params = (RelativeLayout.LayoutParams) iv_start_bg.getLayoutParams();
    params.width = (int) width;
    params.height = (int) height;
    iv_start_bg.setLayoutParams(params);
  }
  
  void init_iv_start_switch() {
    params = (RelativeLayout.LayoutParams) iv_start_switch.getLayoutParams();
    params.width = (int) (0.12 * width);
    params.height = (int) (params.width * 390.0 / 352.0);
    params.rightMargin = (int) (0.203 * width);
    params.topMargin = (int) (0.12 * height);
    iv_start_switch.setLayoutParams(params);
    
    iv_start_switch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        state = !state;
        set_state();
      }
    });
  }
  
  void init_iv_start_back() {
    params = (RelativeLayout.LayoutParams) iv_start_back.getLayoutParams();
    params.width = (int) (0.148 * width);
    params.height = (int) (params.width * 388.0 / 441.0);
    params.rightMargin = (int) (0.068 * width);
    params.topMargin = (int) (0.19 * height);
    iv_start_back.setLayoutParams(params);
  
    iv_start_back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        iv_start_back.setImageResource(R.drawable.btn_start_back_click);
        StartActivity.this.finish();
      }
    });
  }
  
}
