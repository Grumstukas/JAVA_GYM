package Gym3;

import java.util.Scanner;

public class NewGymClient {

    private String clientID;
    private String clientName;
    private String clientSurname;
    private Long phoneNumber;
    private String email;
    private double clientWeight;
    private double clientHeight;
    private double clientBMI;

    /**
     * This method asks of all other parameters that client must have.
     */
    void takeInfo() {
        boolean isDouble;
        boolean isLong;
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Kuo jus vardu?\t\t\t\t|\t");
            clientName = input.nextLine();
            while (!clientName.matches("[a-zA-Z]+")) {
                System.out.print("Go ask your parents how to write a word:");
                clientName = input.nextLine();
            }
            System.out.print("Kokia Jusu pavarde?\t|\t");
            clientSurname =  input.nextLine();
            while (!clientSurname.matches("[a-zA-Z]+")) { // this loop throws same printout twice, why?..
                System.out.print("Go ask your parents how to write a word:");
                clientSurname = input.nextLine();
            }
            System.out.println("Prasau pateikite informacija reikalinga registracijos ivykdymui");
            do {
                System.out.print("telefono numeris: \t\t|\t");
                System.out.print("Formatas: +370->");
                if (input.hasNextLong()) {
                    phoneNumber = input.nextLong();
                    isLong = true;
                } else {
                    System.out.println("Now go back, read question again, and enter what we need or burn in hell. \t\t\t|\t");
                    isLong = false;
                    input.next();
                }
            } while (!isLong);
            while (String.valueOf(phoneNumber).length() !=8) {  // need to set max input digits = 8, because user can jump out of INT range.
                System.out.print("Please enter valid phone number, must contain 8 numbers."); // if after number length checking user enters letters program crash.
                phoneNumber = input.nextLong();
            }
            System.out.print("elektroninis pastas: \t|\t");
            email =  input.next();
            do {
                System.out.print("kuno mase (kg): \t\t\t|\t");
                if (input.hasNextDouble()) {
                    clientWeight = input.nextDouble();
                    isDouble = true;
                } else {
                    System.out.println("Now go back, read question again, and enter what we need or burn in hell. \t\t\t|\t");
                    isDouble = false;
                    input.next();
                }
            } while (!isDouble);
            do {
                System.out.print("kuno ugis(cm): \t\t\t|\t");
                if (input.hasNextDouble()) {
                    clientHeight = input.nextDouble();
                    isDouble = true;
                } else {
                    System.out.print("Now go back, read question again, and enter what we need or burn in hell. \t\t\t|\t");
                    isDouble = false;
                    input.next();
                }
            } while (!isDouble);
        } catch (Exception e) {
            System.out.print("Error, time to die. Re-run the program.");
        }


//        try (Scanner input = new Scanner(System.in)) {
//            System.out.print("Kuo jus vardu?\t\t\t\t|\t");
//            clientName = input.next();
//            System.out.print("Kokia Jusu pavarde?\t|\t");
//            clientSurname = input.next();
//            System.out.println("Prasau pateikite informacija reikalinga registracijos ivykdymui");
//            System.out.print("telefono numeris: \t\t|\t");
//            phoneNumber = input.next();
//            System.out.print("elektroninis pastas: \t|\t");
//            email =  input.next();
//            System.out.print("kuno mase (kg): \t\t\t|\t");
//            clientWeight = input.nextDouble();
//            System.out.print("kuno ugis(cm): \t\t\t|\t");
//            clientHeight = input.nextDouble();
//        } catch (Exception e) {
//            System.out.print("Error, time to die. Re-run the program.");
//        }

        if(!Write_Read_File.findSomethingInAllFile("All_Clients\\All.csv", 4, email)){ // 8 vieta eiluteje, kur yra emailas, kuri tikrina ar nesikartoja
            setClientID(ID_Generator.newID(clientName, clientSurname));

            setClientBMI(BMICalc.calcBMI(clientWeight, clientHeight)); // FALSE, tesia registracija, skaiciuoja BMI
            String clientPath = "All_Clients\\" + getClientID() + ".csv"; // sukuria asmenini faila 
            String newClientInfo = clientID + "," + clientName + "," + clientSurname + // formatas kaip irasyti duomenis i BENDRA faila.
                    ",+370" + phoneNumber + "," + email + "," + clientWeight + "," + clientHeight + "," + clientBMI;
            String commonFileHeaders = "ID,Vardas,Pavarde,Telefono numeris,Elektroninis pastas,Kliento svoris,Kliento ugis,Kuno mases indeksas";
            String personalClientInfo = clientID +"," + CurrentDate.currentTime() +"," +
            clientHeight+"," + "dar nesportavo"+ "," + clientWeight +"," + clientBMI +"," + clientName; // iraso duomenis i ASMENINI faila.
            String personalFileHeaders = "ID,Data,Kliento ugis(cm),Aktyvumo laikas,Kliento svoris,Kuno mases indeksas,Vardas";

            Write_Read_File.writeClientInfoToFile(personalFileHeaders,personalClientInfo, clientPath); // personal
            Write_Read_File.writeClientInfoToFile(commonFileHeaders,newClientInfo, "All_Clients\\All.csv"); // i bendra faila.
            System.out.println("Jums suteiktas ID yra   " + getClientID() + "   " +
                    "\nPrasau issaugokite ji, jo jums prireiks norint ateityje lankyti JAVAGYM sporto kluba :)");
        }else {
            System.out.print("Tokiu pastu klientas jau yra uzregistruotas, prasome patikslinti visa registracijos informacija.");
        }

    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public void setPhoneNumber(Long phoneNumber) {
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