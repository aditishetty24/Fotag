package com.example.aditishetty.fotag;

import android.content.res.Resources;
import android.util.Log;

import java.util.ArrayList;

public class ImageCollectionModel {

    ArrayList<ImageModel> allImages;

    int filterRating = 0;

    Integer [] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
    };

    ArrayList<ImageModel> filteredImages;


    /**
     * Create a new model.
     */
    public ImageCollectionModel() {
        filterRating = 0;
        filteredImages = new ArrayList<ImageModel>();
        allImages = new ArrayList<ImageModel>();
    }

    ArrayList<ImageModel> getAllImages() {

//        ArrayList<ImageModel> filtered = new ArrayList<>();
//        if (this.filterRating != 0) {
//
//            for (int i = 0; i < 10; ++i)
//            {
//                if (allImages.get(i).getImgRating() >= this.filterRating) {
//                    filtered.add(allImages.get(i));
//                }
//            }
//
//            return filtered;
//        }
//
//        else {
//            return allImages;
//        }
        return allImages;
    }

    int getFilterRating() {
        return filterRating;
    }

    void setFilterRating(int r) {
        this.filterRating = r;
//        notifyObservers();
    }

//    void addImage(ImageModel i) {
//        allImages.add(i);
//        notifyObservers();
//    }

    void loadImages(Resources res) {
//        allImages = new ArrayList<ImageModel>();
        for (int i = 0; i < 10; ++i)
        {
            allImages.add(new ImageModel(this, res, images[i], i));
        }

//        filteredImages = new ArrayList<ImageModel>();
        this.filterImages();
    }

    ArrayList<ImageModel> getFilteredImages() {
        return this.filteredImages;
    }

    void filterImages() {

        this.filteredImages.clear();


            for (int i = 0; i < 10; ++i)
            {
                if (allImages.get(i).getImgRating() >= this.filterRating) {
                    this.filteredImages.add(allImages.get(i));
                }
            }

    }

    int getPos (String n) {
        int x = 0;
        for (int i = 0; i < 10; ++i) {
            if (allImages.get(i).getImgName() == n) {
                x = i;
                break;
            }
        }
        return x;
    }

    void setRatingAtX(int pos, int rating) {
        allImages.get(pos).setImgRating(rating);
    }


    void removeImages() {
        this.filterRating = 0;
        allImages.clear();
        filteredImages.clear();
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
//    public void removeObserver(Observer observer) {
//        this.observers.remove(observer);
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
