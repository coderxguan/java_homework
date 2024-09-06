package com.guanhf.a02;

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

public class Homework02 {
    public static void main(String[] args) {

        int n;
        System.out.println("please input the digit numbers:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for(double i = Math.pow(10, n-1); i < Math.pow(10, n); i++){
            int sum = 0;
            int tmp = (int)i;
            while(tmp != 0){
                int digit = tmp % 10;
                sum += Math.pow(digit, n);
                tmp /= 10.0;
            }
            if(sum == i ){
                System.out.println(sum);
            }
        }
    }

}
