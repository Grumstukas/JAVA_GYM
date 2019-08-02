package Gym2;

import java.util.Scanner;

public class Main {
    protected static GymClient sportsman;

    public static void main(String[] args) {
    String sportsmanName;

        Scanner input = new Scanner(System.in);
        System.out.print("Hello, what's your name?\t|\t");
        sportsmanName = input.next();

        sportsman = new GymClient(sportsmanName);
        options();
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
                takeInfo();
                sportsman.writeToFile();
                sportsman.writeToClientBook();
                options();
                break;
            case 2:
                sportsman.getProgressInfo(sportsman.getClientName());
                options();
                break;
            case 3:
                System.out.println("What's your friend name ?");
                sportsman.getProgressInfo(input.next());
                options();
                break;
            case 4:
                System.out.println("wait....");
                break;
                default:
        }

    }

    private static void takeInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("what's your height? (cm)\t|\t");
        sportsman.setClientHeight(input.nextDouble()/100);

        System.out.print("what's your weight(kg)?\t\t|\t");
        sportsman.setClientWeight(input.nextDouble());

        sportsman.setClientBMI(sportsman.countBMI());

    }
}
