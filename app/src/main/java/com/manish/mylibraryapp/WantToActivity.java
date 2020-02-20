package com.manish.mylibraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class WantToActivity extends AppCompatActivity {

    private RecyclerView recyclerViewWantTo;

    private BooksRecyclerViewAdapter adapter;
    private Util utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to);
        overridePendingTransition(R.anim.in, R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BooksRecyclerViewAdapter(this, null);
        adapter.setType("want to read");
        utils = new Util();
        recyclerViewWantTo = findViewById(R.id.recViewWantTo);
        recyclerViewWantTo.setAdapter(adapter);
        recyclerViewWantTo.setLayoutManager(new GridLayoutManager(this, 2));

        adapter.setBooks(utils.getWantToReadBooks());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
