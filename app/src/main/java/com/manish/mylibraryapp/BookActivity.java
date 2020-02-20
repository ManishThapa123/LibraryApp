package com.manish.mylibraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private static final String TAG = "BookActivity";

    private TextView bookName, author, description, pageNumber;
    private ImageView bookImage;
    private Button btnCrntlyReading, btnWantoRead, btnAlreadyRead;
    private Util util;

    private Book incomingBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        overridePendingTransition(R.anim.in,R.anim.out);

      //Back home up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId",0);
        //To retrieve corresponding book related to id.
        util =  new Util();
        ArrayList<Book>books = util.getAllBooks();
        for (Book b: books){
            if (b.getId() ==  id){
                incomingBook = b;
                bookName.setText(b.getName());
                author.setText(b.getAuthor());
                description.setText(b.getDescription());
                pageNumber.setText("Pages: "+ b.getPages());

                Glide.with(this).asBitmap().load(b.getImageUrl()).into(bookImage);
            }

        }

        //OnClicks

        btnCrntlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurrentlyReadingTapped();

            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadTapped();
            }
        });

        btnWantoRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });

    }
    private void initWidgets(){
        bookName = findViewById(R.id.bookName);
        author = findViewById(R.id.authorName);
        description = findViewById(R.id.description);
        pageNumber = findViewById(R.id.bookPages);


        bookImage = findViewById(R.id.bookImage);

        btnCrntlyReading = findViewById(R.id.btnCurrentlyReadingBook);
        btnWantoRead = findViewById(R.id.btnWantToReadBook);
        btnAlreadyRead = findViewById(R.id.btnAlreadyReadBook);


    }

    public void btnCurrentlyReadingTapped(){

        Log.d(TAG, "btnCurrentlyReadingTapped: Started");



        ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();


        if (currentlyReadingBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already Added books to your Currently Reading Books List");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else {

            ArrayList<Book> wantToReadBook = util.getWantToReadBooks();
            if (wantToReadBook.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage("Are You Going To Start Reading This Book?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeWantToReadBook(incomingBook);
                        util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this, "This Book "+ incomingBook.getName()+
                                " Had Been Added To Your List",Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();

            }else{

                ArrayList<Book> alreadyReadBook = util.getAlreadyReadBooks();
                if (alreadyReadBook.contains(incomingBook)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setMessage("Do You Want To Read It Again?");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            util.addCurrentlyReadingBook(incomingBook);
                            Toast.makeText(BookActivity.this, "This Book "+ incomingBook.getName()+
                                    " Had Been Added To Your List",Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.create().show();

                }
                else {
                    util.addCurrentlyReadingBook(incomingBook);
                    Toast.makeText(this, "This Book "+ incomingBook.getName()+
                            " Had Been Added To Your List",Toast.LENGTH_SHORT).show();
                }

            }

        }

    }

    public void btnAlreadyReadTapped(){
        Log.d(TAG, "btnAlreadyReadTapped: Started");

//        boolean doesExist = false;

        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
//        for (Book book: alreadyReadBooks){
//            if (book.getId() == incomingBook.getId()){
//                doesExist = true;
//
//            }
//        }
        if (alreadyReadBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already Added books to your Already Read Books List");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else {
            ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();
            if (currentlyReadingBooks.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Have You Finished Reading This Book?");
                builder.setTitle("Error");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeCurrentlyReadingBook(incomingBook);
                        util.addAlreadyReadBoks(incomingBook);
                        Toast.makeText(BookActivity.this, "This Book "+ incomingBook.getName()+
                                " Had Been Added To Your Already Read List",Toast.LENGTH_SHORT).show();


                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                builder.create().show();



            }else {
                util.addAlreadyReadBoks(incomingBook);
                Toast.makeText(this, "This Book "+ incomingBook.getName()+
                        " Had Been Added To Your Already Read List",Toast.LENGTH_SHORT).show();

            }


        }

    }

    public void  btnWantToReadTapped(){

        Log.d(TAG, "btnWantToReadTapped: Started");

//        boolean doesExist = false;

        ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();
//        for (Book book: wantToReadBooks){
//            if (book.getId() == incomingBook.getId()){
//                doesExist = true;
//
//            }
//        }
        if (wantToReadBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already Added books to your Want To Read Books List");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else {
            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
            if (alreadyReadBooks.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You are Already Reading This Book");
                builder.setTitle("Error");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }else {
                ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
                if (currentlyReadingBook.contains(incomingBook)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("You Have Already Read This Book");
                    builder.setTitle("Error");

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();

                }else {
                    util.addWantToReadBooks(incomingBook);
                    Toast.makeText(this, "This Book "+ incomingBook.getName()+
                            " Had Been Added To Your Want To Read List",Toast.LENGTH_SHORT).show();


                }

            }

        }

    }

//to add back button from supportAction Bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:

                super.onBackPressed();
                //To finish Activity.
//                finish();
                break;
                default:
                    break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in,R.anim.close_out);
    }
}

