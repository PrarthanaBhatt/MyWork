package com.prarthana.myworkapplication.movie_db.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {


    private Utils(){}

    public static boolean isNetworkAvailble(Context ctx){
        ConnectivityManager cm =
                (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }
}

