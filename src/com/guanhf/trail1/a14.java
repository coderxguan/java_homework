package com.guanhf.trail1;

import java.util.*;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/13 16:32
 */
public class a14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue))
                .ifPresent(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

    }
}
