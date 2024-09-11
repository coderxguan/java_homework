package com.guanhf.trail1;

/*
Daffodils Numbers are also known as super perfect number invariants,
narcissistic Numbers, self-power Numbers, and Armstrong Numbers.
Daffodils number refers to a number of n digits (n≥3), the sum of the digits
on each of its bits to the NTH power is equal to its own requirements
(eg:1^3 + 5^3+ 3^3 = 153;1^4+6^4+3^4+4^4=1634) ,write a program to
calculate the number of daffodils in n bits (3≤n≤7).
Input format:
Given a positive integer n (3≤n≤7).
Output format:
Output all n-bit daffodils in ascending order, one line for each digit.
Input sample:
Here's a set of inputs. Such as:
        3
Output sample:
        153
        370
        371
        407
*/

import java.util.Scanner;

public class a07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 预先计算 0 到 9 的 n 次方
        int[] powers = new int[10];
        for (int i = 0; i < 10; i++) {
            powers[i] = (int) Math.pow(i, n);
        }

        // 计算 n 位数的范围
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n);

        // 循环 n 位数
        for (int i = start; i < end; i++) {
            int sum = 0;
            int tmp = i;
            // 取每一位数
            while (tmp != 0) {
                int digit = tmp % 10;
                sum += powers[digit];
                tmp /= 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}

