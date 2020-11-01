package com.todaylunch.unknown;

public class MySQLite {

    private MySQLite() {}

    //first table and column
    public static final String TBL_INFO = "INFO_T";
    public static final String ICOL_NAME1 = "LATE_DATE";
    public static final String ICOL_NAME2 = "CLASS_MENU";
    public static final String ICOL_NAME3 = "CALSS_DETAIL";
    public static final String ICOL_NAME4 = "STORE_NAME";
    public static final String ICOL_NAME5 = "LINK";

    //second table and column
    public static final String TBL_ICON = "ICON_T";
    public static final String CCOL_NAME1 = "NUMBER";
    public static final String CCOL_NAME2 = "TITLE";
    public static final String CCOL_NAME3 = "ICON_NUM";

    //third table and column
    /*
    public static final String TBL_DESIGN = "DESIGN_T";
    public static final String DCOL_NAME1 = "LANGUAGE";
    public static final String DCOL_NAME2 = "MENU_RADIUS";
    public static final String DCOL_NAME3 = "MENU_COLOR";
    public static final String DCOL_NAME4 = "FONT";
    public static final String DCOL_NAME5 = "BACKGROUND_COLOR";


     */
    //about first table
    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TBL_INFO + " " + "(" + ICOL_NAME1 + " INTEGER" + ", " + ICOL_NAME2 + " INTEGER" + ", " + ICOL_NAME3 + " INTEGER" + ", " + ICOL_NAME4 + " TEXT" + ", " + ICOL_NAME5 + " TEXT" + ")";
    public static final String SQL_SELECT = "SELECT * FROM " + TBL_INFO;
    public static final String SQL_SELECT_WHERE = "SELECT * FROM " + TBL_INFO + " WHERE ";
    public static final String SQL_DELETE = "DELETE FROM " + TBL_INFO;
    public static final String SQL_INSERT = "INSERT OR REPLACE INTO "
            + TBL_INFO + " " + "(" + ICOL_NAME1 + ", " + ICOL_NAME2 + ", " + ICOL_NAME3 + ", " + ICOL_NAME4 + ", " + ICOL_NAME5 + ") VALUES ";
    public static final String SQL_UPDATE = "UPDATE " + TBL_INFO + " SET ";

    //about second table
    public static final String SQL_CREATE_TABLE2 = "CREATE TABLE IF NOT EXISTS "
            + TBL_ICON + " " + "(" + CCOL_NAME1 + " INTEGER, " + CCOL_NAME2 + " TEXT, " + CCOL_NAME3 + " INTEGER)";
    public static final String SQL_SELECT2 = "SELECT * FROM " + TBL_ICON;
    //SELECT * FROM TABLE WHERE COLUMN LIKE VALUE
    public static final String SQL_DELETE2 = "DELETE FROM " + TBL_ICON;
    public static final String SQL_INSERT2 = "INSERT OR REPLACE INTO "
            + TBL_ICON + " " + "(" + CCOL_NAME1 + ", " + CCOL_NAME2 + ", " + CCOL_NAME3 + ") VALUES ";
    public static final String SQL_UPDATE2 = "UPDATE " + TBL_ICON + " SET ";
    //'column name = change value, clumn nmae2 = change value, ... where table name = present value'
    public static String SQL_INSERT2_HELPER(int id, String title, int imageNumber) {

        return ("INSERT OR REPLACE INTO " + TBL_ICON + " " + "(" + CCOL_NAME1 + ", " + CCOL_NAME2 + ", " + CCOL_NAME3 + ") VALUES "
                + "(" + id + ", '" + title + "', " + imageNumber + ")");
    }

    /*

    //about third table
    public static final String SQL_CREATE_TABLE3 = "CREATE TABLE IF NOT EXISTS "
            + TBL_DESIGN + " (" + DCOL_NAME1 + " INTEGER, " + DCOL_NAME2 + " INTEGER, " + DCOL_NAME3 + " INTEGER, " + DCOL_NAME4 + " INTEGER, " + DCOL_NAME5 + " INTEGER)";
    public static final String SQL_SELECT3 = "SELECT * FROM " + TBL_DESIGN;
    public static final String SQL_DELETE3 = "DELETE FROM " + TBL_DESIGN;
    public static final String SQL_INSERT3 = "INSERT OR REPLACE INTO "
            + TBL_DESIGN + " " + "(" + DCOL_NAME1 + ", " + DCOL_NAME2 + ", " + DCOL_NAME3 + ", " + DCOL_NAME4 + ", " + DCOL_NAME5 + ") VALUES ";
    public static final String SQL_UPDATE3 = "UPDATE " + TBL_DESIGN + " SET ";


     */

    /*
    public static final String SQL_INSERT(String db1, String db2 ...) {
    return "INSERT OR REPLACE INTO" + ... ;


}
     */
}
