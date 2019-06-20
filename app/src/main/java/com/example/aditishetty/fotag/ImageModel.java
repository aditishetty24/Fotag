package com.example.aditishetty.fotag;;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.content.res.Resources;

public class ImageModel {

    String imgName;
    int imgRating;
    Bitmap i;

    ImageCollectionModel imc;

    /**
     * Create a new model.
     */
    public ImageModel(ImageCollectionModel i, Resources res, int id, int pos) {
        this.imc = i;

        this.imgName = Integer.toString(pos);
        this.imgRating = 0;

        this.i = BitmapFactory.decodeResource(res, id);
    }

    String getImgName() {
        return imgName;
    }

    int getImgRating() {
        return imgRating;
    }

    Bitmap getImg() {
        return i;
    }

    void setImgName(String n) {
        this.imgName = n;
    }

    void setImgRating(int r) {
        this.imgRating = r;
//        System.out.println("before filtering " + imc.getAllImages().size());
        imc.filterImages();
    }



    /**
     * Add an observer to be notified when this model changes.
     */
//    public void addObserver(Observer observer) {
//        this.observers.add(observer);
//    }

    /**
     * Remove an observer from this model.
     */
//    public void removeObserver() {
//        this.observers.clear();
//    }

    /**
     * Notify all observers that the model has changed.
     */
//    public void notifyObservers() {
//        for (Observer observer: this.observers) {
//            observer.update(this);
//        }
//    }
}
