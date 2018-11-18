package pl.coderslab;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) {
        throwDice();
    }

    static void throwDice() {
        Scanner scan = new Scanner(System.in);
        int throwNumber = 1;
        int mod = 0;
        int dice = 1;
        String input = "";
        String plusMinus = "";
        try {
            System.out.println("Podaj ilość rzutów, rodzaj kostki i modyfikator w formule: xDy + z, gdzie: \n x = liczba rzutów, \n y = rodzaj kostki \n z = modyfikator");
            do {
                System.out.println("Dostępne kostki to D3, D4, D6, D8, D10, D12, D20, D100");
                input = scan.nextLine();
            }
            while (!input.contains("D3") && !input.contains("D4") && !input.contains("D6") && !input.contains("D8") && !input.contains("D10") && !input.contains("D12") && !input.contains("D20") && !input.contains("D100"));
            StringTokenizer tokenizer = new StringTokenizer(input, "D", false);
            int tokNum = tokenizer.countTokens();
            String temp = "";
            if(tokNum != 1) {
                String thrNumb = tokenizer.nextToken();
                throwNumber = Integer.parseInt(thrNumb);
                temp = tokenizer.nextToken();
            }else {
                temp = tokenizer.nextToken();
            }
            StringTokenizer tokenizer1 = new StringTokenizer(temp, " ", false);
            String tempDice = tokenizer1.nextToken();
            dice = Integer.parseInt(tempDice);
            Random random = new Random();
            int counter = 0;
            int sum = 0;
            int value = 0;
            if (tokenizer1.hasMoreTokens()) {

                plusMinus = tokenizer1.nextToken();
                String tempMod = tokenizer1.nextToken();
                mod = Integer.parseInt(tempMod);

                if (plusMinus.equals("+")) {
                    do {
                        value += random.nextInt(dice + 1) + 1;
                        counter++;
                    } while (counter != throwNumber);
                    value += mod;
                } else if (plusMinus.equals("-")) {
                    do {
                        value += random.nextInt(dice + 1) + 1;
                        counter++;
                    } while (counter != throwNumber);
                }
            } else {
                value = random.nextInt(dice + 1) + 1;
                counter++;
            }
            System.out.println("Wynik rzutu/ów to: " + value);
        } catch (NoSuchElementException e) {
            System.err.println("Formuła musi wyglądać następująco: xDy + z");
        }
    }
}

