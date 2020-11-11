

package com.example.acer.myapplication;

/**
 * Created by acer on 16/03/2018.
 */

public class categorie {
    private int imageid;
    private String Title;
    private String description;
    private int imagestar;

    public categorie( String title, String description) {
        this.imageid = imageid;
        Title = title;
        this.description = description;
        this.imagestar=imagestar;
    }

    public int getImageid() { return imageid;}

    public int getImagestar(){return imagestar;}

    public void setImagestar(int imagestar){
        this.imagestar=imagestar;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
