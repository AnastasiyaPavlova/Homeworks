package homework_3.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, value;
        ArrayList<Integer> arrayNumbers = new ArrayList<>();
        ArrayList<Integer> arrayCount = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество чисел, которые будете считывать");
        n = Integer.parseInt(reader.readLine());
        System.out.println("Введите числа");
        for (int i = 0; i < n; i++) {
            value = Integer.parseInt(reader.readLine());
            if (arrayNumbers.indexOf(value) == -1) {
                arrayNumbers.add(value);
                arrayCount.add(1);
            } else {
                arrayCount.set(arrayNumbers.indexOf(value), arrayCount.get(arrayNumbers.indexOf(value)) + 1);
            }
        }
        for (int i = 0; i < arrayCount.size(); i++) {
            if (arrayCount.get(i) > 1) {
                for (int k = 0; k < arrayCount.get(i); k++) {
                    System.out.print((arrayNumbers.get(i)) + " ");
                }
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("Уникальные числа");
        for (int i = 0; i < arrayCount.size(); i++) {
            if (arrayCount.get(i) == 1) {
                System.out.println(arrayNumbers.get(i));
            }
        }
    }
}

