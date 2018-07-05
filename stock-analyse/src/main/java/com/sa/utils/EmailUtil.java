package com.sa.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {
    public static boolean isFormat(String email) {
        Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        return b;
    }

}
