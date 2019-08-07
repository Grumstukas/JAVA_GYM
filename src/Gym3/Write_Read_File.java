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
        File allThisFileLines = null;

        File newDirectory = new File("All_Clients");
        boolean check = newDirectory.mkdir();
        try {
            allThisFileLines = new File(clientPath);
            if (!allThisFileLines.exists()) {

                allThisFileLines.createNewFile();
            }
            if (readFile(clientPath, clientInfo) == false) {
                registration = new FileWriter(allThisFileLines, true);
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
        List<String> allThisFileLines = new ArrayList<String>();
        File fileForRead = new File(pathToReed);
        try (Scanner scanner = new Scanner(fileForRead)) {
            while (scanner.hasNextLine()) {
                allThisFileLines.add(scanner.next());
                scanner.nextLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        for (int i = 0; i < allThisFileLines.size(); i++) {
            if (allThisFileLines.size() == 0) {
                newLineInClientBook = true;
            } else if (!allThisFileLines.contains(clientInfo)) {
                newLineInClientBook = false;
            } else {
                newLineInClientBook = true;
            }
        }
        return newLineInClientBook;
    }

    /**
     * metodas skaito tik iš pirmos eilutes
     * @param pathToReed skaitomo failo adresas
     * @param index ieskomo dalyko eiles numeris (toje pirmoje eileje)
     * @return stringo tipo ieskomo parametro vertę.
     */
    public static String findSomething (String pathToReed, int index) {
        List<String> allThisFileLines = new ArrayList<String>();
        File fileForRead = new File(pathToReed);
        try (Scanner scanner = new Scanner(fileForRead)) {
            while (scanner.hasNextLine()) {
                allThisFileLines.add(scanner.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        String firstLine =  allThisFileLines.get(0);
        String existingClientHeights [] = firstLine.split("\t|\t");
        return existingClientHeights [index];
    }

    /**
     * Metodas skaito visa faila po eilute
     * @param pathToReed skaitomo failo adresas
     * @param index ieskomo dalyko eiles numeris
     * @param thatSomething stringo tipo ieskomas dalykas
     * @return boolean True- jeigu rado, false- jei nerado.
     */
    public static boolean findSomethingInAllFile (String pathToReed, int index, String thatSomething) {
        boolean found = false;
        List<String> allThisFileLines = new ArrayList<>();
        List<String> ListOfThingtsThatYouAreLookingFor = new ArrayList<>();
        File fileForRead = new File(pathToReed);
        try (Scanner scanner = new Scanner(fileForRead)) {
            while (scanner.hasNextLine()) {
                allThisFileLines.add(scanner.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        for (int i = 0; i<allThisFileLines.size(); i++){
            String line[] = allThisFileLines.get(i).split("\t|\t");
            ListOfThingtsThatYouAreLookingFor.add(line[index]);
        }
        if (ListOfThingtsThatYouAreLookingFor.size()>0 & ListOfThingtsThatYouAreLookingFor.contains(thatSomething)){
            found = true;
        }else {
            found = false;
        }
        return found;
    }
}
