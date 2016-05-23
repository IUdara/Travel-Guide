package com.travelsoft.lanka.travel_guide.utils;

import android.net.Uri;

/**
 * Created by Isuru on 2016-04-16.
 */
public class UriHandler {

    public static Uri createUriForAnImage(String lastPartOfUrl, int imageWidth) {
        Uri.Builder url_for_cover = new Uri.Builder();
        String cover_sin_path = lastPartOfUrl.substring(1);
        String imageWidthForUrl = "w".concat(String.valueOf(imageWidth));

        Uri.Builder url_build = url_for_cover.scheme("http").authority("image.tmdb.org").appendPath("t").appendPath("p").appendPath(imageWidthForUrl).appendPath(cover_sin_path);

        return Uri.parse(url_build.toString());
    }
}
