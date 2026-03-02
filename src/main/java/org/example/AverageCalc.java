package org.example;

//import java.util.Scanner;

public class AverageCalc {
    public static void main(String[] args) {
        //Scanner scn = new Scanner(System.in);

        System.out.println("How many numbers do you want to add?: 3");
        //int n = scn.nextInt();
        //scn.nextLine();
        int n = 3;
        double[] numbers = {10.0, 20.0, 30.0};

        double result = averager(n, numbers);

        //testing pipeline
        System.out.printf("The average is %.2f", result);
    }

    public static double averager(double n, double[] numbers){
        double sum = 0;
        if (numbers.length == 0) return 0;
        for (double num : numbers) {
            sum += num;
        }

        /*for (int i = 1; i <= n; i++) {
            System.out.println(i+".Enter a number:");
            sum += scn.nextDouble();
            scn.nextLine();
        }*/

        return sum / n;
    }
}
