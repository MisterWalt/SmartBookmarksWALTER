package com.example.maxime.smartbookmarkswalter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maxime.smartbookmarkswalter.Adapter.booksAdapter;
import com.example.maxime.smartbookmarkswalter.Model.Book;

import java.util.ArrayList;

import static android.R.id.list;

public class activity_books extends AppCompatActivity {


    private ListView listViewBooks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);


        listViewBooks = (ListView) findViewById(R.id.listViewBooks);




        Database database = new Database(this);
        final SQLiteDatabase db = database.getReadableDatabase();

        String queryAllBooks = "SELECT * FROM Books;";


        Cursor curs = db.rawQuery(queryAllBooks, null);

        ArrayList<Book> listBooks = new ArrayList<Book>();

        if (curs.moveToFirst()) {
            while (!curs.isAfterLast()) {

                Book newBook = new Book();

                newBook.setTitle(curs.getString(1));
                newBook.setAuthor(curs.getString(2));
                newBook.setStyle(curs.getString(3));

                newBook.setComment(1000);



                listBooks.add(newBook);
                curs.moveToNext();
            }
        }

        booksAdapter adapter = new booksAdapter(this,listBooks);
        listViewBooks.setAdapter(adapter);


        //Cursor curs = db.rawQuery(queryStringBooks, null);
        //curs.moveToFirst();

        //int nbBooks = Integer.parseInt(curs.getString(curs.getColumnIndex("Total")));
        //textViewNbBooks.setText("" + nbBooks);

    }
}
