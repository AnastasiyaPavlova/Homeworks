package homework_1.task_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какое по счету число последовательности Фибоначчи Вы хотите увидеть?");
        int n = scanner.nextInt();
        int[] fibonachi;
        fibonachi = new int[n];
        fibonachi[0] = 0;
        fibonachi[1] = 1;
        int i = 2;
        while (i < n) {
            fibonachi[i] = fibonachi[i - 1] + fibonachi[i - 2];
            i++;
        }
        System.out.println("Ваше число" + " " + fibonachi[n - 1]);
    }
}