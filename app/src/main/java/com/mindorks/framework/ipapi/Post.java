package com.mindorks.framework.ipapi;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("country")
    private String country;

    @SerializedName("countryCode")
    private String countryCode;

    @SerializedName("regionName")
    private String regionName;

    @SerializedName("timezone")
    private String timezone;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
