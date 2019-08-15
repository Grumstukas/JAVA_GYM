package Gym3;

import java.util.Scanner;

public class OldGymClient {

    private String clientID;
    private int clientActivity;
    private double clientWeight;
    // TrainingMachines; ??? List // ENUM
    private double clientHeight;
    private double clientBMI;
    private String personalFileHeaders = "ID,Data,Laikas,Kliento ugis(cm),Aktyvumo laikas,Kliento svoris,Kuno mases indeksas,Vardas";


    public OldGymClient(String clientID) {
        this.clientID = clientID;
    }

    void updateInfo() {
        System.out.print("Prasom iveskit aktyvumo laika JAVA GYM (min):\t");
        clientActivity = InputValidation.validateInt(ScannerClass.getIntInputValue());
        System.out.print("Prasom iveskit savo kuno svori (kg):\t");
        clientWeight = Double.parseDouble(InputValidation.validateDouble(ScannerClass.getStringInputValue()));

        clientHeight=Double.parseDouble(Write_Read_File.findSomethingInCommonFile("All_Clients\\All.csv",0,6,getClientID()));
        clientBMI=new BMICalc(clientWeight,clientHeight).getBMI();

        String clientPath = "All_Clients\\" + getClientID() + ".csv";
        String clientInfo = clientID + "," + CurrentDate.currentTime()[0] + "," + CurrentDate.currentTime()[1] + "," + clientHeight + "," + clientActivity + "," + clientWeight + "," + clientBMI;
        Write_Read_File.writeClientInfoToFile(personalFileHeaders,clientInfo,clientPath); // i asmenini faila nauja eilute po aktyvumo atnaujinimo.
        }


public void setClientActivity(int clientActivity){
        this.clientActivity=clientActivity;
        }

public void setClientID(String clientID){
        this.clientID=clientID;
        }

public void setClientWeight(double clientWeight){
        this.clientWeight=clientWeight;
        }

public void setClientHeight(double clientHeight){
        this.clientHeight=clientHeight;
        }

public void setClientBMI(double clientBMI){
        this.clientBMI=clientBMI;
        }

public String getClientID(){
        return clientID;
        }
        }

