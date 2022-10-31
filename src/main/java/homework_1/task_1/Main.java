package homework_1.task_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму, которую хотите внести");
        float sum = scanner.nextFloat();
        System.out.println("Введите на сколько лет Вы планируете делать вклад");
        int year = scanner.nextInt();
        System.out.println("Введите процентную ставку (% годовых)");
        float percent = scanner.nextFloat();
        float income;
        float profit = 0;
        for (int i = 1; i <= year; i++) {
            income = (sum * percent) / 100;
            if (income <= 42500) {
                sum += income;
                profit += income;
            } else {
                income -= (income - 42500) * 13 / 100;
                sum += income;
                profit += income;
            }

        }

        System.out.println("При данных условиях вложения Ваш доход по процентам составит " + profit);
    }
}