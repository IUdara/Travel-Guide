package com.travelsoft.lanka.travel_guide.interfaces;

import com.travelsoft.lanka.travel_guide.utils.Constants;

/**
 * Created by Isuru on 2016-03-22.
 */
public interface GridViewCell {
    String getShortName();
    String getIconImageUrl();
    Constants.GridCellType getCellType();
}
