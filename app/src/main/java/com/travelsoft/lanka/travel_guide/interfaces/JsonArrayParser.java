package com.travelsoft.lanka.travel_guide.interfaces;

import org.json.JSONArray;

/**
 * Created by Isuru on 2016-03-22.
 */
public interface JsonArrayParser {
    GridViewCell[] parseJsonArray(JSONArray resultsJsonarray);
}
