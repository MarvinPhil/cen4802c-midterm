package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvgCalcTest {


    @Test
    @DisplayName("Normal test")
    public void test() {
        String simulatedInput = "23\n23\n23\n23\n23\n";
        Scanner testScanner = new Scanner(simulatedInput);
        assertEquals(23.00, AverageCalc.averager(5, testScanner), 0);
    }

    @Test
    @DisplayName("Negative test")
    public void test2() {
        String simulatedInput = "-20\n-20\n-20\n";
        Scanner testScanner = new Scanner(simulatedInput);
        assertEquals(-20.00, AverageCalc.averager(3, testScanner), 0);
    }

    @Test
    @DisplayName("Mixed test")
    public void test3() {
        String simulatedInput = "10\n-10\n";
        Scanner testScanner = new Scanner(simulatedInput);
        assertEquals(0.00, AverageCalc.averager(2, testScanner), 0);
    }
}
