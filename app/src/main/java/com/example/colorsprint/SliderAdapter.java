package com.example.colorsprint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {
        R.raw.takephoto,
        R.raw.scanneranimate,
        R.raw.share
    };

    public String[] slide_head = {
        "SCAN",
        "RECOGNIZE",
        "INTERACT"
    };

    public String[] slide_content = {
            "In order to know the actual colour name, hexadecimal code and rgb property of any object just hold your camera in front of that object.",
            "Colour sprint will give you the colour name, hexadecimal code of the scanned object, it's that easy!!",
            "This will help you to share the colour code information with your friends via different social medias and ease their task."
    };
    @Override
    public int getCount() {
        return slide_head.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        LottieAnimationView animationView = (LottieAnimationView) view.findViewById(R.id.anim);
        TextView header = (TextView) view.findViewById(R.id.tvHead);
        TextView content = (TextView) view.findViewById(R.id.tvContent);

        animationView.setAnimation(slide_images[position]);
        header.setText(slide_head[position]);
        content.setText(slide_content[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
