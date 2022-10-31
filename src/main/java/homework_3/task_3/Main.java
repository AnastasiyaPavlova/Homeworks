package homework_3.task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int a, b, c;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число, с которого начинается последовательность");
        a = Integer.parseInt(reader.readLine());
        System.out.println("Введите число, на котором заканчивается последовательность");
        b = Integer.parseInt(reader.readLine());
        System.out.println("Введите число, которому должны быть кратны числа последовательности");
        c = Integer.parseInt(reader.readLine());
        for (int i = a; i <= b; i++) {
            if (i % c == 0) System.out.print(i + " ");
        }
    }
}
