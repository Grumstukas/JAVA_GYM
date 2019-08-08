package Gym3;

import java.util.Scanner;

public class NewGymClient {

    private String clientID;
    private String clientName;
    private String clientSurname;
    private String phoneNumber;
    private String email;
    private double clientWeight;
    private double clientHeight;
    private double clientBMI;

    /**
     * This method asks of all other parameters that client must have.
     */
    void takeInfo() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Kuo jus vardu?\t\t\t\t|\t");
            clientName = input.next();
            System.out.print("Kokia Jusu pavarde?\t|\t");
            clientSurname = input.next();
            System.out.println("Prasau pateikite informacija reikalinga registracijos ivykdymui");
            System.out.print("telefono numeris: \t\t|\t");
            phoneNumber = input.next();
            System.out.print("elektroninis pastas: \t|\t");
            email =  input.next();
            System.out.print("kuno mase (kg): \t\t\t|\t");
            clientWeight = input.nextDouble();
            System.out.print("kuno ugis(cm): \t\t\t|\t");
            clientHeight = input.nextDouble();
        } catch (Exception e) {
            System.out.print("Error, time to die. Re-run the program.");
        }

        if(!Write_Read_File.findSomethingInAllFile("All_Clients\\All.csv", 8, email)){ // 8 vieta eiluteje, kur yra emailas, kuri tikrina ar nesikartoja
            setClientID(ID_Generator.newID(clientName, clientSurname));

            setClientBMI(BMICalc.calcBMI(clientWeight, clientHeight)); // FALSE, tesia registracija, skaiciuoja BMI
            String clientPath = "All_Clients\\" + getClientID() + ".csv"; // sukuria asmenini faila 
            String newClientInfo = clientID + "\t|\t" + clientName + "\t|\t" + clientSurname + // formatas kaip irasyti duomenis i BENDRA faila.
                    "\t|\t" + phoneNumber + "\t|\t" + email + "\t|\t" + clientWeight + "\t|\t" + clientHeight + "\t|\t" + clientBMI;

            String personalClientInfo = clientID +"\t|\t" + CurrentDate.currentTime() +"\t|\t" + 
            clientHeight+"\t|\t" + "dar nesportavo"+ "\t|\t" + clientWeight +"\t|\t" + clientBMI +"\t|\t" + clientName; // iraso duomenis i ASMENINI faila.


            Write_Read_File.writeClientInfoToFile(personalClientInfo, clientPath); // personal
            Write_Read_File.writeClientInfoToFile(newClientInfo, "All_Clients\\All.csv"); // i bendra faila.
            System.out.println("Jums suteiktas ID yra   " + getClientID() + "   " +
                    "\nPrasau issaugokite ji, jo jums prireiks norint ateityje lankyti JAVAGYM sporto kluba :)");
        }else {
            System.out.print("Tokiu pastu klientas jau yra uzregistruotas, prasome patikslinti visa registracijos informacija.");
        }

    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getClientName() {
        return clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientID() {
        return clientID;
    }
}