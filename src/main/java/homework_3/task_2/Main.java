package homework_3.task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        int a, b, c;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите длину каждой стороны треугольника");
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());
        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            System.out.println("Треугольник существует");
        } else System.out.println("Треугольник не существует");
    }
}
