package ru.ac.uniyar.IvanVoronov;

import java.util.Scanner;

public class CheckingInput {
    public static int inputOneInt(Scanner input) {
        while (true) {
            String data = input.nextLine();
            int answer;
            try {
                answer = Integer.parseInt(data);
            } catch (NumberFormatException e) {
                System.out.print("По русски написано же, целое число!\nПовторите ввод: ");
                continue;
            }
            return answer;
        }
    }
}
