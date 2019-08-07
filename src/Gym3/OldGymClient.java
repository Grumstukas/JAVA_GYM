package Gym3;

import java.util.Scanner;

public class OldGymClient{
    protected String clientID;
    protected int clientActivity;
    protected double clientWeight;
    // TrainingMachines; ??? List
    protected double clientHeight;
    protected double clientBMI;

    public OldGymClient(String clientID) {
        this.clientID = clientID;
    }

    void updateInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Prasom iveskit aktyvumo laika JAVA GYM (min):\t");
        setClientActivity(input.nextInt());
        System.out.print("Prasom iveskit savo kuno svori (kg):\t");
        setClientWeight(input.nextDouble());

        String clientPath = "All_Clients\\" + getClientID() + ".csv";
        setClientHeight(Double.parseDouble(Write_Read_File.findSomething (clientPath,4)));
        setClientBMI(BMICalc.calcBMI(clientWeight, clientHeight));

        String clientInfo = clientID +"\t|\t" +CurrentDate.currentTime() +"\t|\t" + clientHeight+"\t|\t" + clientActivity+ "\t|\t" + clientWeight +"\t|\t" + clientBMI;
        Write_Read_File.writeClientInfoToFile(clientInfo, clientPath); // personal
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

