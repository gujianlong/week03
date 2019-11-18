package com.example.lianxi.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/11/17
 *@Time:14:15
 *@Description:
 * */


import android.app.DownloadManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestOptions;
import com.example.lianxi.R;
import com.example.lianxi.app.MyApp;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext).load(url)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
               // .apply(RequestOptions.bitmapTransform(new CircleCrop()))
               .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(imageView);
    }
}
