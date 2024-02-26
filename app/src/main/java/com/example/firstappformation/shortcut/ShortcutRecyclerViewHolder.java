package com.example.firstappformation.shortcut;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstappformation.R;

public class ShortcutRecyclerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;


    public ShortcutRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.title);
    }
}
