package homework_5_editForTests.services;

import java.util.Scanner;

public class GetDataFromUsersService {
    Scanner scanner = new Scanner(System.in);

    public int getPositiveIntNumber(int numberOfMenuItems) {
        String stringUsers = scanner.nextLine();
        int userChoice;
        while (true)
            try {
                userChoice = Integer.parseInt(stringUsers);
                if (userChoice <= 0 || userChoice > numberOfMenuItems) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число от 1 до " + numberOfMenuItems);
                stringUsers = scanner.nextLine();
            }
        return userChoice;
    }

    public String getStringWithPrintMessageQuery(String message) {
        System.out.println(message);
        String s = scanner.nextLine();
        return s;
    }
}
