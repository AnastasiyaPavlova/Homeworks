package homework_2.task_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что бы поделать?");
        s = scanner.nextLine();
        if (s.equals("Ничего не делай")) {
            System.out.println("Пойду побездельничаю");

        } else {
            while (true) {
                System.out.println("Что бы еще поделать?");
                s = scanner.nextLine();
                if (s.equals("Ничего не делай")) {
                    System.out.println("Пойду побездельничаю");
                    break;
                }
            }
        }
    }
}