package com.example.projectforandroid311;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {


    private Context context;

    private final Integer[] mImage = {
        R.drawable.img_1, R.drawable.img_2, R.drawable.img_3
    };



    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mImage.length;
    }

    @Override
    public Object getItem(int position) {
        return mImage[position];
    }

    @Override
    public long getItemId(int position) {
        return mImage[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image = new ImageView(context);
        image.setImageResource(mImage[position]);
        image.setLayoutParams(new Gallery.LayoutParams(1000, 1000));
        image.setPadding(10,10,10,10);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);



        return image;
    }
}
