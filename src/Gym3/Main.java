package Gym3;

import java.util.Scanner;

public class Main {

    /**
     * First JavaGym registration pop-up, demands to choose an option.
     * Depending on chosen option this method call second further "registration" or "existing user" method.
     *
     * @author Angry Code Bat
     */
    public static void newOrExistingUser() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Sveiki !");
            System.out.println();
            System.out.println("1. Press ' 1 ' if you want to register.");
            System.out.println("2. Press ' 2 ' if you are an existing user.");
            int userInput = scan.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("I call Toma, dialing..");
                    NewGymClient clientNew = new NewGymClient();
                    clientNew.takeInfo();
                    break;
                case 2:
                    System.out.print("Sveiki, malonu kad sportojate JAVA GYM :)\n" +
                            "Prašom pateikti informacija reikalinga duomenu atnaujinimui.\n");
                    System.out.print("Iveskit savo ID numeri:\t");
                    String userID = scan.next();
                    if (Write_Read_File.readFile( "All_Clients\\All.csv", userID)){
                        System.out.println("labas kakzas....");
                        OldGymClient clientOld = new OldGymClient(userID);
                        clientOld.updateInfo();
                    }else{
                        System.out.println("go to Toma");
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