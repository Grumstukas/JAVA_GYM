package Gym3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Write_Read_File {
    /**
     * writes information to file
     *
     * @param clientInfo information that needs to be written
     * @param clientPath path to file that information must be written in
     */
    public static void writeClientInfoToFile(String clientInfo, String clientPath) {
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
     *
     * @param pathToReed
     * @param clientInfo
     * @return
     */
    public static boolean readFile(String pathToReed, String clientInfo) {
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
        for (int i = 0; i < allClients.size(); i++) {
            if (allClients.size() == 0) {
                newLineInClientBook = true;
            } else if (!allClients.contains(clientInfo)) {
                newLineInClientBook = false;
            } else {
                newLineInClientBook = true;
            }
        }
        return newLineInClientBook;
    }
}
