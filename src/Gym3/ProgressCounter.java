package Gym3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

public class ProgressCounter {
    public static List[] getInfo(String stringDateFrom, String stringDateTo, String ClientID) throws ParseException {
        LocalDate dateFrom = parseToDate(stringDateFrom);
        LocalDate dateTo = parseToDate(stringDateTo);
        List<String> selectedDates = new ArrayList<>();
        List<String> parameters = new ArrayList<>();
        List[] collectedInfo = new List[2];
        for (LocalDate date = dateFrom; date.isBefore(dateTo); date = date.plusDays(1)) {
            selectedDates.add(dateToString(date));
            parameters.add(Write_Read_File.findSomethingInCommonFile("All_Clients\\" + ClientID + ".csv",
                    1,
                    5, dateToString(date)));
        }
        System.out.println(selectedDates);
        System.out.println(parameters);

        String clientHTTML = WriteHTML.geretateHTML(selectedDates, parameters, ClientID, stringDateFrom, stringDateTo);
        Write_Read_File.writeClientInfoToFile(" ",clientHTTML, "All_Clients\\" + ClientID + ".html");

        return collectedInfo;
    }

    private static LocalDate parseToDate(String stringDate) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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

