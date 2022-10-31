package homework_6.task_2;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate date;
        int age = 0;
        System.out.println("Введите дату вашего дня рождения в формате дд мм гггг (например 20 10 2022)");
        String s = scanner.nextLine();
        while (true) {
            try {
                date = LocalDate.parse(s, dateTimeFormatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Введенные данные некорректны. Попробуйте еще раз:");
                s = scanner.nextLine();
            }
        }
        LocalDate leapYearMax = LocalDate.now();
        while (!leapYearMax.isLeapYear()) {
            leapYearMax = leapYearMax.minusYears(1);
        }
        if (date.isAfter(leapYearMax)) {
            System.out.println("На вашем жизненном пути еще не встречался високосный год");
        } else {
            while (!date.isLeapYear()) {
                date = date.plusYears(1);
                age += 1;
            }
            for (; date.getYear() <= LocalDate.now().getYear(); date = date.plusYears(4)) {
                System.out.println("В " + date.getYear() + " високосном году вам исполнилось " + age);
                age += 4;
            }
        }
    }
}
