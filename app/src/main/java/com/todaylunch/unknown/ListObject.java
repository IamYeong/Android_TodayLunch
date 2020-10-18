package com.todaylunch.unknown;

import java.util.Comparator;

public class ListObject implements Comparable<ListObject> {

    private long longDate;
    private int menu1;
    private int menu2;
    private String strTitle;
    private String strLink;

    //불러올 떄(링크가 있다면 꼭 있어야 하고 없어도 공백으로 긁어오면 됨)
    public ListObject(long mDate, int mMenu1, int mMenu2, String mTitle, String mLink) {

        this.longDate = mDate;
        this.menu1 = mMenu1;
        this.menu2 = mMenu2;
        this.strTitle = mTitle;
        this.strLink = mLink;

    }

    //혹시몰라서 만든 생성자
    public ListObject(long mDate, int mMenu1, int mMenu2, String mTitle) {
        this.longDate = mDate;
        this.menu1 = mMenu1;
        this.menu2 = mMenu2;
        this.strTitle = mTitle;
    }

    public ListObject(int mMenu1, int mMenu2, String mTitle, String mLink) {
        this.menu1 = mMenu1;
        this.menu2 = mMenu2;
        this.strTitle = mTitle;
        this.strLink = mLink;
    }

    public long getStrDate() {
        return longDate;
    }

    public void setStrDate(long strDate) {
        this.longDate = strDate;
    }

    public int getMenu1() {
        return menu1;
    }

    public void setMenu1(int menu1) {
        this.menu1 = menu1;
    }

    public int getMenu2() {
        return menu2;
    }

    public void setMenu2(int menu2) {
        this.menu2 = menu2;
    }

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public String getStrLink() {
        return strLink;
    }

    public void setStrLink(String strLink) {
        this.strLink = strLink;
    }

    @Override
    public int compareTo(ListObject o) {

        //더 큰 long값(최신 날짜) 순서로 정렬되는 기능.
        long longTime1 = this.longDate;
        long longTime2 = o.longDate;

        if (longTime1 < longTime2) {

            return 1;
        } else if (longTime1 > longTime2){

            return -1;
        }

        return 0;
    }
}
