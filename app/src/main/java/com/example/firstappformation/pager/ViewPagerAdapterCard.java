package com.example.firstappformation.pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.firstappformation.R;
import com.example.firstappformation.tools.Utils;

import java.util.ArrayList;
import java.text.*;
import java.util.Locale;

public class ViewPagerAdapterCard extends PagerAdapter {

    private final Context context;
    private final ArrayList<Card> cards;

    public ViewPagerAdapterCard(Context context, ArrayList<Card> cards) {
        this.context = context;
        this.cards = cards;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = getView(container);
        Card card = cards.get(position);
        ImageView imgCard = view.findViewById(R.id.image_card);
        TextView uiSold = view.findViewById(R.id.text_sold);
        ImageView uiBtnVisibility = view.findViewById(R.id.button_toggle_sold);
        imgCard.setImageResource(card.getImageId());
        String sold = Utils.formatAmount(card.getSold());
        boolean isVisible = card.isVisible();
        uiBtnVisibility.setImageResource(isVisible ? R.drawable.ic_eye : R.drawable.ic_hide);
        uiSold.setText( isVisible ? sold : "****,***");
        uiBtnVisibility.setOnClickListener((v)->{
            card.toggleVisibility();
            notifyDataSetChanged();
        });
        container.addView(view,0);
        return view;
    }



    private View getView(ViewGroup container) {
        return LayoutInflater.from(context).inflate(R.layout.item_card_pagerview, container, false);
    }
}


