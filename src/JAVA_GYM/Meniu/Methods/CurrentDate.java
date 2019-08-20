package JAVA_GYM.Meniu.Methods;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CurrentDate {
    public static String[] currentTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter nowDate = DateTimeFormatter.ofPattern("dd-MM-yy");
        DateTimeFormatter nowTime = DateTimeFormatter.ofPattern("HH:mm");
        String[] timeInfo = new String[2];
        timeInfo[0] = myDateObj.format(nowDate);
        timeInfo[1] = myDateObj.format(nowTime);
        return timeInfo;
    }

    public static LocalDate parseToDate(String stringDate) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd-MM-yy");
        LocalDate date = format.parse(stringDate).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return date;
    }

    public static String dateToString(LocalDate date) {
        DateTimeFormatter nowDate = DateTimeFormatter.ofPattern("dd-MM-yy");
        String stringDate = date.format(nowDate);
        return stringDate;
    }

}
