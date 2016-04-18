package com.rezoleo.zer0data.object;

import android.app.Application;

/**
 * Created by nymous on 18/04/16.
 */
public class GlobalState extends Application {
    protected static SesssionStatus sesssionStatus = SesssionStatus.disconnected;

    public static synchronized boolean checkAndReplace(SesssionStatus old_Sesssion_status, SesssionStatus new_Sesssion_status){
        if(old_Sesssion_status !=null && GlobalState.sesssionStatus != old_Sesssion_status){
            return false;
        }
        GlobalState.sesssionStatus = new_Sesssion_status;
        return true;
    }
}
