package Gym3;

import java.util.Scanner;

public class NewGymClient extends AbstractClient {

    private String clientID;
    private String clientName;
    private String clientSurname;
    private String phoneNumber;
    private String email;
    private double clientWeight;
    private double clientHeight;
    private double clientBMI;
    private String personalFileHeaders = "ID,Data,Laikas,Kliento ugis(cm),Aktyvumo laikas,Kliento svoris,Kuno mases indeksas,Vardas";
    private String commonFileHeaders = "ID,Vardas,Pavarde,Telefono numeris,Elektroninis pastas,Kliento svoris,Kliento ugis,Kuno mases indeksas, Rgistracijos data";

    /**
     * This method asks of all other parameters that client must have.
     */
    void takeInfo() {
        System.out.print("Kuo jus vardu?\t\t\t\t|\t");
        clientName = InputValidation.validateString(ScannerClass.getStringInputValue());

        System.out.print("Kokia Jusu pavarde?\t|\t");
        clientSurname = InputValidation.validateString(ScannerClass.getStringInputValue());

        System.out.println("Prasau pateikite informacija reikalinga registracijos ivykdymui");
        System.out.print("telefono numeris: \t\t|\t");
        InputValidation.validatePhoneNumber(phoneNumber = ScannerClass.getStringInputValue());

        System.out.print("elektroninis pastas: \t|\t");
        email = ScannerClass.getStringInputValue();
//        email = InputValidation.validateString(ScannerClass.getStringInputValue());

        System.out.print("kuno mase (kg): \t\t\t|\t");
        clientWeight = Double.parseDouble(InputValidation.validateDouble(ScannerClass.getStringInputValue()));

        System.out.print("kuno ugis(cm): \t\t\t|\t");
        clientHeight = Double.parseDouble(InputValidation.validateDouble(ScannerClass.getStringInputValue()));

        if (!Write_Read_File.findSomethingInAllFile("All_Clients\\All.csv", 4, email)) { // 8 vieta eiluteje, kur yra emailas, kuri tikrina ar nesikartoja
            setClientID(new ID_Generator(getClientName(), getClientSurname()).getId());
            setClientBMI(new BMICalc(getClientWeight(), getClientHeight()).getBMI()); // FALSE, tesia registracija, skaiciuoja BMI

            String clientPath = "All_Clients\\" + clientID + ".csv"; // sukuria asmenini faila
            String newClientInfo = clientID + "," + clientName + "," + clientSurname + ",+370" + phoneNumber + "," + email + "," + clientWeight + "," + clientHeight + "," + clientBMI + "," + CurrentDate.currentTime()[0];
            String personalClientInfo = clientID + "," + CurrentDate.currentTime()[0] + "," + CurrentDate.currentTime()[1] + "," + clientHeight + "," + "uzregistruotas" + "," + clientWeight + "," + clientBMI + "," + clientName; // iraso duomenis i ASMENINI faila.

            Write_Read_File.writeClientInfoToFile(personalFileHeaders, personalClientInfo, clientPath); // personal
            Write_Read_File.writeClientInfoToFile(commonFileHeaders, newClientInfo, "All_Clients\\All.csv"); // i bendra faila.

            System.out.println("Jums suteiktas ID yra   " + clientID + "   " +
                    "\nPrasau issaugokite ji, jo jums prireiks norint ateityje lankyti JAVAGYM sporto kluba :)");
        } else {
            System.out.print("Tokiu pastu klientas jau yra uzregistruotas, prasome patikslinti visa registracijos informacija.");
        }

    }

    @Override
    public String getClientID() {
        return clientID;
    }

    @Override
    public String getClientName() {
        return clientName;
    }

    @Override
    public String getClientSurname() {
        return clientSurname;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public double getClientWeight() {
        return clientWeight;
    }

    @Override
    public double getClientHeight() {
        return clientHeight;
    }

    @Override
    public double getClientBMI() {
        return clientBMI;
    }


    @Override
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    @Override
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setClientWeight(double clientWeight) {
        this.clientWeight = clientWeight;
    }

    @Override
    public void setClientHeight(double clientHeight) {
        this.clientHeight = clientHeight;
    }

    @Override
    public void setClientBMI(double clientBMI) {
        this.clientBMI = clientBMI;
    }

}