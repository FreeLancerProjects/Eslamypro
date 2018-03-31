package com.semicolon.eslamy.Services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Delta on 30/03/2018.
 */

public class Network {

    public static boolean getConnection(Context context)
    {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info =manager.getActiveNetworkInfo();

        if (info!=null&& info.isAvailable()&& info.isConnected())
        {
            return true;
        }
        return false;
    }
}
