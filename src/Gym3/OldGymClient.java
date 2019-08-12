package Gym3;

import java.util.Scanner;

public class OldGymClient{
	
    private String clientID;
    private int clientActivity;
    private double clientWeight;
    // TrainingMachines; ??? List // ENUM
    private double clientHeight;
    private double clientBMI;

    public OldGymClient(String clientID) {
        this.clientID = clientID;
    }

    void updateInfo() {
        boolean isInt;
        boolean isDouble;
        try (Scanner input = new Scanner(System.in)) {
            do {
                System.out.print("Prasom iveskit aktyvumo laika JAVA GYM (min):\t");
                if (input.hasNextInt()) {
                    clientActivity = input.nextInt();
                    isInt = true;
                } else {
                    System.out.println("Now go back, read question again, and enter what we need or burn in hell. \t\t\t|\t");
                    isInt = false;
                    input.next();
                }
            } while (!isInt);
            do {
                System.out.print("Prasom iveskit savo kuno svori (kg):\t");
                if (input.hasNextDouble()) {
                    clientWeight = input.nextDouble();
                    isDouble = true;
                } else {
                    System.out.println("Now go back, read question again, and enter what we need or burn in hell. \t\t\t|\t");
                    isDouble = false;
                    input.next();
                }
            } while (!isDouble);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Scanner input = new Scanner(System.in);
//        System.out.print("Prasom iveskit aktyvumo laika JAVA GYM (min):\t");
//        clientActivity = input.nextInt();
//        System.out.print("Prasom iveskit savo kuno svori (kg):\t");
//        clientWeight = input.nextDouble();

        String clientPath = "All_Clients\\" + getClientID() + ".csv";
        clientHeight = Double.parseDouble(Write_Read_File.findSomething (clientPath, 2));
        clientBMI = BMICalc.calcBMI(clientWeight, clientHeight);

        String personalFileHeaders = "ID,Data,Kliento ugis(cm),Aktyvumo laikas,Kliento svoris,Kuno mases indeksas,Vardas";
        String clientInfo = clientID +"," + CurrentDate.currentTime() +"," + clientHeight + "," + clientActivity + "," + clientWeight + "," + clientBMI;
        Write_Read_File.writeClientInfoToFile(personalFileHeaders,clientInfo, clientPath); // i asmenini faila nauja eilute po aktyvumo atnaujinimo.
    }



    public void setClientActivity(int clientActivity) {
        this.clientActivity = clientActivity;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setClientWeight(double clientWeight) {
        this.clientWeight = clientWeight;
    }

    public void setClientHeight(double clientHeight) {
        this.clientHeight = clientHeight;
    }

    public void setClientBMI(double clientBMI) {
        this.clientBMI = clientBMI;
    }

    public String getClientID() {
        return clientID;
    }
}

