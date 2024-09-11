package com.guanhf.trail1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/11 21:45
 */
public class a06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        List<String> list = subtract(ip, 8);
        String result = list.stream().map(
                x -> {
                    int i = 7;
                    int sum = 0;
                    // 遍历
                    for (char c : x.toCharArray()) {
                        // 取幂
                        sum += (int) (Integer.parseInt(String.valueOf(c)) * Math.pow(2, i));
                        i--;
                    }
                    // 返回字符串
                    return String.valueOf(sum);
                }
        ).collect(Collectors.joining("."));

        System.out.println(result);

    }
    public static List<String> subtract(String ip, Integer n){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < ip.length(); i+=n) {
            list.add(ip.substring(i, i+n));
        }
        return list;
    }
}
