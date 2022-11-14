package homework_1.task_2;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Какое по счету число последовательности Фибоначчи Вы хотите увидеть?");
        int n = getPositiveIntNumber();
        int numberFib = numberFibonachchi(n);
        System.out.println("Ваше число" + " " + numberFib);
    }

    public static int numberFibonachchi(int n) {
        int[] fibonachchiArray = new int[n];
        fibonachchiArray[0] = 0;
        fibonachchiArray[1] = 1;
        int i;
        for (i = 2; i < n; i++) {
            fibonachchiArray[i] = fibonachchiArray[i - 1] + fibonachchiArray[i - 2];
        }
        return fibonachchiArray[i - 1];
    }

    private static int getPositiveIntNumber() {
        String s = scanner.nextLine();
        int positiveIntNumber;
        while (true)
            try {
                positiveIntNumber = Integer.parseInt(s);
                if (positiveIntNumber <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число.");
                s = scanner.nextLine();
            }
        return positiveIntNumber;
    }
}