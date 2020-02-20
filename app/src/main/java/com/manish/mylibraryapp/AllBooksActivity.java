package com.manish.mylibraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";

    private RecyclerView booksRecyclerView;
    private List<Book> books;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        overridePendingTransition(R.anim.in,R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: started");

        booksRecyclerView = findViewById(R.id.booksRecyclerView);
        booksRecyclerView.setHasFixedSize(true);
        booksRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

//        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));



//
//        Book book1 = new Book("1Q84","Haruki Minamato",120,
//                "https://images-na.ssl-images-amazon.com/images/I/51wYhgDbDnL._SX329_BO1,204,203,200_.jpg",
//                "A work of Art");
//        Book book2 = new Book("1Q84","Haruki Minamato",120,
//                "https://images-na.ssl-images-amazon.com/images/I/51wYhgDbDnL._SX329_BO1,204,203,200_.jpg",
////                "A work of Art");
//
//        books.add(book1);
//        books.add(book2);
        Util utils = new Util();
        books = new ArrayList<>();

        books = utils.getAllBooks();


        BooksRecyclerViewAdapter adapter = new BooksRecyclerViewAdapter(this,books);
        booksRecyclerView.setAdapter(adapter);







    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in,R.anim.close_out);
    }
}
