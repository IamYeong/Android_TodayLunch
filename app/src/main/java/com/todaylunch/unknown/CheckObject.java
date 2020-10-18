package com.todaylunch.unknown;

public class CheckObject {

    private String title;
    private boolean checkBox = false;

    public CheckObject(String title, boolean checkBox) {
        this.title = title;
        this.checkBox = checkBox;
    }

    public CheckObject(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
}
