package com.example.firstappformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.firstappformation.operations.Transaction;
import com.example.firstappformation.operations.TransactionAdapter;
import com.example.firstappformation.pager.Card;
import com.example.firstappformation.pager.ViewPagerAdapterCard;
import com.example.firstappformation.shortcut.Shortcut;
import com.example.firstappformation.shortcut.ShortcutRecyclerViewAdapter;
import com.rd.PageIndicatorView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imgProfile;
    private ViewPager viewPagerCard;
    private PageIndicatorView pageIndicatorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupProfileImage();
        setupViewPager();
        setRecyclerViewItem(findViewById(R.id.shortcut_recyclerView));
        setupTransactionView();
    }


    private ArrayList<Shortcut> generateShortcutItems() {
        ArrayList<Shortcut> items = new ArrayList<>();

        items.add(new Shortcut(R.drawable.ic_shortcut_transfert,"Virement"));
        items.add(new Shortcut(R.drawable.ic_shortcut_account,"Compte"));
        items.add(new Shortcut(R.drawable.ic_shortcut_beneficiaries,"Bénéficiere"));
        items.add(new Shortcut(R.drawable.ic_shortcut_cards,"Cartes"));
        items.add(new Shortcut(R.drawable.ic_shortcut_checks,"Chèques"));
        items.add(new Shortcut(R.drawable.ic_shortcut_services,"Services"));

        return items;
    }


    private void findViews() {
        pageIndicatorView = findViewById(R.id.pageIndicatorView);
        imgProfile  = findViewById(R.id.img_profile);
        viewPagerCard = findViewById(R.id.view_pager);
    }

    private void setupProfileImage() {
        String imgUrl = "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8dXNlciUyMHByb2ZpbGV8ZW58MHx8MHx8fDA%3D";
        Picasso.get().load(imgUrl).placeholder(R.drawable.ic_user).into(imgProfile);
    }

    private void setupViewPager() {
        ArrayList<Card> cards = generateItems();
        pageIndicatorView.setCount(cards.size()); // specify total count of indicators
        ViewPagerAdapterCard adapter = new ViewPagerAdapterCard(this, cards);
        viewPagerCard.setAdapter(adapter);
        viewPagerCard.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {/*empty*/}

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {/*empty*/}
        });
    }

    private ArrayList<Card> generateItems() {
        ArrayList<Card> items = new ArrayList<>();
        items.add(new Card(R.drawable.card_1,40054000.0,true));
        items.add(new Card(R.drawable.card_2,22222000.55,false));
        return items;
    }

    private void setRecyclerViewItem(RecyclerView recyclerView) {
        ArrayList<Shortcut> shortcuts = generateShortcutItems();
        ShortcutRecyclerViewAdapter adapter = new ShortcutRecyclerViewAdapter(shortcuts);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


    private void setupTransactionView() {
        RecyclerView recyclerView = findViewById(R.id.transactions_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TransactionAdapter(this,generateTransactions()));
    }

    private ArrayList<Transaction> generateTransactions() {
        ArrayList<Transaction> items = new ArrayList<>();
        items.add(new Transaction("29","Oct.","Virement reçu de la part de madame Jane Doe Virement reçu de la part de madame Jane Doe",50000.00));
        items.add(new Transaction("29","Oct.","Virement reçu de la part de madame Jane Doe Virement reçu de la part de madame Jane Doe",-50000.00));
        items.add(new Transaction("29","Oct.","Virement reçu de la part de madame Jane Doe",50000.00));
        items.add(new Transaction("30","Oct.","Virement reçu de la part de madame Jane Doe",-50000.00));
        items.add(new Transaction("30","Oct.","Virement reçu de la part de madame Jane Doe",50000.00));
        items.add(new Transaction("30","Oct.","Virement reçu de la part de madame Jane Doe",-50000.00));
        items.add(new Transaction("31","Oct.","Virement reçu de la part de madame Jane Doe",50000.00));

        return items;
    }

}