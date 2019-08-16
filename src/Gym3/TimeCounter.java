package Gym3;

import java.time.LocalDate;
import java.time.Period;

public class TimeCounter {
    public static int countMinutes(String userID2, LocalDate lastPaymentDay, LocalDate today) {
        int sumOfSpentMinutes = 0;
        Period period = Period.between(lastPaymentDay, today);
        int diff = period.getDays()*10;

//        if (lastPaymentDay.plusDays(7)<= today) {
            for (LocalDate date = lastPaymentDay; date.isBefore(today); date = date.plusDays(1)) {
//                sumOfSpentMinutes += Double.parseDouble(Write_Read_File.findSomethingInCommonFile("All_Clients\\" + userID2 + ".csv",
//                        1, 4, CurrentDate.dateToString(date)));
                System.out.println(CurrentDate.dateToString(date));
                int minutes = Integer.parseInt(Write_Read_File.findSomethingInCommonFile("All_Clients\\" + userID2 + ".csv",
                        1, 4, CurrentDate.dateToString(date)));
                sumOfSpentMinutes = sumOfSpentMinutes + minutes;
            }
//        }

        return sumOfSpentMinutes;
    }
}
