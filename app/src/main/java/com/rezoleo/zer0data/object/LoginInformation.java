package com.rezoleo.zer0data.object;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Thomas on 8/01/16.
 */
public class LoginInformation extends fr.applicationcore.object.APIObject implements Parcelable {
    protected String login;
    protected String gate;
    protected List<String> roles;
    protected String sessionid;


    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Parcelable.Creator<LoginInformation> CREATOR = new Parcelable.Creator<LoginInformation>() {
        @Override
        public LoginInformation createFromParcel(Parcel source) {
            return new LoginInformation(source);
        }
        @Override
        public LoginInformation[] newArray(int size) {
            return new LoginInformation[size];
        }
    };

    /**
     * Creator from Parcel, reads back fields IN THE ORDER they were written
     */
    public LoginInformation(Parcel pc) {
        login = pc.readString();
        gate = pc.readString();
        roles = pc.createStringArrayList();
        sessionid = pc.readString();
    }

    public String getLogin() {
        return login;
    }

    public String getSessionid() {
        return sessionid;
    }

    @Override
    public boolean isEmpty() {
        return login == null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(gate);
        dest.writeStringList(roles);
        dest.writeString(sessionid);
    }
}
