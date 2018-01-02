package com.eric.android.view.letterbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LetterBar letter_bar;
    private TextView tv_letter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_letter = findViewById(R.id.tv_letter);
        letter_bar = findViewById(R.id.letter_bar);
        letter_bar.setOnLetterChangeListener(new LetterBar.OnLetterChangeListner() {
            @Override
            public void onLetterChanged(String letter) {
                tv_letter.setVisibility(View.VISIBLE);
                tv_letter.setAlpha(1);
                tv_letter.setText(letter);
            }

            @Override
            public void onLetterChoosed(String letter) {
                tv_letter.animate().alpha(0).setDuration(500).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        tv_letter.setVisibility(View.GONE);
                    }
                });
            }
        });
    }
}
