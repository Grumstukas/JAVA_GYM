package Gym3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDate {
    public static String[] currentTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter nowDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter nowTime = DateTimeFormatter.ofPattern("HH:mm");
        String[] timeInfo = new String[2];
        timeInfo[0] = myDateObj.format(nowDate);
        timeInfo[1] = myDateObj.format(nowTime);
        return timeInfo;
    }

}
