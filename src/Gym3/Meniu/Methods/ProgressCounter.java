package Gym3.Meniu.Methods;

import Gym3.ScannerClass;
import Gym3.WriteHTML;
import Gym3.Write_Read_File;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

public class ProgressCounter {

    public static void getInfo(String ClientID, int parameterColumn, String parameterName) throws ParseException {
        System.out.println("Prasau iveskite dvi datas yyyy-mm-dd formatu, Jusu svrio pokyciui paskaiciuoti");
        System.out.print("nuo");
        String stringDateFrom = InputValidation.isThisDateValid(ScannerClass.getStringInputValue(), ClientID);
        System.out.print("iki");
        String stringDateTo = InputValidation.isThisDateValid(ScannerClass.getStringInputValue(), ClientID);

        List<String> selectedDates = collectList(
                ClientID,
                parameterColumn,
                parameterName,
                stringDateFrom,
                stringDateTo)[0];
        List<String> parameters = collectList(
                ClientID,
                parameterColumn,
                parameterName,
                stringDateFrom,
                stringDateTo)[1];


        String header = "";
        String filePath = "";
        String unit = "";
        if (parameterName.equals("weight")){
            header = "Data \t\t\t\t svoris\n-------------------------";
            filePath = "All_Clients\\" + ClientID + "\\" + ClientID + "_weight.html";
            unit = " kg";
            Write_Read_File.deleteFile(filePath);
        }else if (parameterName.equals("bmi")){
            header = "Data \t\t\t\t BMI indeksas\n-------------------------";
            filePath = "All_Clients\\" + ClientID + "\\" + ClientID + "_BMI.html";
            unit = "";
            Write_Read_File.deleteFile(filePath);
        }

        System.out.println(header);
        for (int i = 0; i<selectedDates.size();i++){
            System.out.println(selectedDates.get(i)+"\t|\t"+parameters.get(i)+unit);
        }

        String clientHTML = WriteHTML.geretateHTML(
                selectedDates,
                parameters,
                ClientID,
                stringDateFrom,
                stringDateTo,
                unit);

        Write_Read_File.writeHTMLFile("",clientHTML, filePath);

    }

    private static List<String>[] collectList(String ClientID, int parameterColumn, String parameterName, String stringDateFrom, String stringDateTo) throws ParseException {
        List<String>[] listArray = new List[2];

        LocalDate dateFrom = parseToDate(stringDateFrom);
        LocalDate dateTo = parseToDate(stringDateTo);

        List<String> selectedDates = new ArrayList<>();
        List<String> parameters = new ArrayList<>();

        for (LocalDate date = dateFrom; date.isBefore(dateTo.plusDays(1)); date = date.plusDays(1)) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            selectedDates.add(date.format(df));
            parameters.add(Write_Read_File.findSomethingInCommonFile(
                    "All_Clients\\" + ClientID + "\\" + ClientID +".csv",
                    1,
                    parameterColumn,
                    dateToString(date)));
        }
        listArray[0]=selectedDates;
        listArray[1]=parameters;
        return listArray;
    }

    public static LocalDate parseToDate(String stringDate) throws ParseException {
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

