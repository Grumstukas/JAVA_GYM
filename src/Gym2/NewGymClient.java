package Gym2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewGymClient {
    private String clientName;
    private String phoneNumber;
    private String email;
    private double clientWeight;
    private double clientHeight;
    private double clientBMI;

    public NewGymClient(String clientName) {
        this.clientName = clientName;
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
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientName() {
        return clientName;
    }

    public double countBMI() {
        clientBMI = Math.round((clientWeight / Math.pow(clientHeight, 2)) * 100) / 100D;
        return clientBMI;
    }

    public void writeToFile() {
        FileWriter fw = null;
        File file = null;
        String individualInput = "" + currentTime() + "\t|\t" + clientName + "\t|\t"
                + clientHeight + "m\t|\t" + clientWeight + "kg\t|\tBMI = " + countBMI();
        String pathNameOneClient = "clients\\" + clientName.toLowerCase() + ".txt";
        try {
            file = new File(pathNameOneClient);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            fw.write(individualInput);
            fw.write(System.getProperty("line.separator"));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToClientBook() {
        FileWriter registration = null;
        File allClients = null;
        String registrationInput = clientName;
        String pathNameAllClient = "clients\\all_clients.txt";
        try {
            allClients = new File(pathNameAllClient);
            if (!allClients.exists()) {
                allClients.createNewFile();
            }
            if (readClientBook(clientName) == false){
                registration = new FileWriter(allClients, true);
                registration.write(registrationInput);
                registration.write(System.getProperty("line.separator"));
                registration.flush();
                registration.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean readClientBook(String clientName) {
        boolean newLineInClientBook = false;
        List<String> allClients = new ArrayList<String>();
        File fileForRead = new File("clients\\all_clients.txt");
        try (Scanner scanner = new Scanner(fileForRead)) {
            while (scanner.hasNextLine()) {
                allClients.add(scanner.next());
                scanner.nextLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        for (int i = 0; i<allClients.size(); i++){
            if (allClients.size()==0){
                newLineInClientBook = true;
            }
            else if (!allClients.contains(clientName)){
                newLineInClientBook = false;
            }else {
                newLineInClientBook = true;
            }
        }
        return newLineInClientBook;
    }


    private String currentTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }


    public void getProgressInfo(String clientName) {
        List<String> clientProgress = new ArrayList<String>();
        File fileForRead = new File("clients\\"+clientName.toLowerCase()+".txt");
        try (Scanner scanner = new Scanner(fileForRead)) {
            while (scanner.hasNextLine()) {
                clientProgress.add(scanner.next());
                scanner.nextLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        System.out.println("Training started at: "+clientProgress.get(0));
        System.out.println("Gym was visited "+clientProgress.size()+" times");
    }

    public void setClientName(String next) {
    }
}
