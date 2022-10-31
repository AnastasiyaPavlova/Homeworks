package homework_6.task_3;


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
        LocalDateTime dateTimeNow = LocalDateTime.now();
        ZoneId zonaNow = TimeZone.getDefault().toZoneId();
        String zonaNowName = zonaNow.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm, dd-MM-yyyy");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Сейчас в вашей временной зоне " + zonaNowName + ", " + zonaNow);
        System.out.println(dateTimeNow.format(dateTimeFormatter));
        System.out.println("----------------------------------------------------------------");
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.of(dateTimeNow, zonaNow);
        for (int i = 0; i < 10; i++) {
            int randomZoneId = new Random().nextInt(0, 569);
            if (zonesArraySort.get(randomZoneId).equals(zonaNow)) {
                randomZoneId += 1;
            }
            ZonedDateTime zonedDateTimeRandom = zonedDateTimeNow.withZoneSameInstant(ZoneId.of(zonesArraySort.get(randomZoneId)));
            System.out.println("Сейчас " + zonedDateTimeRandom.format(dateTimeFormatter) + " временная зона: " + ZoneId.of(zonesArraySort.get(randomZoneId)));
        }
    }
}

