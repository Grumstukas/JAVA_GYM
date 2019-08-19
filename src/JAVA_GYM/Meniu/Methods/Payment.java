package JAVA_GYM.Meniu.Methods;

import JAVA_GYM.ScannerClass;
import JAVA_GYM.Write_Read_File;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Payment {

    public static void countPriceToPay(String userID) throws ParseException {
        String userActivityFile = "All_Clients\\" + userID + "\\" + userID + ".csv";
        String userPaymentFile = "All_Clients\\" + userID + "\\" + userID + "payments.csv";
        LocalDate lastPaymentDay = CurrentDate.parseToDate(Write_Read_File.findSomething(userPaymentFile, 1));//registration date
        LocalDate today = LocalDate.now();
        double minutePrice = 0.1;


        int sumOfSpentMinutes = 0;
        Period period = Period.between(lastPaymentDay, today);
        int diff = period.getDays() * 10;

        for (LocalDate date = lastPaymentDay; date.isBefore(today.plusDays(1)); date = date.plusDays(1)) {
            List<String> allActivityLines = Write_Read_File.readAllGivenFileLinesAndReturnListOfAllLines(userActivityFile);
            for (int i = 0; i<allActivityLines.size();i++){
                String [] lineElements = allActivityLines.get(i).split(",");
                if ((CurrentDate.parseToDate(lineElements[1]).isEqual(today) ||
                        (CurrentDate.parseToDate(lineElements[1]).isBefore(today)){
                    int minutes = Integer.parseInt(Write_Read_File.findSomethingInCommonFile(userActivityFile,
                            1, 4, CurrentDate.dateToString(date)));
                    sumOfSpentMinutes = sumOfSpentMinutes + minutes;
                }
            }
        }
        double moneyAlreadyPaid = moneyAlreadyPaid(userPaymentFile, 2);
        double sumOfMoneyToPay = (double) Math.round(((sumOfSpentMinutes * minutePrice) - moneyAlreadyPaid) * 100) / 100;

        if (sumOfMoneyToPay == 0) {
            System.out.println("uz treniruotes nesate skolingas");
        } else {
            System.out.println("Jums reikia susimoketi uz treniruotes :  " + sumOfMoneyToPay + "eur");
            System.out.print("Irasykite pinigu suma: ");
            double amountPaid = ScannerClass.getIntDoubleValue();
            String clientInfo = userID + "," + CurrentDate.currentTime()[0] + "," + amountPaid;
            Write_Read_File.writeClientInfoToFile("", clientInfo, userPaymentFile);

            if (amountPaid > sumOfMoneyToPay) {
                double sumForReturn = amountPaid - sumOfMoneyToPay;
                System.out.println("Aciu, Jusu graza: " + sumForReturn);
            } else if (amountPaid == sumOfMoneyToPay) {
                System.out.println("Aciu");
            } else if (amountPaid < sumOfMoneyToPay) {
                double restAmount = (double) Math.round((sumOfMoneyToPay - amountPaid) * 100) / 100;
                System.out.println("Aciu, taciau sumokejote ne viska, jums lieka " + restAmount + "eur skola.");
            }
        }
    }

    public static Double moneyAlreadyPaid(String pathToRead, int indexOfRequiredColumn) {
        List<String> allThisFileLines = Write_Read_File.readAllGivenFileLinesAndReturnListOfAllLines(pathToRead);
        double sum = 0;

        for (int i = 1; i < allThisFileLines.size(); i++) {
            String[] splicedLine = allThisFileLines.get(i).split(",");
            sum += Double.parseDouble(splicedLine[indexOfRequiredColumn]);
        }
        return sum;
    }
}
