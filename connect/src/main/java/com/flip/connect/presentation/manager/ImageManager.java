package com.flip.connect.presentation.manager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ltorres on 17/07/2017.
 */

public class ImageManager {

    public ImageManager(){
    }

    public void loadImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
}
