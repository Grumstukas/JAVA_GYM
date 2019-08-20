package JAVA_GYM.Meniu.Methods;

import JAVA_GYM.ScannerClass;
import JAVA_GYM.Write_Read_File;

import java.util.List;

public class Payment {

    public static void countPriceToPay(String userID) {
        String userActivityFile = "All_Clients\\" + userID + "\\" + userID + ".csv";
        String userPaymentFile = "All_Clients\\" + userID + "\\" + userID + "payments.csv";
        List<String> allUserActivityFileLines = Write_Read_File.readAllGivenFileLinesAndReturnListOfAllLines(userActivityFile);
        double minutePrice = 0.1;

        int sumOfSpentMinutes = 0;

        for ( int i = 2; i < allUserActivityFileLines.size(); i++ ) {
            String line[] = allUserActivityFileLines.get(i).split(",");
            sumOfSpentMinutes = sumOfSpentMinutes + Integer.parseInt(line[4]);
        }
        double moneyAlreadyPaid = moneyAlreadyPaid(userPaymentFile, 2);
        double sumOfMoneyToPay = (double) Math.round(((sumOfSpentMinutes * minutePrice) - moneyAlreadyPaid) * 100) / 100;

        if ( sumOfMoneyToPay == 0 ) {
            System.out.println("uz treniruotes nesate skolingas");
        } else {
            System.out.println("Jums reikia susimoketi uz treniruotes :  " + sumOfMoneyToPay + "eur");
            System.out.print("Irasykite pinigu suma: ");
            double amountPaid = ScannerClass.getIntDoubleValue();
            String clientInfo = userID + "," + CurrentDate.currentTime()[0] + "," + amountPaid;
            Write_Read_File.writeClientInfoToFile("", clientInfo, userPaymentFile);

            if ( amountPaid > sumOfMoneyToPay ) {
                double sumForReturn = amountPaid - sumOfMoneyToPay;
                System.out.println("Aciu, Jusu graza: " + sumForReturn);
            } else if ( amountPaid == sumOfMoneyToPay ) {
                System.out.println("Aciu");
            } else if ( amountPaid < sumOfMoneyToPay ) {
                double restAmount = (double) Math.round((sumOfMoneyToPay - amountPaid) * 100) / 100;
                System.out.println("Aciu, taciau sumokejote ne viska, jums lieka " + restAmount + "eur skola.");
            }
        }
    }

    public static Double moneyAlreadyPaid(String pathToRead, int indexOfRequiredColumn) {
        List<String> allThisFileLines = Write_Read_File.readAllGivenFileLinesAndReturnListOfAllLines(pathToRead);
        double sum = 0;

        for ( int i = 1; i < allThisFileLines.size(); i++ ) {
            String[] splicedLine = allThisFileLines.get(i).split(",");
            sum += Double.parseDouble(splicedLine[indexOfRequiredColumn]);
        }
        return sum;
    }
}
