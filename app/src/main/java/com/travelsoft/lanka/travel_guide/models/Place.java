package com.travelsoft.lanka.travel_guide.models;

import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;
import com.travelsoft.lanka.travel_guide.utils.Constants;

import java.io.Serializable;

/**
 * Created by Isuru on 2016-03-21.
 */
public class Place implements GridViewCell, Serializable {
    private String shortName;
    private String iconImageUrl;
    private String coverImageUrl;
    private String description;
    private Constants.GridCellType cellType;

    public Place(String shortName, String iconImageUrl, String coverImageUrl, String description) {
        if (shortName.length() > 9) {
            this.shortName = shortName.substring(0, 9);
        } else {
            this.shortName = shortName;
        }
        this.iconImageUrl = iconImageUrl;
        this.coverImageUrl = coverImageUrl;
        this.description = description;
        this.cellType = Constants.GridCellType.PLACE;
    }

    @Override
    public String getShortName() {
        return shortName;
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

    public void setCellType(Constants.GridCellType cellType) {
        this.cellType = cellType;
    }

    @Override
    public Constants.GridCellType getCellType() {
        return cellType;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
