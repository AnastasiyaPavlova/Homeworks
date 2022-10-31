package homework_1.task_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число(количество чисел в массиве)");
        int n = scanner.nextInt();
        System.out.println("Введите массив чисел");
        int[] inArray, outArray;
        inArray = new int[n];
        outArray = new int[n];
        int i;
        for (i = 0; i < n; i++) {
            inArray[i] = scanner.nextInt();
        }
        for (i = 0; i < n; i++) {
            if (i == 0) {
                outArray[i] = inArray[i] + inArray[i + 1];
            } else if (i == n - 1) {
                outArray[i] = inArray[i] + inArray[i - 1];
            } else outArray[i] = inArray[i - 1] + inArray[i] + inArray[i + 1];
        }
        System.out.print("Сумма средних элементов Вашего массива: ");
        for (i = 0; i < n; i++) {
            System.out.print(outArray[i]);
            System.out.print(" ");
        }
    }
}
