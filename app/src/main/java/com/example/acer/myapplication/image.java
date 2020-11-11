package com.example.acer.myapplication;

/**
 * Created by ETS HS on 02/05/2018.
 */

public class image {
    private int imageid;
    private String Title;

    public image(String title,int imageid ) {
        this.imageid = imageid;
        Title = title;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
