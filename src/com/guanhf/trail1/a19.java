package com.guanhf.trail1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/13 17:38
 */
public class a19 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int maxN = 10000;  // n的最大值为10000
        int[] dp = new int[maxN + 1];

        // 初始化前四个值，分别为 dp[0] 到 dp[3]
        dp[0] = 1;  // 起点不动，1种方式
        dp[1] = 1;  // 走1步
        dp[2] = 2;  // 走1步+1步 或者 直接走2步
        dp[3] = 4;  // 1+1+1, 1+2, 2+1, 3

        // 预处理dp数组，从dp[4]开始计算
        for (int i = 4; i <= maxN; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }

        // 读取输入
        int m = Integer.parseInt(st.nextToken());  // 数据组数m
        StringBuilder result = new StringBuilder();

        // 对于每一个n，输出对应的dp[n]
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            result.append(dp[n]).append("\n");
        }

        // 批量输出结果
        System.out.print(result.toString());
    }


}
