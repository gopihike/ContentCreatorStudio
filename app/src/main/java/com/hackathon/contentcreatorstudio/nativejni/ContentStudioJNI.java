package com.hackathon.contentcreatorstudio.nativejni;

/**
 * Created by gopi on 22/03/18.
 */

public class ContentStudioJNI {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();
}
