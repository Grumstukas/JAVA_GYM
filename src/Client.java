import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    private String name;
    private double height;
    private double mass;
    private String clientID;

    public Client(String name, double height, double mass) {
        this.name = name;
        this.height = height;
        this.mass = mass;
    }

    public void sport() {
        this.mass -= 0.01;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", clientID='" + clientID + '\'' +
                '}';
    }

    public static String currentTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    private static double kmi(double mass, double height) {
        double kmi = Math.round((mass / Math.pow(height / 100, 2)) * 100) / 100D;
        return kmi;
    }

    /**
     * fills  uniqe client files, and all clients files
     */
    public static void RegisterClientToFile(String name, double height, double mass) {
        FileWriter fw = null;
        File file = null;
        FileWriter registration = null;
        File allClients = null;
        String individualInput = "" + currentTime() + "\t|\t" + name + "\t|\t" + height + "cm\t|\t" + mass + "kg\t|\tBMI = " + kmi(mass, height);
        String registrationInput = name;

        String pathNameOneClient = "clients\\" + name.toLowerCase() + ".txt";
        String pathNameAllClient = "clients\\all_clients.txt";
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
        try {
            allClients = new File(pathNameAllClient);
            if (!allClients.exists()) {
                allClients.createNewFile();
            }
            registration = new FileWriter(allClients, true);
            registration.write(registrationInput);
            registration.write(System.getProperty("line.separator"));
            registration.flush();
            registration.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        File fileForRead = new File("clients\\jonas.txt");
        try (Scanner scanner = new Scanner(fileForRead)) {
            String line = scanner.nextLine();
            String[] elements = line.split("line.separator");
            System.out.println(Arrays.toString(elements));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }









    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMass() {
        return mass;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public String getClientID() {
        return clientID;
    }
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
