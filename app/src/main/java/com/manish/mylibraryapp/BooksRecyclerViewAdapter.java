package com.manish.mylibraryapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BooksRecyclerViewAdapter extends RecyclerView.Adapter<BooksRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "BooksRecyclerViewAdapte";

    //   private ArrayList<Book> books = new ArrayList<>();
    private Context context;
    private List<Book> books;
    private String type = "";
    private Util utils;

    public BooksRecyclerViewAdapter(Context context, List books) {
        this.context = context;
        this.books = books;
        utils = new Util();

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to access view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book_rec_view, parent, false);
        //instance of Viewholder Class
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override

    //To bind the values to recycler view
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final Book book = books.get(position);
        Log.d(TAG, "onBindViewHolder: called");
        holder.bookName.setText(book.getName());

//        holder.bookName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,book.getName() + "Selected", Toast.LENGTH_SHORT).show();
//            }
//        });

        holder.bookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context,book.getName() + "Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra("bookId", book.getId());
                context.startActivity(intent);
            }
        });
        holder.bookCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Book book1 = books.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Deleting Book "
                        + book1.getName()).setMessage("Are you sure to Delete This book?").setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                switch (type) {


                    case "want to read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (utils.removeWantToReadBook(book)) {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, book1.getName() + " has been removed. ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).create().show();
                        if (utils.removeWantToReadBook(book)) {
                            notifyDataSetChanged();
                            Toast.makeText(context, book1.getName() + " has been removed. ", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case "already read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if (utils.removeAlreadyReadBook(book)) {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, book1.getName() + " has been removed. ", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).create().show();
                        break;

                    case "currently reading":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (utils.removeCurrentlyReadingBook(book)) {
                                    notifyDataSetChanged();
                                    Toast.makeText(context, book1.getName() + " has been removed. ", Toast.LENGTH_SHORT).show();
                                }


                            }
                        }).create().show();

                        break;
                    default:
                        break;
                }
                return true;

            }
        });

        Glide.with(context).asBitmap().load(book.getImageUrl()).into(holder.bookImage);


    }

    //returns size of Arraylist
    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView bookImage;
        private TextView bookName;
        //        private TextView author;
        private CardView bookCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage = (ImageView) itemView.findViewById(R.id.bookImage);
            bookName = (TextView) itemView.findViewById(R.id.bookName);
//          author = (TextView) itemView.findViewById();
            bookCard = (CardView) itemView.findViewById(R.id.bookCard);

        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }
}
