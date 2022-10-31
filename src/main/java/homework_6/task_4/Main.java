package homework_6.task_4;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> zonesArray = new ArrayList<>(ZoneId.getAvailableZoneIds());
        List<String> zonesArraySort = zonesArray.stream().filter(s -> !s.contains("Etc/GMT")).collect(Collectors.toList());
        Scanner scanner = new Scanner(System.in);
        int numberZones = zonesArraySort.size();
        System.out.println("Введите два числа от 1 до " + numberZones);
        System.out.println("Первое число:");
        int number1 = valueCheck(scanner);
        while (number1 < 1 || number1 > numberZones) {
            System.out.println("Число должно быть от 1 до " + numberZones + ". Повторите ввод.");
            number1 = valueCheck(scanner);
        }
        System.out.println("Второе число:");
        int number2 = valueCheck(scanner);
        while (number2 < 1 || number2 > numberZones) {
            System.out.println("Число должно быть от 1 до " + numberZones + ". Повторите ввод.");
            number2 = valueCheck(scanner);
        }
        LocalDateTime dateTimeNow = LocalDateTime.now();
        ZoneId zonaNow = TimeZone.getDefault().toZoneId();
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.of(dateTimeNow, zonaNow);
        ZonedDateTime zonedDateTime1 = zonedDateTimeNow.withZoneSameInstant(ZoneId.of(zonesArraySort.get(number1 - 1)));
        ZonedDateTime zonedDateTime2 = zonedDateTime1.withZoneSameInstant(ZoneId.of(zonesArraySort.get(number2 - 1)));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm, dd-MM-yyyy");
        System.out.println("Сейчас " + zonedDateTime1.format(dateTimeFormatter) + " временная зона: " + ZoneId.of(zonesArraySort.get(number1 - 1)));
        System.out.println("В это же время " + zonedDateTime2.format(dateTimeFormatter) + " временная зона: " + ZoneId.of(zonesArraySort.get(number2 - 1)));
    }

    public static int valueCheck(Scanner scanner) {
        boolean scan = true;
        int number = 0;
        while (scan) {
            if (!scanner.hasNextInt()) {
                System.out.println("Похоже вы ввели не число. Повторите ввод.");
                scanner.nextLine();
            } else {
                number = scanner.nextInt();
                scanner.nextLine();
                scan = false;
            }
        }
        return number;
    }
}

