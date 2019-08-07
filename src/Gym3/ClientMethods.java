package Gym3;

import java.io.*;
import java.util.*;

public class ClientMethods {
    /**
     * counts client BMI
     * @param Weight
     * @param Height
     * @return - BMI + recomendations
     */
    public static double calcBMI (double Weight, double Height) {
        double BMI = Weight / (Height * Height);
        System.out.println();
        System.out.format("Your body mass index is - " + "%.2f%n", BMI);
        if ( BMI < 18.5 ) {
            System.out.println("BMI is less than normal, visiting nutritionist is highly recommended");
        }
        if ( 18.5 < BMI && BMI < 25 ) {
            System.out.println("BMI is normal, no special recommendations.");
        }
        if ( 25 <= BMI && BMI < 30 ) {
            System.out.println("BMI is a little higher than normal, visiting nutritionist is highly recommended");
        }
        if ( 30 <= BMI ) {
            System.out.println("BMI is much higher than normal, visiting nutritionist is highly recommended, weakened gym program recommended.");
        }
        return BMI;
    }

    /**
     * writes information to file
     * @param clientInfo information that needs to be written
     * @param clientPath path to file that information must be written in
     */
    public void writeClientInfoToFile(String clientInfo, String clientPath) {
        FileWriter registration = null;
        File allClients = null;
        try {
            allClients = new File(clientPath);
            if (!allClients.exists()) {
                allClients.createNewFile();
            }
            if (readFile(clientPath, clientInfo) == false) {
                registration = new FileWriter(allClients, true);
                registration.write(clientInfo);
                registration.write(System.getProperty("line.separator"));
                registration.flush();
                registration.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads given file line by line, pushes all lines to list, and then searches in that list of uneque line
     * @param pathToReed
     * @param clientInfo
     * @return
     */
    public boolean readFile(String pathToReed, String clientInfo) {
        boolean newLineInClientBook = false;
        List<String> allClients = new ArrayList<String>();
        File fileForRead = new File(pathToReed);
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
            else if (!allClients.contains(clientInfo)){
                newLineInClientBook = false;
            }else {
                newLineInClientBook = true;
            }
        }
        return newLineInClientBook;
    }
}
