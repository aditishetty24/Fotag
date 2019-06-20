package com.example.aditishetty.fotag;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    GridView imagesView;
    Toolbar customToolbar;
    ImageButton clear;
    ImageButton load;
    ImageButton reset;
    RatingBar ratingFilter;

    ImageCollectionModel imc;

    ImageAdapter adp;

    @Override
    public void onConfigurationChanged(Configuration con) {
        super.onConfigurationChanged(con);


        if (con.orientation == Configuration.ORIENTATION_PORTRAIT) {
            imagesView.setNumColumns(1);

            adp = new ImageAdapter(this, imc);

            imagesView.setAdapter(adp);
        }
        else if(con.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            System.out.println("LANDSCAPE");

            imagesView.setNumColumns(2);

            adp = new ImageAdapter(this, imc);

            imagesView.setAdapter(adp);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imc = new ImageCollectionModel();

        imagesView = (GridView) findViewById(R.id.image_grid);

        imagesView.setNumColumns(1);

        customToolbar = (Toolbar) findViewById(R.id.toolbar);

//        this.setSupportActionBar(customToolbar);

        reset = (ImageButton) findViewById(R.id.reset_button);
        load = (ImageButton) findViewById(R.id.load_button);

        ratingFilter = (RatingBar) findViewById(R.id.rating_filter);

        ratingFilter.setStepSize((float) 1);
        ratingFilter.setMax(5);
        ratingFilter.setRating((float) 0);

        clear = (ImageButton) findViewById(R.id.clear_button);

        adp = new ImageAdapter(this, imc);

        imagesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingFilter.setRating((float) 0);

                imc.setFilterRating(0);
                if (!imc.getAllImages().isEmpty()) {
                    imc.filterImages();
                }

                imagesView.setAdapter(adp);
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imc.loadImages(getResources());

//                System.out.println(imc.getFilteredImages());

                load.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                load.setEnabled(false);

                imagesView.setAdapter(adp);

//                System.out.println(adp.getCount());
            }
        });


        ratingFilter.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                imc.setFilterRating((int) v);

                if (!imc.getAllImages().isEmpty()) {
                    imc.filterImages();
                }

                imagesView.setAdapter(adp);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingFilter.setRating((float) 0);

                if (!imc.getAllImages().isEmpty()) {
                    imc.removeImages();
                }

                load.getBackground().setColorFilter(null);
                load.setEnabled(true);

                imagesView.setAdapter(adp);

            }
        });

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

//    @Override
//    public void updateView() {
//        this.adp.notifyDataSetChanged();
//        this.imagesView.setAdapter(this.adp);
//    }


}
