package com.nearur.payrec;

import android.net.Uri;

/**
 * Created by mrdis on 7/27/2017.
 */

public class Util {

    public static final int dbversion=1;
    public static final String dbname="JaiDurgaCommunication";
    public static final String tabname="Loans";


    public static final String Name="Name";
    public static final String Mobile="Mobile";
    public static final String Amount="Amount";
    public static final String Date="Date";
    public static final String Address="Address";
    public static final String Alternate="Alternate";

    public static final String query="create table Loans(" +
            "Name text," +
            "Mobile text primary key," +
            "Amount text," +
            "Date text," +
            "Address text," +
            "Alternate text" +
            ")";

    public static final Uri u=Uri.parse("content://com.nearur.Payrec/"+tabname);


}
