package ru.ac.uniyar.IvanVoronov;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Введите число операций: ");
		int num = CheckingInput.inputOneInt(input);
		List<String> expressions = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			String expression = input.nextLine();
			expressions.add(expression);
		}
		for (int i = 0; i < num; i++) {
			String[] parData = expressions.get(i).split(" ");
			String answer = calculate(parData[0], parData[1], parData[2]);
			System.out.println(answer);
		}
	}

	public static String calculate(String num1, String operation, String num2) {
		Fraction number1 = Fraction.parseFraction(num1);
		Fraction number2 = Fraction.parseFraction(num2);

		switch (operation) {
			case "+":
				return number1.sum(number2).toString();
			case "-":
				return number1.dif(number2).toString();
			case "*":
				return number1.multiply(number2).toString();
			case "/":
				if (number2.isZero()) {
					return  "Деление на ноль!";
				} else {
					return  number1.div(number2).toString();
				}
			default:
				return "Ошибка!";
		}
	}
}
