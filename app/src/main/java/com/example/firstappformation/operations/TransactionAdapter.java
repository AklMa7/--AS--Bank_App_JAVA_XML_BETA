package com.example.firstappformation.operations;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstappformation.R;
import com.example.firstappformation.pager.ViewPagerAdapterCard;
import com.example.firstappformation.tools.Utils;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionHolder> {

    private Context context;
    private ArrayList<Transaction> transactions;

    public TransactionAdapter(Context context, ArrayList<Transaction> transactions) {
        this.context = context;
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionHolder(LayoutInflater.from(context).inflate(R.layout.item_transaction, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHolder holder, int position) {
        
        Transaction transaction = transactions.get(position);
        Transaction oldTransaction = position != 0 ? transactions.get(position -1) : null;
        if (position == 0 || (oldTransaction != null && transaction.differentDate(oldTransaction)) ) {
            holder.month.setText(transaction.getMonth());
            holder.day.setText(transaction.getDay());
        }
        double amount = transaction.getAmount();
        if (amount < 0) {
            holder.border.setBackgroundResource(R.drawable.border_red);
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.amount_negative));
        }
        holder.title.setText(transaction.getTitle());
        holder.amount.setText(Utils.formatAmount(amount));

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }
}
