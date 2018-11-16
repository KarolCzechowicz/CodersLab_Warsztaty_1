package pl.coderslab;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        numberGues();

    }
    static void numberGues () {
        Random random = new Random();
        int ran = random.nextInt(101 - 1) - 1;
        Scanner scan = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println("Zgadnij liczbę");
             input = scan.nextInt();
            if (input < ran) {
                System.out.println("Za mało");
            } else if (input > ran) {
                System.out.println("Za duzo");
            }
        } while (input != ran); {
        }
        System.out.println("Zgadłeś");
    }
}
