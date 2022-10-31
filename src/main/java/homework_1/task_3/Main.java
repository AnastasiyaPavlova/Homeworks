package homework_1.task_3;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        int val;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayFibonachi = new ArrayList<>();
        ArrayList<Integer> arrayNotfibonachi = new ArrayList<>();
        System.out.println("Введите число");
        int n = scanner.nextInt();
        System.out.println("Введите" + " " + n + " " + "чисел");
        for (int i = 0; i < n; i++) {
            val = scanner.nextInt();
            if (sqrt(5 * val * val + 4) % 1 == 0 || sqrt(5 * val * val - 4) % 1 == 0) {
                arrayFibonachi.add(val);
            } else {
                arrayNotfibonachi.add(val);
            }
        }
        System.out.println("Числа из последовательности Фибоначчи: ");
        for (Integer el : arrayFibonachi) {
            System.out.print(el + " ");
        }
        System.out.println("");
        System.out.println("Числа не входящие в последовательность Фибоначчи: ");
        for (Integer el : arrayNotfibonachi) {
            System.out.print(el + " ");
        }
    }
}


