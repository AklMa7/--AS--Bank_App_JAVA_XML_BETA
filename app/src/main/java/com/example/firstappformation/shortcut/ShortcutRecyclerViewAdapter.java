package com.example.firstappformation.shortcut;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstappformation.R;

import java.util.ArrayList;

public class ShortcutRecyclerViewAdapter extends RecyclerView.Adapter<ShortcutRecyclerViewHolder> {

    public ArrayList<Shortcut> shortcuts;

    public ShortcutRecyclerViewAdapter(ArrayList<Shortcut> shortcuts) {
        this.shortcuts = shortcuts;
    }

    @NonNull
    @Override
    public ShortcutRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shortcut,parent,false);
        return new ShortcutRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShortcutRecyclerViewHolder holder, int position) {
        Shortcut shortcut = shortcuts.get(position);
        holder.imageView.setImageResource(shortcut.getImage());
        holder.textView.setText(shortcut.getText());
    }

    @Override
    public int getItemCount() {
        return shortcuts.size();
    }
}
