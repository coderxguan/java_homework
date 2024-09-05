package com.guanhf.a01;

import java.util.Scanner;

/**
 * 功能:
 * 作者:
 * 日期:2024/09/05 16:47
 */

/*
3. You have several pictures of different sizes that you would like to frame.
A local picture framing store offers two types of frames – regular and fancy.
The frames are available in white and can be ordered in any colour the customer desires.
Suppose that each frame is 1 inch wide. The cost of colouring the frame is $0.10 per inch.
The cost of a regular frame is $0.15 per inch and the cost of a fancy frame is $0.25 per inch.
The cost of putting a cardboard paper behind the picture is $0.02 per square inch and
the cost of putting glass on top of the picture is $0.07 per square inch.
The customer can also choose to put crowns on the corners, which cost $0.35 per crown.
Write a program that prompts the user to input the following information and then output
the cost of framing the picture.
a) The length and width, in inches, of the picture
b) The type of the frame
c) Customer’s choice of colour to colour the frame
d) If the user wants to put the crowns, then the number of crowns.
*/
public class Frame {
    public static void main(String[] args) {

        // variety of price
        final double  colouringPerInch = 0.1;
        final double regularPerInch = 0.15;
        final double fancyPerInch = 0.25;
        final double cardboardBehindPerSquareInch = 0.02;
        final double glassPerSquareInch = 0.07;
        final double perCrown = 0.35;

        double totalPrice = 0;

        int length, width;
        String type;
        String cardboardBehind;
        String glass;
        String color;
        int crowns;
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input the length: ");
        length = scanner.nextInt();
        System.out.print("please input the width: ");
        width = scanner.nextInt();
        System.out.print("please input the type \n regular or fancy: ");
        type = scanner.next();
        System.out.print("please input the color: ");
        color = scanner.next();
        System.out.print("please input the number\n of crowns you want: ");
        crowns = scanner.nextInt();
        System.out.print("would you like to put a cardboard paper behind \n y or n: ");
        cardboardBehind = scanner.next();
        System.out.print("would you like to put a glass paper on the top \n y or n: ");
        glass = scanner.next();

        int square = length * width;
        double typePrice;
        if(type.equals("regular")){
            typePrice = width * regularPerInch;
        }else{
            typePrice = width * fancyPerInch;
        }
        double colorPrice = width * colouringPerInch;
        double crownsPrice = crowns * perCrown;
        double cardboardPrice = "y".equals(cardboardBehind.toLowerCase()) ? square * cardboardBehindPerSquareInch : 0;
        double glassPrice = "y".equals(glass.toLowerCase()) ? square * glassPerSquareInch : 0;

        totalPrice = typePrice + colorPrice + crownsPrice + cardboardPrice + glassPrice;

        System.out.println("total price: $" + totalPrice);
    }
}


