package com.example.maxime.smartbookmarkswalter.Model;

/**
 * Created by Maxime on 20/09/2017.
 */

public class Book {


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    private String title;
    private String author;
    private String style;
    private int comment;

    public  Book(String title,String author,String style, int comment)
    {
        this.title = title;
        this.author = author;
        this.style = style;
        this.comment = comment;
    }
    public  Book()
    {
    }

}
