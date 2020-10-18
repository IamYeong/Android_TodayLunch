package com.todaylunch.unknown;

public class ListObject3 implements Comparable<ListObject3> {

    int mNum;
    String mTitle;
    int mImgNum;


    public ListObject3() {}
    public ListObject3(int num, String title, int imgNum) {
        this.mNum = num;
        this.mTitle = title;
        this.mImgNum = imgNum;
    }

    public ListObject3(int num, String title) {
        this.mNum = num;
        this.mTitle = title;
    }

    public ListObject3(String title, int imgNum) {
        this.mTitle = title;
        this.mImgNum = imgNum;
    }

    public int getmNum() {
        return mNum;
    }

    public void setmNum(int mNum) {
        this.mNum = mNum;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmImgNum() {
        return mImgNum;
    }

    public void setmImgNum(int mImgNum) {
        this.mImgNum = mImgNum;
    }

    @Override
    public int compareTo(ListObject3 o) {

        if (this.mNum > o.getmNum()) {
            return -1;
        } else if (this.mNum < o.getmNum()) {
            return 1;
        } return 0;

    }
}
