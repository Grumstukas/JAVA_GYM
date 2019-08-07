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
            System.out.println("Good day!");
            System.out.println();
            System.out.println("1. Press ' 1 ' if you want to register.");
            System.out.println("2. Press ' 2 ' if you are an existing user.");
            int userInput = scan.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("I call Toma, dialing..");
                    NewGymClient client = new NewGymClient();
                    client.takeInfo();
                    break;
                case 2:
                    System.out.println("I call Oksana, dialing.. Woops, no answer here!");
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
//        private static void options() {
//            int choice;
//            Scanner input = new Scanner(System.in);
//            System.out.println("press 1 to collect info about you");
//            System.out.println("press 2 to get your activity and progress info");
//            System.out.println("press 3 to get your friend activity and progress info");
//            System.out.println("press 4 to sign out");
//            choice = input.nextInt();
//            switch (choice){
//                case 1:
//                    sportsman.takeInfo();
////                    takeInfo();
////                    sportsman.writeToFile();
////                    sportsman.writeToClientBook();
//                    options();
//                    break;
//                case 2:
//                    System.out.println("wait....");
//                    break;
//                case 3:
//                    System.out.println("wait....");
//                    break;
//                case 4:
//                    System.out.println("wait....");
//                    break;
//                    default:
//            }
//
//        }
}