package org.example;

import java.util.Scanner;

public class AverageCalc {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("How many numbers do you want to add?:");
        int n = scn.nextInt();
        scn.nextLine();

        double result = averager(n, scn);

        //testing pipeline
        System.out.printf("The average is %.2f", result);
    }

    public static double averager(double n, Scanner scn){
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println(i+".Enter a number:");
            sum += scn.nextDouble();
            scn.nextLine();
        }

        return sum / n;
    }
}
