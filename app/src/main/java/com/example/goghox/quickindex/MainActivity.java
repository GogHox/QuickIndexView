package com.example.goghox.quickindex;

import android.content.pm.FeatureInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private boolean isClickQuickIndex = false;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShow = (TextView) findViewById(R.id.tv_show);

        QuickIndexView qiv = (QuickIndexView)findViewById(R.id.qiv);

        qiv.setOnLetterSelectListener(new QuickIndexView.OnLetterSelectListener() {
            @Override
            public void onSelect(String letter) {
                tvShow.setText(letter);
                tvShow.setVisibility(View.VISIBLE);

                AlphaAnimation anim = new AlphaAnimation(0, 1);
                anim.setFillAfter(true);
                anim.setDuration(0);
                tvShow.startAnimation(anim);
            }

            @Override
            public void onSelectOver() {
                AlphaAnimation anim = new AlphaAnimation(1, 0);
                anim.setFillAfter(true);
                anim.setDuration(800);
                tvShow.startAnimation(anim);
            }
        });
        qiv.setTextColor("#555555");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }
}
