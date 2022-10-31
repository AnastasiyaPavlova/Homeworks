package homework_6.task_1;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate date;
        System.out.println("Введите дату или несколько дат в формате дд мм гггг (например 20 10 2022)");
        System.out.println("Чтобы закончить ввод дат введите 'Хватит'");
        String s = scanner.nextLine();
        while (!s.equalsIgnoreCase("Хватит")) {
            while (true) {
                if (!s.equalsIgnoreCase("Хватит")) {
                    try {
                        date = LocalDate.parse(s, dateTimeFormatter);
                        System.out.print(date.format(dateTimeFormatter) + " ");
                        System.out.println(date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru")));
                        s = scanner.nextLine();
                    } catch (DateTimeParseException e) {
                        System.out.println("Введенные данные некорректны. Попробуйте еще раз");
                        s = scanner.nextLine();
                    }
                }
                break;
            }
        }
    }
}



