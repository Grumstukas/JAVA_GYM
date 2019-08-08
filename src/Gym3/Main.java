package Gym3;

import java.util.Scanner;

public class Main {

    /**
     * First JavaGym registration pop-up, demands to choose an option.
     * Depending on chosen option this method call second further "registration" or "existing user" method.
     * @author Angry Code Bat
     */
    public static void newOrExistingUser() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Sveiki !");
            System.out.println();
            System.out.println("1. Press ' 1 ' jeigu norite uzsiregistruoti");
            System.out.println("2. Press ' 2 ' jeigu Jums jau suteiktas prisijungimo ID");
            int userInput = scan.nextInt();
            switch (userInput) {
                case 1:
                    NewGymClient clientNew = new NewGymClient(); 
                    clientNew.takeInfo();
                    break;
                case 2:
                    System.out.print("Malonu kad sportojate JAVA GYM :)\n" +
                            "Prasom pateikti informacija reikalinga duomenu atnaujinimui.\n");
                    System.out.print("Iveskit savo ID numeri:\t");
                    String userID = scan.next();
                    if (Write_Read_File.readFile( "All_Clients\\All.csv", userID)){ // gauna kelia ir iesko pagal ID
                        System.out.println("labas " + 
                    Write_Read_File.findSomething("All_Clients\\" + userID + ".csv", 12) + 
                    "! Kaip sekesi sportuoti ?"); // iesko 12 iraso asmeniniame faile pirmoje eiluteje
                        OldGymClient clientOld = new OldGymClient(userID);
                        clientOld.updateInfo();
                    }else{
                        System.out.println("Panasu, jog padarete klaida ivesdamas jums suteikta ID, arba nesate registruotas musu sistemoje...\nPabandykite is naujo");
                        newOrExistingUser();
                    }
                    break;
                default:
                    System.out.println("Error, time to die. Re-run the program.");
                    newOrExistingUser();
            }
        } catch (Exception e) {
            System.out.println("Error, time to die. Re-run the program.");
        }
    }

    public static void main(String[] args) {
        newOrExistingUser();
    }

}