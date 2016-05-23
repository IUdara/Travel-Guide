package com.travelsoft.lanka.travel_guide.models;

import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;
import com.travelsoft.lanka.travel_guide.utils.Constants;

/**
 * Created by Isuru on 2016-03-21.
 */
public class PlaceCategory implements GridViewCell {
    private String shortName;
    private String iconImageUrl;
    private Constants.GridCellType cellType;

    public PlaceCategory(String shortName, String iconImageUrl) {
        if (shortName.length() > 9) {
            this.shortName = shortName.substring(0, 9);
        } else {
            this.shortName = shortName;
        }
        this.iconImageUrl = iconImageUrl;
        this.cellType = Constants.GridCellType.PLACE_CATEGORY;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    public void setCellType(Constants.GridCellType cellType) {
        this.cellType = cellType;
    }

    public void setShortName(String shortName) {
        if (shortName.length() > 9) {
            this.shortName = shortName.substring(0, 9);
        } else {
            this.shortName = shortName;
        }

    }

    @Override
    public String getIconImageUrl() {
        return iconImageUrl;
    }

    @Override
    public Constants.GridCellType getCellType() {
        return cellType;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }
}
