package homework_2.task_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        exceptional();
    }

    public static void exceptional() {
        String s;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Введите строку");
                s = scanner.nextLine();
                if (s.equalsIgnoreCase("отстань от меня, пожалуйста")) {
                    throw new Exception();
                } else {
                    System.out.println("Давай попробуем снова");
                }
            }
        } catch (Exception e) {
            System.out.println("Ха-ха! Попался! я поймал исключение");
        }
        System.out.println("До свидания");
    }
}