package com.rezoleo.zer0data.object;

import android.app.Application;

/**
 * Created by nymous on 18/04/16.
 */
public class GlobalState extends Application {
    protected static SesssionStatus sesssionStatus = SesssionStatus.disconnected;

    /**
     * This function is used to store and change the connection status, while guaranteeing a single
     * connection request at a time (with the synchronized keyword).
     * @param old_Sesssion_status The status that should be before this moment
     * @param new_Sesssion_status The new status for the session
     * @return true if the status was changed, false if the status wasn't changed
     */
    public static synchronized boolean checkAndReplace(SesssionStatus old_Sesssion_status, SesssionStatus new_Sesssion_status){
        if(old_Sesssion_status !=null && GlobalState.sesssionStatus != old_Sesssion_status){
            return false;
        }
        GlobalState.sesssionStatus = new_Sesssion_status;
        return true;
    }
}
