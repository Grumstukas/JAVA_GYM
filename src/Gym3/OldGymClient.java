package Gym3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        // ID = Name Surname "labas Vardas Pavarde"
        System.out.print("Prasom iveskit aktyvumo laika JAVA GYM (min):\t");
        setClientActivity(input.nextInt());
        System.out.print("Prašom iveskit savo kuno svori (kg):\t");
        setClientWeight(input.nextDouble());
        System.out.print("Prašom iveskit savo ugi (m):\t"); //imti is registacijos
        setClientHeight(input.nextDouble());
        setClientBMI(BMICalc.calcBMI(clientWeight, clientHeight));
        String clientPath = "All_Clients\\" + getClientID() + ".csv";
        String clientInfo = clientID +"\t|\t" +currentTime()+"\t|\t" + clientActivity+ "\t|\t" + clientWeight +"\t|\t" + clientHeight +"\t|\t" + (clientBMI / 100) * 100D;


        Write_Read_File.writeClientInfoToFile(clientInfo, clientPath); // personal
    }
    public String currentTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
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

