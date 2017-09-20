package com.example.maxime.smartbookmarkswalter;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    TextView textViewNbBooks = null;
    TextView textViewNbComments = null;
    TextView textViewNbCommentsPerBooks = null;

    Button btnBooks = null;
    Button btnComments = null;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNbBooks = (TextView) findViewById(R.id.txtNbBooks);
        textViewNbComments = (TextView) findViewById(R.id.txtNbComments);
        textViewNbCommentsPerBooks = (TextView) findViewById(R.id.txtNbCommentsPerBooks);

        btnBooks = (Button) findViewById(R.id.buttonBooks);
        btnComments = (Button) findViewById(R.id.buttonComments);


        btnBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activity_books.class);
                startActivity(intent);
            }
        });

        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,activity_comments.class);
                startActivity(intent);
            }
        });


        Database database = new Database(this);
        final SQLiteDatabase db = database.getReadableDatabase();

        String queryStringBooks = "SELECT count(*)as 'Total' FROM Books;";
        String queryStringComments = "SELECT count(*)as 'Total' FROM Comments;";


        Cursor curs = db.rawQuery(queryStringBooks, null);
        curs.moveToFirst();
        int nbBooks = Integer.parseInt(curs.getString(curs.getColumnIndex("Total")));
        textViewNbBooks.setText("" + nbBooks);

        curs = db.rawQuery(queryStringComments, null);
        curs.moveToFirst();
        int nbComments = Integer.parseInt(curs.getString(curs.getColumnIndex("Total")));
        textViewNbComments.setText("" + nbComments);


        textViewNbCommentsPerBooks.setText("" + nbComments / nbBooks);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
