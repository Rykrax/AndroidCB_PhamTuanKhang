package com.example.truyencuoi;

public class MyBook {
    private int imageID;
    private String type;

    public MyBook(){}

    public MyBook(int imageID, String type) {
        this.imageID = imageID;
        this.type = type;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
