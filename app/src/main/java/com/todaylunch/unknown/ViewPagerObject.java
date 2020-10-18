package com.todaylunch.unknown;

public class ViewPagerObject {

    int pagerColor, imgResource;
    String appText;


    public ViewPagerObject() {}

    public ViewPagerObject(int color, int resource, String text) {

        this.pagerColor = color;
        this.imgResource = resource;
        this.appText = text;

    }

    public int getPagerColor() {
        return pagerColor;
    }

    public void setPagerColor(int pagerColor) {
        this.pagerColor = pagerColor;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getAppText() {
        return appText;
    }

    public void setAppText(String appText) {
        this.appText = appText;
    }
}
