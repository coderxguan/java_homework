package com.guanhf.trail1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/13 17:38
 */
public class a18 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        while(num > 0){
            int remainder = num % 2;
            stack.push(remainder);
            num = num / 2;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }


    }
}
