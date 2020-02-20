package com.manish.mylibraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class CurrentlyReadingActivity extends AppCompatActivity {

    private BooksRecyclerViewAdapter adapter ;
    private Util utils;
    private RecyclerView recyclerViewCurrently;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);
        overridePendingTransition(R.anim.in,R.anim.out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BooksRecyclerViewAdapter(this,null);
        utils = new Util();
        adapter.setType("currently read");
        recyclerViewCurrently = findViewById(R.id.recViewCurrentlyReading);
        recyclerViewCurrently.setAdapter(adapter);
        recyclerViewCurrently.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setBooks(utils.getCurrentlyReadingBooks());
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
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
        overridePendingTransition(R.anim.close_in,R.anim.close_out);
    }
}
