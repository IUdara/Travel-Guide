package com.travelsoft.lanka.travel_guide.asynctasks;

import android.net.Uri;
import android.os.AsyncTask;

import com.travelsoft.lanka.travel_guide.adapters.GridViewAdapter;
import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;
import com.travelsoft.lanka.travel_guide.models.Place;
import com.travelsoft.lanka.travel_guide.models.PlaceCategory;
import com.travelsoft.lanka.travel_guide.network.InformationFetcher;
import com.travelsoft.lanka.travel_guide.parsers.PlaceCategoriesParser;
import com.travelsoft.lanka.travel_guide.parsers.PlacesParser;
import com.travelsoft.lanka.travel_guide.utils.Constants.GridCellType;

/**
 * Created by Isuru on 2016-03-16.
 */
public class AsyncTaskGridViewLoader extends AsyncTask<String, String, Void> {

    InformationFetcher informationFetcher;
    GridViewAdapter gridGridViewAdapter;

    public AsyncTaskGridViewLoader(GridViewAdapter adapter) {
        gridGridViewAdapter = adapter;
    }

    @Override
    protected void onPreExecute() {
        informationFetcher = new InformationFetcher();
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            GridViewCell[] fetchedDetails = informationFetcher.fetchArrayOfDetailsFromApi(params[0], params[1], params[2]);
            for (GridViewCell cellDetail : fetchedDetails) {
                String[] cellDetails = null;
                if(params[0].equals(GridCellType.PLACE_CATEGORY.realName())){
                    cellDetails = PlaceCategoriesParser.parsePlaceCategoryToArray((PlaceCategory)cellDetail);
                }else if (params[0].equals(GridCellType.PLACE.realName())){
                    cellDetails = PlacesParser.parsePlaceToArray((Place)cellDetail);
                }

                publishProgress(cellDetails);
                if (isCancelled()) break;
            }
        } catch (NullPointerException e) {
            System.out.println("No images were found !!! - " + e);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        GridViewCell gridViewCell = null;

        if(values[0].equals(GridCellType.PLACE_CATEGORY.realName())){
            gridViewCell = new PlaceCategory(values[1], values[2]);
        }else if (values[0].equals(GridCellType.PLACE.realName())){
            gridViewCell = new Place(values[1], values[2], values[3], values[4]);
        }

        gridGridViewAdapter.add(gridViewCell);
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void result) {
        gridGridViewAdapter.notifyDataSetChanged();
        super.onPostExecute(result);
    }
}
