package com.guanhf.a01;

import javax.sound.midi.Soundbank;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/02 17:19
 */

//   A box of biscuits can hold 24 biscuits and a container can hold 75 boxes of
//   biscuits. Write a program that prompts the user to enter the total number of
//   biscuits. The program then outputs the number of boxes and the number of
//   containers to ship the biscuits. Note that each box must contain the specified
//   number of biscuits and each container must contain the specified number of
//   boxes. If the last box of biscuits contains less than the number of specified
//   biscuits, you can discard it, and output the number of leftover biscuits.
//   Similarly, if the last container contains less than the number of specified
//   boxes, you can discard it, and output the number of leftover boxes

public class Biscuit {
    public static void main(String[] args) {
        // 常数定义
        final int BISCUITS_PER_BOX = 24;
        final int BOXES_PER_CONTAINER = 75;

        // 创建Scanner对象以读取用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入总饼干数：");
        int totalBiscuits = scanner.nextInt();

        // 计算盒子的总数以及剩余的饼干
        int totalBoxes = totalBiscuits / BISCUITS_PER_BOX;
        int leftoverBiscuits = totalBiscuits % BISCUITS_PER_BOX;

        // 计算容器的总数以及剩余的盒子
        int totalContainers = totalBoxes / BOXES_PER_CONTAINER;
        int leftoverBoxes = totalBoxes % BOXES_PER_CONTAINER;


        // 输出结果
        System.out.println("盒子总数为: " + totalBoxes + ", 剩余饼干为: " + leftoverBiscuits);
        System.out.println("容器总数为: " + totalContainers + ", 剩余盒子为: " + leftoverBoxes);



    }
}


