package com.example.angao;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.btn_vp_skip)
    Button btnVpSkip;
    @BindView(R.id.iv_vp_img)
    ImageView ivVpImg;
    @BindView(R.id.tv_vp_count)
    TextView tvVpCount;

    int count = 3;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        initView();
        initTimer();
    }

    private void initTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvVpCount.setText(count+"s");
                        count--;
                        if (count==0){
                            startActivity(new Intent(ViewPagerActivity.this,MainActivity.class));
                            finish();
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    private void initView() {
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator alpha = ObjectAnimator.ofFloat(ivVpImg, "alpha", 0, 0.5f);

        animatorSet.setDuration(3000);
        animatorSet.play(alpha);
        animatorSet.start();
    }

    @OnClick(R.id.btn_vp_skip)
    public void onViewClicked() {
        startActivity(new Intent(ViewPagerActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
    }
}
