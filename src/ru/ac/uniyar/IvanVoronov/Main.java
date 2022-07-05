package ru.ac.uniyar.IvanVoronov;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		String[] parData = data.split(" ");
		Fraction num1 = inputFraction(parData[0]);
		Fraction num2 = inputFraction(parData[2]);

		switch (parData[1]) {
			case "+":
				System.out.println(num1.sum(num2).toString());
				break;
			case "-":
				System.out.println(num1.dif(num2).toString());
				break;
			case "*":
				System.out.println(num1.multiply(num2).toString());
				break;
			case "/":
				if (num2.isZero()) {
					System.out.println("Деление на ноль!");
				} else {
					System.out.println(num1.div(num2).toString());
				}
				break;
		}
	}

	public static Fraction inputFraction(String fraction) {
		String[] data = fraction.split("/");
		if (data.length == 1) {
			return new Fraction(Integer.parseInt(data[0]));
		}
		return new Fraction(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
	}
}
