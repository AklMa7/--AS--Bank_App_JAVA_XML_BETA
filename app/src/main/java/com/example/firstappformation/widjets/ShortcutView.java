package com.example.firstappformation.widjets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.firstappformation.R;

public class ShortcutView extends RelativeLayout {
    public ShortcutView(Context context) {
        super(context);
    }

    public ShortcutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShortcutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public ShortcutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {

        RelativeLayout root = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.view_shortcut,this ,true);

        ImageView uiImage = root.findViewById(R.id.image);
        TextView uiTitle = root.findViewById(R.id.title);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ShortcutView);

        Drawable imageRef = typedArray.getDrawable(R.styleable.ShortcutView_icon);
        if (imageRef != null) {
            uiImage.setImageDrawable(imageRef);
        }

        String title = typedArray.getString(R.styleable.ShortcutView_title);
        uiTitle.setText(title);









    }
}
