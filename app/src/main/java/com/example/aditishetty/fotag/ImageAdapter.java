package com.example.aditishetty.fotag;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RatingBar;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<ImageModel> {

    ImageCollectionModel imc;
    Activity c;

    ImageButton img;
    RatingBar imgRating;
    ImageButton clearRating;

//    ArrayList<ImageModel> filteredImages = new ArrayList<>();

    PopupWindow zoomImage;


    public ImageAdapter(Activity c, ImageCollectionModel imc) {
        super(c, R.layout.image_layout , imc.getFilteredImages());

        this.imc = imc;

        this.c = c;

    }


    @Override
    public int getCount() {
//        System.out.println("getCount "+ (imc.getFilteredImages()).size());
        return (imc.getFilteredImages()).size();
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

//        System.out.println("POSITION "+ position);

        final View imView;

        if (convertView == null) {

            LayoutInflater inflater = c.getLayoutInflater();

//        View imView = LayoutInflater.from(c).inflate(R.layout.activity_image_adapter, null, false);

            imView = inflater.inflate(R.layout.image_layout, parent, false);
//        filteredImages = imc.getFilteredImages();
        }

        else {
            imView = convertView;
        }
//        System.out.println("at pos "+ imc.getFilteredImages().get(position));

        img = (ImageButton) imView.findViewById(R.id.image_button);


        Bitmap newImage = Bitmap.createScaledBitmap(imc.getFilteredImages().get(position).getImg(), 280, 280, false);
        img.setImageBitmap(newImage);

        imgRating = (RatingBar) imView.findViewById(R.id.img_rating);

        imgRating.setNumStars(5);

        imgRating.setStepSize((float) 1);
        imgRating.setMax(5);

        imgRating.setRating(imc.getFilteredImages().get(position).getImgRating());


        clearRating = (ImageButton) imView.findViewById((R.id.clear_rating));

        zoomImage = new PopupWindow(imView);


        clearRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                System.out.println("clear "+ position);
//                System.out.println("before " + imc.getFilteredImages());

                imgRating.setRating((float) 0);

                imc.setRatingAtX(position, 0);

//                System.out.println("after " + imc.getFilteredImages());
                notifyDataSetChanged();
            }
        });

        imgRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

//                System.out.println("tags "+ position + " " + v + " " + b);


//                System.out.println(imc.getFilteredImages());

                if (b) {
                    imc.setRatingAtX(position, (int) v);
                }
            }
        });

//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                zoomImage.showAtLocation(imView, Gravity.CENTER, 0, 0);
//
//                zoomImage.setBackgroundDrawable(new BitmapDrawable(imc.getFilteredImages().get(position).getImg()));
//            }
//        });

        return imView;

    }

}
