package com.prarthana.myworkapplication.data_binding_recycler;

import android.graphics.drawable.Drawable;

public class Book {
    private String title;
    private String author;
    private Drawable image;

    public Book(String title, String author, Drawable image) {
        this.title = title;
        this.author = author;
        this.image = image;
    }

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

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
