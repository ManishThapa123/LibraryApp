package com.manish.mylibraryapp;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Util {
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;


    private static int id = 0;

    public Util(){

        if(allBooks == null){
            allBooks = new ArrayList<>();
            initAllBooks();
        }
        if(currentlyReadingBooks == null){
            currentlyReadingBooks = new ArrayList<>();
        }
        if(wantToReadBooks == null){
            wantToReadBooks = new ArrayList<>();
        }
        if(alreadyReadBooks == null){
            alreadyReadBooks = new ArrayList<>();
        }

    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBook(Book book){

       return currentlyReadingBooks.add(book);

    }
    public boolean addWantToReadBooks(Book book){

        return wantToReadBooks.add(book);

    }
    public boolean addAlreadyReadBoks(Book book){

        return alreadyReadBooks.add(book);

    }

    public boolean removeCurrentlyReadingBook(Book book){
        return currentlyReadingBooks.remove(book);
    }
    public boolean removeWantToReadBook(Book book){
        return wantToReadBooks.remove(book);
    }
    public boolean removeAlreadyReadBook(Book book){
        return alreadyReadBooks.remove(book);
    }

    private static void initAllBooks(){

        String name = "";
        String author = "";
        int pages = 0;
        String imageUrl = "";
        String description = "";


        id++;
         name = "The Testaments";
         author = "Margaret Atwood ";
        pages = 422;
         imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1549292344l/42975172.jpg";
         description = "When the van door slammed on Offred's " +
                 "future at the end of The Handmaid's Tale, readers had no way of telling what lay ahead for her--freedom, prison or death.";

         allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name = "The Silent Patient";
        author = "Alex Michaelides  ";
        pages = 323;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1573745054l/40097951._SY475_.jpg";
        description = "Alicia Berenson’s life is seemingly perfect. A famous painter married to an in-demand fashion photographer, " +
                "she lives in a grand house with big windows overlooking a park in one of London’s most desirable areas." +
                " One evening her husband Gabriel " +
                "returns home late from a fashion shoot, and Alicia shoots him five times in the face, and then never speaks another word.";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name = "The Institute";
        author = "Stephen King  ";
        pages = 561;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1549241208l/43798285.jpg";
        description = "In the middle of the night, in a house on a quiet street in suburban Minneapolis, intruders silently" +
                " murder Luke Ellis’s parents and load him into a black SUV. The operation takes less than two minutes. " +
                "Luke will wake up at The Institute, in a room that looks just like his own, except there’s no window. " +
                "And outside his door are other doors, behind which are other kids with special " +
                "talents—telekinesis and telepathy—who got to this place the same way Luke did: Kalisha, " +
                "Nick, George, Iris, and ten-year-old Avery Dixon";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));


        id++;
        name = "The Invited";
        author = "Jennifer McMahon ";
        pages = 353;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1541824130l/40065317.jpg";
        description = "A chilling ghost story with a twist: the New York Times bestselling author of The Winter People returns to the woods of Vermont to tell the story of a husband " +
                "and wife who don't simply move into a haunted house, they start building one from scratch, without knowing it, until it's too late . . .";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name = "An Anonymous Girl";
        author = "Greer Hendricks";
        pages = 375;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546956642l/39863515._SY475_.jpg";
        description = "\n" +
                "When Jessica Farris signs up for a psychology study conducted by the mysterious " +
                "Dr. Shields, she thinks all she’ll have to do is answer a few questions, collect her money, and leave.";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

        id++;
        name = "An Anonymous Girl";
        author = "Greer Hendricks";
        pages = 375;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546956642l/39863515._SY475_.jpg";
        description = "\n" +
                "When Jessica Farris signs up for a psychology study conducted by the mysterious " +
                "Dr. Shields, she thinks all she’ll have to do is answer a few questions, collect her money, and leave.";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));
        id++;
        name = "An Anonymous Girl";
        author = "Greer Hendricks";
        pages = 375;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546956642l/39863515._SY475_.jpg";
        description = "\n" +
                "When Jessica Farris signs up for a psychology study conducted by the mysterious " +
                "Dr. Shields, she thinks all she’ll have to do is answer a few questions, collect her money, and leave.";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));
        id++;
        name = "An Anonymous Girl";
        author = "Greer Hendricks";
        pages = 375;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546956642l/39863515._SY475_.jpg";
        description = "\n" +
                "When Jessica Farris signs up for a psychology study conducted by the mysterious " +
                "Dr. Shields, she thinks all she’ll have to do is answer a few questions, collect her money, and leave.";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));
        id++;
        name = "An Anonymous Girl";
        author = "Greer Hendricks";
        pages = 375;
        imageUrl = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546956642l/39863515._SY475_.jpg";
        description = "\n" +
                "When Jessica Farris signs up for a psychology study conducted by the mysterious " +
                "Dr. Shields, she thinks all she’ll have to do is answer a few questions, collect her money, and leave.";

        allBooks.add(new Book(id,name,author,pages,imageUrl,description));

    }

}
