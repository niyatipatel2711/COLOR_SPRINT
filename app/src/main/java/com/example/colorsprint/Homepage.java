package com.example.colorsprint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    ViewPager slideViewPager;
    LinearLayout layout;
    Button prev, next;

    private int mCurrentPage;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        slideViewPager = findViewById(R.id.vPager);
        layout = findViewById(R.id.linear);
        prev = findViewById(R.id.prevBtn);
        next = findViewById(R.id.nextBtn);

        sliderAdapter = new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(next.getText().toString().equals("Finish")){
                    Intent intent = new Intent(getApplicationContext(), scanActivity.class);
                    startActivity(intent);
                }
                else {
                    slideViewPager.setCurrentItem(mCurrentPage + 1);
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        slideViewPager.addOnPageChangeListener(viewListener);

    }
    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        layout.removeAllViews();

        for(int i=0; i<mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.fullwhite));

            layout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.blue));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
                addDotsIndicator(position);
                mCurrentPage = position;

                if (position==0){
                    next.setEnabled(true);
                    prev.setEnabled(false);
                    prev.setVisibility(View.INVISIBLE);

                    next.setText("Next");
                    prev.setText("");
                } else if(position == mDots.length - 1){
                    next.setEnabled(true);
                    prev.setEnabled(true);
                    prev.setVisibility(View.VISIBLE);

                    next.setText("Finish");
                    prev.setText("Back");
                } else {
                    next.setEnabled(true);
                    prev.setEnabled(true);
                    prev.setVisibility(View.VISIBLE);

                    next.setText("Next");
                    prev.setText("Back");
                }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}