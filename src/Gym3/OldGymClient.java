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
        Scanner input = new Scanner(System.in);
        System.out.print("Prasom iveskit aktyvumo laika JAVA GYM (min):\t");
        clientActivity = input.nextInt();
        System.out.print("Prasom iveskit savo kuno svori (kg):\t");
        clientWeight = input.nextDouble();

        String clientPath = "All_Clients\\" + getClientID() + ".csv";
        clientHeight = Double.parseDouble(Write_Read_File.findSomething (clientPath, 4)); // 4 vietoje sedi ugis.
        clientBMI = BMICalc.calcBMI(clientWeight, clientHeight); 

        String clientInfo = clientID +"\t|\t" + CurrentDate.currentTime() +"\t|\t" + clientHeight + "\t|\t" + clientActivity + "\t|\t" + clientWeight + "\t|\t" + clientBMI;
        Write_Read_File.writeClientInfoToFile(clientInfo, clientPath); // i asmenini faila nauja eilute po aktyvumo atnaujinimo.
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

