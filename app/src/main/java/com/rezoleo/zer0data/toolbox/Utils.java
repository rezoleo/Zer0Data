package com.rezoleo.zer0data.toolbox;

/**
 * Created by Thomas on 17/01/16.
 */
public class Utils {
    // Converting byte[] to hex string:
    public static String ByteArrayToHexString(byte[] inArray) {
        int i, j, in;
        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String out = "";
        for (j = 0; j < inArray.length; ++j) {
            in = (int) inArray[j] & 0xff;
            i = (in >> 4) & 0x0f;
            out += hex[i];
            i = in & 0x0f;
            out += hex[i];
        }
        return out;
    }


}
