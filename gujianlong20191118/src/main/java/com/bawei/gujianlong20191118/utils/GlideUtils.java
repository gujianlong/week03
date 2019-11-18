package com.bawei.gujianlong20191118.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/11/18
 *@Time:9:03
 *@Description:
 * */


import android.widget.ImageView;

import com.bawei.gujianlong20191118.R;
import com.bawei.gujianlong20191118.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {
    public static void loadImage(String url, ImageView imageView) {
        Glide.with(MyApp.mContext).load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
