package com.travelsoft.lanka.travel_guide.utils;

/**
 * Created by Isuru on 2016-03-22.
 */
public abstract class Constants {
    public static String API_DISCOVERY_BASE_URL = "http://api.themoviedb.org/3/discover/";
    public static String API_KEY = "&api_key=b95fa5cd56e3b2afc6ae19d1f8d9daff";

    // "movie" should replace by "placeCategory", "place" and "hotel"
    public enum GridCellType {
        PLACE_CATEGORY("movie"),
        PLACE("tv"),
        HOTEL("movie");


        GridCellType(String realName){
            this.realName = realName;
        }

        private final String realName;

        public String realName() {
            return realName;
        }
    }

    public enum ItemSubTypeKey {
        PLACE_CATEGORY_KEY("with_genres"), // should replace with something like "accending_order"
        PLACE_KEY("with_networks"), // should replace with something like "place_category"
        HOTEL_KEY("near_place");


        ItemSubTypeKey(String realValue){
            this.realValue = realValue;
        }

        private final String realValue;

        public String realValue() {
            return realValue;
        }
    }

}