package Gym3;

import jdk.nashorn.internal.parser.Scanner;

public class Main {

    /**
     * First JavaGym registration pop-up, demands to choose an option.
     * Depending on chosen option this method call second further "registration" or "existing user" method.
     * @author Angry Code Bat
     */
    public static void newOrExistingUser() {
//        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Sveiki !");
            System.out.println();
            System.out.println("1. Press ' 1 ' jeigu norite uzsiregistruoti");
            System.out.println("2. Press ' 2 ' jeigu Jums jau suteiktas prisijungimo ID");
//            int userInput = scan.nextInt();
        int userInput = ScannerClass.getIntInputValue();
            switch (userInput) {

                case 1:
                    NewGymClient clientNew = new NewGymClient();
                    clientNew.takeInfo();
                    break;

                case 2:
                    System.out.print("Malonu kad sportojate JAVA GYM :)\nPrasom pateikti informacija reikalinga duomenu atnaujinimui.\n");
                    System.out.print("Iveskit savo ID numeri:\t");
//                    String userID = scan.next();
                    String userID = ScannerClass.getStringInputValue();
                    if (Write_Read_File.findSomethingInAllFile( "All_Clients\\All.csv",0, userID)){ // gauna kelia ir iesko pagal ID
                        System.out.println("labas " + Write_Read_File.findSomething("All_Clients\\" + userID + ".csv", 6) + "! Kaip sekesi sportuoti ?"); // iesko 6 iraso asmeniniame faile
                        OldGymClient clientOld = new OldGymClient(userID);
                        clientOld.updateInfo();
                    }else{
                        System.out.println("Panasu, jog padarete klaida ivesdamas jums suteikta ID, arba nesate registruotas musu sistemoje...\nPabandykite is naujo");
//                        newOrExistingUser();
                    }
                    break;
                case 3:
                    break;

                default:
                    System.out.println("Error, time to die. Re-run the program.");
//                    newOrExistingUser();
            }
//        } catch (Exception e) {
//            System.out.println("Error, time to die. Re-run the program.");
//        }
    }

    public static void main(String[] args) {
        newOrExistingUser();
//        int stopProgram = 1;
//        do {
//            stopProgram = newOrExistingUser();
//        }while (stopProgram==1);

    }

}