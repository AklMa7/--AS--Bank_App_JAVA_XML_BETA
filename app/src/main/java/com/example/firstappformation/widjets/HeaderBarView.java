package com.example.firstappformation.widjets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.firstappformation.R;

public class HeaderBarView extends RelativeLayout {
    public HeaderBarView(Context context) {
        super(context);

    }

    public HeaderBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Init(context, attrs);
    }

    public HeaderBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context, attrs);
    }

    public HeaderBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Init(context, attrs);
    }

    private void Init(Context context, @Nullable AttributeSet attrs){
        RelativeLayout root = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_header,this ,true);

        ImageView uiBack = root.findViewById(R.id.icon_back);
        ImageView uiLogo = root.findViewById(R.id.icon_logo);


        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.HeaderBarView);


    }
}
