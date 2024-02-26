package com.example.firstappformation.operations;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstappformation.R;

public class TransactionHolder extends RecyclerView.ViewHolder {

    TextView amount, title,day,month;
    View border;
    public TransactionHolder(@NonNull View itemView) {
        super(itemView);
        amount = itemView.findViewById(R.id.amount);
        title = itemView.findViewById(R.id.title);
        day = itemView.findViewById(R.id.day);
        month = itemView.findViewById(R.id.month);
        border = itemView.findViewById(R.id.border);

        month.setText("");
        day.setText("");
        border.setBackgroundResource(R.drawable.border_blue);
        amount.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.amount_positive));
    }
}
