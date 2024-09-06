package com.guanhf.a02;


/*
1. The program randomly gives an integer of 1-1000, and then
lets you guess what number it is. You can guess any number,
the game will prompt too big or too small, so as to narrow
the result range. After several guesses and prompts, the answer
is finally given. In the process of the game, record the number of
times you need to guess right at the end of the game and publish the results.
You can guess up to 10 times. After the game is over,If you want to play again,
select y to restart the game and N to exit the program
*/

import java.security.SecureRandom;
import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        final int answer = secureRandom.nextInt(1000) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("answer: " + answer);

        System.out.println("welcome to the guess game!");

        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("please enter the answer you guess: ");
                int guessNumber = scanner.nextInt();
                if (guessNumber > answer) {
                    System.out.println("too big, try again!");

                }else if(guessNumber < answer) {
                    System.out.println("too small, try again!");
                }else{
                    System.out.println("congratulations you, win!!!");
                    System.out.println("you cost " + (i + 1) + " times");
                    break;
                }
                System.out.println("left times: " + (10 - i - 1));
                if(i == 9){
                    System.out.println("times used off, game over!!");
                    break;
                }
            }
            System.out.println("would you like to play again (y or n)?: ");
            String again = scanner.next();
            if(!again.equalsIgnoreCase("y")){
                break;
            }
            System.out.println("welcome to play again!!");
        }
        System.out.println("game halt, welcome to play next time!!");
    }
}
