package com.travelsoft.lanka.travel_guide.network;

import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;
import com.travelsoft.lanka.travel_guide.interfaces.JsonArrayParser;
import com.travelsoft.lanka.travel_guide.parsers.PlaceCategoriesParser;
import com.travelsoft.lanka.travel_guide.parsers.PlacesParser;
import com.travelsoft.lanka.travel_guide.utils.Constants;
import com.travelsoft.lanka.travel_guide.utils.Constants.GridCellType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Isuru on 2016-03-22.
 */
public class InformationFetcher {

    public GridViewCell[] fetchArrayOfDetailsFromApi(String itemType, String itemSubTypeKey, String itemSubTypeValue) {

        GridViewCell[] detailsFromApi = null;
        final String detailsArrayRequestUrl = Constants.API_DISCOVERY_BASE_URL.concat(itemType) + "?".concat(itemSubTypeKey) + "=".concat(itemSubTypeValue) + Constants.API_KEY;
        try {
            JSONObject resultsJson = APIGateWay.callApiForJsonObject(detailsArrayRequestUrl);
            System.out.println("API Call : "+detailsArrayRequestUrl);
            JSONArray resultsJsonarray = resultsJson.getJSONArray("results");
            JsonArrayParser jsonArrayParser=null;

            if(itemType.equals(GridCellType.PLACE_CATEGORY.realName())){
                jsonArrayParser = new PlaceCategoriesParser();
            }else if (itemType.equals(GridCellType.PLACE.realName())){
                jsonArrayParser = new PlacesParser();
            }

            detailsFromApi = jsonArrayParser.parseJsonArray(resultsJsonarray);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return detailsFromApi;
    }
}
