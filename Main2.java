package pl.coderslab;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        lottoGues();

    }

    static void lottoGues() {

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int input = 0;
        int check[] = new int[6];
        int counter = 0;
        while (check[5] == 0) {
            try {
                do {
                    System.out.println("Wpisz typowaną liczbę od 1 do 49:");
                    input = scan.nextInt();
                    if (input >= 1 && input <= 49) {

                        for (int i = 0; i <= counter; i++) {
                            if (input == check[i]) {
                                System.out.println("Ta liczba się powtarza, podaj inną");
                                counter--;
                            }
                        }

                        check[counter] = input;
                        counter++;
                    } else {
                        System.out.println("Musi to być liczba od 1 do 49!");
                    }

                } while (counter != 6);

            } catch (InputMismatchException e) {
                System.err.println("Incorrect input");
                scan.next(); //konsumuję wprowadzoną literę z pamięci Scannera
            }
        }
        Arrays.sort(check);
        System.out.println("Twoje liczby to: " + Arrays.toString(check));
        System.out.println("Wynik losowania:");
        int arr[] = new int[6];
        int counter2 = 1;
        int temp = 0;
        arr[0] = random.nextInt(49) + 1;
        do {
        for (int i = 1; i <= counter2; i++) {
            temp = random.nextInt(49) + 1;
            for (int j = 0; j < counter2 ; j++) {
            if (temp == arr[j]) {
                counter2--;
            }
            }
        }
        arr[counter2] = temp;
        counter2++;
        }while (counter2 != 6);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int counter3 = 0;
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (check[i] == arr[j]) {
                    counter3++;
                }
            }
        }
        if (counter3 < 3) {
            System.out.println("Przykro mi nie trafiłeś minimum 3 żeby coś wygrać");
        } else if (counter3 == 3) {
            System.out.println("Trafiłeś trójkę");
        } else if (counter3 == 4) {
            System.out.println("Trafiłeś czwórkę!");
        } else if (counter3 == 5) {
            System.out.println("Trafiłeś piątkę!!");
        }else {
            System.out.println("Trafiłeś szóstkę!!!");
        }
    }
}