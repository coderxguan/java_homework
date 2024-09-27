package com.guanhf.a09regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {
    public static void main(String[] args) {
        String regex = "(\\d+(\\.\\d+)?)([+-/*])(\\d+(\\.\\d+)?)";

        String expr = "2.1+3.1";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(expr);

        if(m.find()) {
            System.out.println(m.group(1));
//            System.out.println(m.group(2));
            System.out.println(m.group(3));
            System.out.println(m.group(4));
            System.out.println(m.lookingAt());
            System.out.println(m.start());
            System.out.println(m.end());

        }

        System.out.println(expr.matches(regex));

    }
}
