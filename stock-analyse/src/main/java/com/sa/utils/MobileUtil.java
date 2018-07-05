package com.sa.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileUtil {
    public static boolean isFormat(String email) {
        Pattern p = Pattern.compile("[0-9]{11}");
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        return b;
    }
}
