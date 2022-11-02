package homework_1.task_1;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите сумму, которую хотите внести");
        float deposit = getPositiveFloatNumber();
        System.out.println("Введите на сколько лет Вы планируете делать вклад");
        int year = getPositiveIntNumber();
        System.out.println("Введите процентную ставку (% годовых)");
        float percent = getPositiveFloatNumber();
        float profit = profitCalculation(deposit, year, percent);
        System.out.printf("При данных условиях вложения Ваш доход по процентам составит: %.2f", profit);
    }

    public static float profitCalculation(float deposit, int year, float percent) {
        float income;
        float profit = 0;
        for (int i = 1; i <= year; i++) {
            income = (deposit * percent) / 100;
            if (income <= 42500) {
                deposit += income;
                profit += income;
            } else {
                income -= (income - 42500) * 13 / 100;
                deposit += income;
                profit += income;
            }
        }
        return profit;
    }

    private static float getPositiveFloatNumber() {
        String s = scanner.nextLine();
        float deposit;
        while (true)
            try {
                deposit = Float.parseFloat(s);
                if (deposit <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число.");
                s = scanner.nextLine();
            }
        return deposit;
    }
    private static int getPositiveIntNumber() {
        String s = scanner.nextLine();
        int year;
        while (true)
            try {
                year = Integer.parseInt(s);
                if (year <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число.");
                s = scanner.nextLine();
            }
        return year;
    }
}
