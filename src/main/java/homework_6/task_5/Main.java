package homework_6.task_5;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        System.out.println("Введите дату в формате дд мм гггг (например 20 10 2022)");
        String s = scanner.nextLine();
        LocalDate date;
        while (true) {
            try {
                date = LocalDate.parse(s, dateTimeFormatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Введенные данные некорректны. Попробуйте еще раз");
                s = scanner.nextLine();
            }
        }
        ArrayList<Holidays> holidaysArray = new ArrayList<>();
        holidaysArray.add(new Holidays("31 12", "Новый Год", "рабочий"));
        holidaysArray.add(new Holidays("05 10", "День Учителя", "рабочий"));
        holidaysArray.add(new Holidays("01 09", "День Знаний", "рабочий"));
        holidaysArray.add(new Holidays("01 01", "Международный день похмелья", "выходной"));
        Holidays holiday = new Holidays(null, null, null);
        DateTimeFormatter dateTimeFormatterHolidays = DateTimeFormatter.ofPattern("dd MM");
        for (Holidays h : holidaysArray) {
            if (h.getDateHoliday().equals(date.format(dateTimeFormatterHolidays))) {
                holiday = h;
                break;
            } else holiday = null;
        }
        switch (date.getDayOfWeek()) {
            case MONDAY -> System.out.println("Это понедельник! Понедельник обычно рабочий день.");
            case TUESDAY -> System.out.println("Это вторник! Вторник обычно рабочий день.");
            case WEDNESDAY -> System.out.println("Это среда! Среда обычно рабочий день.");
            case THURSDAY ->
                    System.out.println("Это четверг! А как известно четверг это маленькая пятница!  Четверг обычно рабочий день.");
            case FRIDAY ->
                    System.out.println("Это пятница!  В пятницу обычно короткий рабочий день и можно пораньше уйти с работы.");
            case SATURDAY -> System.out.println("Это суббота! А значит выходной день.");
            case SUNDAY -> System.out.println("Это воскресенье! А значит выходной день.");
        }
        if (holiday != null) {
            if (holiday.getTypeHoliday().equals("рабочий")) {
                System.out.println("Но это праздничный день, так как в этот день " + holiday.getNameHoliday());
            } else {
                System.out.println("Но это праздничный день, так как в этот день " + holiday.getNameHoliday() + " и этот день выходной!");
            }
        }
    }
}







