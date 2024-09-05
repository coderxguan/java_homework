package com.guanhf.a01;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/05 16:24
 */

/*
    2. Emulate a vending machine. Calculate the number of dollars
    and coins required to express a given amount of change in dollars,
    50, 20, 10 and 5 cent coins. For example, $9.85 would be $9, 1 x 50c, 1 x 20x
    and 1 x 5c coins. Then modify it so that it also prints out the number of $1
    and $2 coins.
*/
public class Vending {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("please input the total chance: ");
        String amount = sc.next();
        int integer =Integer.parseInt(amount.split("\\.")[0]);
        int faction = Integer.parseInt(amount.split("\\.")[1]);


        int numOf2 = integer / 2 ;
        int numOf1 = integer % 2 ;

        int numOf50c = faction / 50;
        int numOf20c = (faction - numOf50c * 50 ) / 20;
        int numOf10c = (faction - numOf50c * 50 - numOf20c * 20 ) / 10;
        int numOf5c = (faction - numOf50c * 50 - numOf20c * 20 - numOf10c * 10 ) / 5;

        System.out.println("need chance:");
        System.out.println(numOf2 + " x $2 and " + numOf1 + " x $1");
        System.out.println(numOf50c + " x 50c and " + numOf20c + " x 20c");
        System.out.println(numOf10c + " x 10c and " + numOf5c + " x 5c");



    }
}
