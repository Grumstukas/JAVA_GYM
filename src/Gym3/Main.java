package Gym3;

import jdk.nashorn.internal.parser.Scanner;

import java.text.ParseException;
import java.time.LocalDate;

public class Main {

    /**
     * First JavaGym registration pop-up, demands to choose an option.
     * Depending on chosen option this method call second further "registration" or "existing user" method.
     *
     * @author Angry Code Bat
     */
    public static void meniu() throws ParseException {
        System.out.print("Sveiki !\n");
        System.out.println("1. Press ' 1 ' jeigu norite uzsiregistruoti");
        System.out.println("2. Press ' 2 ' jeigu Jums jau suteiktas prisijungimo ID");
        System.out.println("3. Press ' 3 ' informacija apie esamo kliento svorio pokytį per nurodytą laiką");
        System.out.println("4. Press ' 4 ' informacija apie esamo kliento kuno mases indekso pokytį per nurodytą laiką");
        System.out.println("5. Press ' 5 ' atsiskaitymas");

        int userInput = ScannerClass.getIntInputValue();
        switch (userInput) {

            case 1:
                NewGymClient clientNew = new NewGymClient();
                clientNew.takeInfo();
                break;

            case 2:
                System.out.print("Malonu kad sportojate JAVA GYM :)\nPrasom pateikti informacija reikalinga duomenu atnaujinimui.\n");
                System.out.print("Iveskit savo ID numeri:\t");
                String userID = ScannerClass.getStringInputValue();
                if (Write_Read_File.findSomethingInAllFile("All_Clients\\All.csv", 0, userID)) { // gauna kelia ir iesko pagal ID
                    System.out.println("labas " + Write_Read_File.findSomething("All_Clients\\" + userID + ".csv", 7) + "! Kaip sekesi sportuoti ?"); // iesko 6 iraso asmeniniame faile
                    OldGymClient clientOld = new OldGymClient(userID);
                    clientOld.updateInfo();
                } else {
                    System.out.println("Panasu, jog padarete klaida ivesdamas jums suteikta ID, arba nesate registruotas musu sistemoje...\nPabandykite is naujo");
                }
                break;
            case 3:
                System.out.print("Iveskit savo ID numeri:\t");
                String userID2 = ScannerClass.getStringInputValue();
                if (Write_Read_File.findSomethingInAllFile("All_Clients\\All.csv", 0, userID2)) { // gauna kelia ir iesko pagal ID
                    System.out.println("labas " + Write_Read_File.findSomething("All_Clients\\" + userID2 + ".csv", 7) + "! Kaip sekesi sportuoti ?"); // iesko 6 iraso asmeniniame faile

                    System.out.println("Prašau įveskite dvi datas yyyy-mm-dd formatu, Jūsų svrio pokyčiui paskaičiuoti");
                    System.out.print("nuo");
                    String dateFrom = ScannerClass.getStringInputValue();
                    System.out.println("iki");
                    String dateTo = ScannerClass.getStringInputValue();
                    //method
                    ProgressCounter.getInfo(dateFrom, dateTo, userID2);
                } else {
                    System.out.println("Panasu, jog padarete klaida ivesdamas jums suteikta ID, arba nesate registruotas musu sistemoje...\nPabandykite is naujo");
                }
                break;
            case 4:
                break;
            case 5:
                double minutePrice = 0.1;

                System.out.print("Iveskit savo ID numeri:\t");
                String userID3 = ScannerClass.getStringInputValue();
                if (Write_Read_File.findSomethingInAllFile("All_Clients\\All.csv", 0, userID3)) { // gauna kelia ir iesko pagal ID
                    //metodas
                    LocalDate lastPaymentDay = CurrentDate.parseToDate(Write_Read_File.findSomethingInLastLine("All_Clients\\" + userID3+ "payments.csv",1));
                    LocalDate today = LocalDate.now();

                    System.out.println("lastPaymentDay string "+TimeCounter.countMinutes(userID3,lastPaymentDay, today));


                } else {
                    System.out.println("Panasu, jog padarete klaida ivesdamas jums suteikta ID, arba nesate registruotas musu sistemoje...\nPabandykite is naujo");
                }

                break;

            default:
                System.out.println("Error, time to die. Re-run the program.");

        }
    }
    public static void main(String[] args) throws ParseException {
        meniu();
    }
}