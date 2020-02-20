package com.manish.mylibraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class AlreadyReadActivity extends AppCompatActivity {

    private BooksRecyclerViewAdapter adapter ;
    private Util utils;
    private RecyclerView recyclerViewAlready;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read);
        overridePendingTransition(R.anim.in,R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BooksRecyclerViewAdapter(this,null);


        adapter.setType("already read");
        utils = new Util();
        recyclerViewAlready = findViewById(R.id.recViewAlreadyRead);
        recyclerViewAlready.setAdapter(adapter);
        recyclerViewAlready.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setBooks(utils.getAlreadyReadBooks());
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
