package com.todaylunch.unknown;

public class ListObject4 {

    int languageNumber;
    int cardViewRadius;
    int cardViewColorValue;
    int fontNumber;
    int backgroundColor;

    public ListObject4() {
    }

    public ListObject4(int langNum, int radiusNum, int cardColor, int fontNum, int backColor) {

        this.languageNumber = langNum;
        this.cardViewRadius = radiusNum;
        this.cardViewColorValue = cardColor;
        this.fontNumber = fontNum;
        this.backgroundColor = backColor;
    }

    public int getLanguageNumber() {
        return languageNumber;
    }

    public void setLanguageNumber(int languageNumber) {
        this.languageNumber = languageNumber;
    }

    public int getCardViewRadius() {
        return cardViewRadius;
    }

    public void setCardViewRadius(int cardViewRadius) {
        this.cardViewRadius = cardViewRadius;
    }

    public int getCardViewColorValue() {
        return cardViewColorValue;
    }

    public void setCardViewColorValue(int cardViewColorValue) {
        this.cardViewColorValue = cardViewColorValue;
    }

    public int getFontNumber() {
        return fontNumber;
    }

    public void setFontNumber(int fontNumber) {
        this.fontNumber = fontNumber;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
