package Gym3;

import java.util.Scanner;

public class Main {
    protected static NewGymClient sportsman;

    public static void main(String[] args) {
        String sportsmanName;

        Scanner input = new Scanner(System.in);
        System.out.print("Kuo jus vardu?\t\t\t\t|\t");
        sportsmanName = input.next();

        sportsman = new NewGymClient(sportsmanName);
        sportsman.takeInfo();
//        options();
    }

    private static void options() {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("press 1 to collect info about you");
        System.out.println("press 2 to get your activity and progress info");
        System.out.println("press 3 to get your friend activity and progress info");
        System.out.println("press 4 to sign out");
        choice = input.nextInt();
        switch (choice){
            case 1:
                sportsman.takeInfo();
//                takeInfo();
//                sportsman.writeToFile();
//                sportsman.writeToClientBook();
                options();
                break;
            case 2:
                System.out.println("wait....");
                break;
            case 3:
                System.out.println("wait....");
                break;
            case 4:
                System.out.println("wait....");
                break;
                default:
        }

    }

//    private static void takeInfo() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Please provide us with your registration information.");
//        System.out.print("Vardas ir Pavardė: \t|\t");
//        sportsman.setClientName(input.next());
//
//        System.out.print("telefono numeris: \t|\t");
//        sportsman.setPhoneNumber(input.next());
//
//        System.out.print("elektroninis paštas: \t|\t");
//        sportsman.setEmail(input.next());
//
//        System.out.print("kūno masė (kg): \t\t|\t");
//        sportsman.setClientWeight(input.nextDouble());
//
//        System.out.print("kūno ūgis(cm): \t\t|\t");
//        sportsman.setClientHeight(input.nextDouble());
//    }
}
