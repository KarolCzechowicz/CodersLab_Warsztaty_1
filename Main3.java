package pl.coderslab;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        numberGuess2();

    }
    static void numberGuess2 () {
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja zgadnę w max. 10 próbach");
        Scanner scan = new Scanner(System.in);
        int min = 0;
        int max = 1000;
        String input = "";
        System.out.println("Powiedz mi czy zgadłem - zgadłeś, jeśli za dużo to - za dużo, jeśli za mało to - za mało");
        do {
            int guess = ((max - min) / 2) + min;
            System.out.println("Zgaduję: " + guess);
            input = scan.nextLine();
            if (input.equals("zgadłeś")) {
                System.out.println("Wygrałem!");
            } else if (input.equals("za dużo")) {
                max = guess;

            } else if (input.equals("za mało")) {
                min = guess;
            } else {
                System.out.println("Nie oszukuj!");
            }
        } while (!input.equals("zgadłeś"));
    }
}
