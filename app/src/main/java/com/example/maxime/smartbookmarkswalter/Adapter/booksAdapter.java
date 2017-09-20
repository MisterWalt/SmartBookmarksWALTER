package com.example.maxime.smartbookmarkswalter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maxime.smartbookmarkswalter.Model.Book;
import com.example.maxime.smartbookmarkswalter.R;

import java.util.List;

/**
 * Created by Maxime on 20/09/2017.
 */

public class booksAdapter extends ArrayAdapter<Book>{


    public booksAdapter(Context context, List<Book> resource) {
        super(context, 0,resource);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_book,parent, false);
        }

        BookViewHolder viewHolder = (BookViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new BookViewHolder();
            viewHolder.Title = (TextView) convertView.findViewById(R.id.txtBookTitle);
            viewHolder.NbComment = (TextView) convertView.findViewById(R.id.txtBookNbComment);
            viewHolder.Style = (TextView) convertView.findViewById(R.id.txtBookStyle);
            viewHolder.Author = (TextView) convertView.findViewById(R.id.txtBookAuthor);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Book book = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.Title.setText(book.getTitle());
        viewHolder.NbComment.setText(book.getComment());
        viewHolder.Style.setText(book.getStyle());
        viewHolder.Author.setText(book.getAuthor());

        return convertView;
    }


    public static class BookViewHolder{
        public TextView Title;
        public TextView Author;
        public TextView Style;
        public TextView NbComment;
    }
}


