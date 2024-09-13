package com.guanhf.trail1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // 使用埃拉托斯特尼筛法预先计算出区间 [2, b] 内的所有质数
        List<Integer> primes = sieveOfEratosthenes(b);

        for (int i = a; i <= b; i++) {
            System.out.print(i + "=");
            primeFactorization(i, primes);
        }
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor * factor; j <= n; j += factor) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void primeFactorization(int n, List<Integer> primes) {
        boolean firstFactor = true;
        for (int prime : primes) {
            if (prime > n) {
                break;
            }
            while (n % prime == 0) {
                if (!firstFactor) {
                    System.out.print("*");
                }
                System.out.print(prime);
                n /= prime;
                firstFactor = false;
            }
        }
        if (n > 1) {
            if (!firstFactor) {
                System.out.print("*");
            }
            System.out.print(n);
        }
        System.out.println();
    }
}
