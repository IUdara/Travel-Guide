package com.travelsoft.lanka.travel_guide.parsers;

import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;
import com.travelsoft.lanka.travel_guide.interfaces.JsonArrayParser;
import com.travelsoft.lanka.travel_guide.models.Place;
import com.travelsoft.lanka.travel_guide.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Isuru on 2016-03-22.
 */
public class PlacesParser implements JsonArrayParser {

    @Override
    public GridViewCell[] parseJsonArray(JSONArray resultsJsonarray) {
        int itemCount = resultsJsonarray.length();
        GridViewCell[] places = new GridViewCell[itemCount];
        try {
            for (int i = 0; i < itemCount; i++) {
                JSONObject place = resultsJsonarray.getJSONObject(i);
                places[i] = new Place(place.getString("name"), place.getString("poster_path"), place.getString("backdrop_path"), place.getString("overview"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return places;
    }

    public static String[] parsePlaceToArray(Place place){
        String[] cellDetails = new String[5];
        cellDetails[0] = Constants.GridCellType.PLACE.realName();
        cellDetails[1] = place.getShortName();
        cellDetails[2] = place.getIconImageUrl();
        cellDetails[3] = place.getCoverImageUrl();
        cellDetails[4] = place.getDescription();
        return cellDetails;
    }
}
