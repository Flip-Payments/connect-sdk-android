package com.flip.connect.presentation.util;

/**
 * Created by ltorres on 25/07/2017.
 */

public class StringUtil {
    public static boolean isEmptyOrNull(String text){
        if(text != null)
            return text.isEmpty();
        else
            return true;
    }
}
