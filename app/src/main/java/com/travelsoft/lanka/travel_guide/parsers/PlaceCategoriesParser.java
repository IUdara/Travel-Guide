package com.travelsoft.lanka.travel_guide.parsers;

import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;
import com.travelsoft.lanka.travel_guide.interfaces.JsonArrayParser;
import com.travelsoft.lanka.travel_guide.models.PlaceCategory;
import com.travelsoft.lanka.travel_guide.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Isuru on 2016-03-22.
 */
public class PlaceCategoriesParser implements JsonArrayParser {

    @Override
    public GridViewCell[] parseJsonArray(JSONArray resultsJsonarray) {
        int itemCount = resultsJsonarray.length();
        GridViewCell[] placeCategories = new GridViewCell[itemCount];
        try {
            for (int i = 0; i < itemCount; i++) {
                JSONObject placeCategory = resultsJsonarray.getJSONObject(i);
                placeCategories[i] = new PlaceCategory(placeCategory.getString("title"), placeCategory.getString("poster_path"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return placeCategories;
    }

    public static String[] parsePlaceCategoryToArray(PlaceCategory placeCategory){
        String[] cellDetails = new String[3];
        cellDetails[0] = Constants.GridCellType.PLACE_CATEGORY.realName();
        cellDetails[1] = placeCategory.getShortName();
        cellDetails[2] = placeCategory.getIconImageUrl();
        return cellDetails;
    }
}
