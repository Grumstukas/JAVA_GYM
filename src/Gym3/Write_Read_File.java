package Gym3;

import java.io.*;
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
    public static void writeClientInfoToFile(String headers, String clientInfo, String clientPath) {
        File clientFile = null; // praso iniciavimo, tik del to NULL.

        try (FileOutputStream fos = new FileOutputStream(clientPath, true);
             PrintWriter registration = new PrintWriter(fos)) {
            clientFile = new File(clientPath); // sukuria objekta, kuris moka skaityti asmenini faila (clientPath)
            clientFile.createNewFile(); // default metodas sukurti faila, jeigu tokio nera

            if (readFile(clientPath, clientInfo) == 0) { //jeigu failas - tuscias
                registration.println(headers); //irsaso header eilute
                registration.println(clientInfo); //irsaso kliento informacijos eilute
                registration.flush(); // nuleido
            }
            if (readFile(clientPath, clientInfo) == 1) { //jeigu failas - sukurtas ir netuscias
                registration.println(clientInfo);//irsaso kliento informacijos eilute
                registration.flush(); // nuleido
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads given file line by line, pushes all lines to list, and then searches in that list of uneque line
     *
     * @param pathToRead
     * @param clientInfo
     * @return
     */
    public static int readFile(String pathToRead, String clientInfo) {
        int newLineInClientBook = 0; // praso iniciavimo, tik del to FALSE.
        List<String> allThisFileLines = readAllGivenFileLinesAndReturnListOfAllLines(pathToRead);

        for (int i = 0; i < allThisFileLines.size(); i++) { // iteruojasi per visas eilutes (viena eilute - vienas elementas)
            if (allThisFileLines.size() == 0) {
                newLineInClientBook = 0; // jeigu esi tuscias, tai ok as irasysiu papildoma eilute.
            } else if (!allThisFileLines.contains(clientInfo)) { // jeigu ne tuscias "!", klausiu ar neturi jau tokio pacio "contains".
                newLineInClientBook = 1; // jeigu turi(contains), tai neirasau.
            } else {
                newLineInClientBook = 2;
            }
        }
        return newLineInClientBook;
    }

    /**
     * metodas skaito tik iš pirmos eilutes
     *
     * @param pathToRead skaitomo failo adresas
     * @param index      ieskomo dalyko eiles numeris (toje pirmoje eileje)
     * @return stringo tipo ieskomo parametro vertę.
     */
    public static String findSomething(String pathToRead, int index) {
        List<String> allThisFileLines = readAllGivenFileLinesAndReturnListOfAllLines(pathToRead);
        String firstLine = allThisFileLines.get(1); // pirmas elementas - pirma eilute.
        String firstLineElements[] = firstLine.split(","); // pirmos eilutes elementu sarasas.
        return firstLineElements[index];
    }
    public static String findSomethingInLastLine(String pathToRead, int index) {
        List<String> allThisFileLines = readAllGivenFileLinesAndReturnListOfAllLines(pathToRead);
        String firstLine = allThisFileLines.get(allThisFileLines.size()-1); // pirmas elementas - pirma eilute.
        String firstLineElements[] = firstLine.split(","); // pirmos eilutes elementu sarasas.
        return firstLineElements[index];
    }

    /**
     * Metodas skaito visa faila po eilute
     *
     * @param pathToRead    skaitomo failo adresas
     * @param index         ieskomo dalyko eiles numeris
     * @param thatSomething stringo tipo ieskomas dalykas
     * @return boolean True- jeigu rado, false- jei nerado.
     */
    public static boolean findSomethingInAllFile(String pathToRead, int index, String thatSomething) {
        boolean found = false; // inicializacija
        List<String> allThisFileLines = readAllGivenFileLinesAndReturnListOfAllLines(pathToRead);
        List<String> ListOfThingtsThatYouAreLookingFor = new ArrayList<>(); // busimas ieskomu elementu sarasas.

        for (int i = 0; i < allThisFileLines.size(); i++) { // iteruoja per visa sudarytu eiluciu sarasa.
            String line[] = allThisFileLines.get(i).split(","); // sukuria po nauja masyva kikevienai eilutei.
            ListOfThingtsThatYouAreLookingFor.add(line[index]); // is kiekvienos eilutes masyvo ima konkrecia reiksme "index" ir talpina i nauja ieskomu elementu sarasa.
        }
        if (ListOfThingtsThatYouAreLookingFor.size() > 0 & ListOfThingtsThatYouAreLookingFor.contains(thatSomething)) { // tikrina ar ne tusias '&' iesko ar jau yra ieskomas elementas.
            found = true;
        } else {
            found = false;
        }
        return found;
    }

    public static List<String> readAllGivenFileLinesAndReturnListOfAllLines(String pathToRead) {
        List<String> allThisFileLines = new ArrayList<String>(); // sukuria failo eiluciu sarasa.
        try (Scanner scanner = new Scanner(new File(pathToRead))) { //skaito nurodyta faila
            while (scanner.hasNextLine()) { // kol randa ka skaityti tol irasineja failo eilutes i sarasa.
                allThisFileLines.add(scanner.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return allThisFileLines; //grazina perskaitytu eiluciu sarasa
    }

    /**
     *
     * @param pathToRead - adresas
     * @param keyColumnIndex - pagal koki paramera (arba stulpeli) filtruoti, kad issirinkti tinkama eilute is viso failo (pagal ID, kuris dazniausiai bus nulintam stulpelyje)
     * @param indexOfRequiredColumn - kuriame stulpelyje guli reikalinga reiksme?
     * @param keyForSpecialLine - pvz kliento ID, kuris bus unikalus ir pagal ji bus galima issirinkti tinkama eilute
     * @return String reiksme stulpelio ir eilutes susikirtimo reiksme
     */
    public static String findSomethingInCommonFile(String pathToRead,int keyColumnIndex, int indexOfRequiredColumn, String keyForSpecialLine) {
        List<String> allThisFileLines = readAllGivenFileLinesAndReturnListOfAllLines(pathToRead);
        List<String> ListOfThingtsThatYouAreLookingFor = new ArrayList<>();

        for (int i = 0; i < allThisFileLines.size(); i++) {
            String line[] = allThisFileLines.get(i).split(",");
            ListOfThingtsThatYouAreLookingFor.add(line[keyColumnIndex]);
        }
        int lineNumber =  ListOfThingtsThatYouAreLookingFor.indexOf(keyForSpecialLine);
        String[] splitedLine = allThisFileLines.get(lineNumber).split(",");
        String answer = splitedLine[indexOfRequiredColumn];
        return answer;
    }

    public static void createDirectory(String pathname){
        File newDirectory = new File(pathname); // kuria FOLDERY.
        boolean check = newDirectory.mkdir(); // PATS pirmas kartas gauna FALSE, sekanti karta gauna TRUE.
    }

    public static void writeHTMLFile(String headers, String clientInfo, String clientPath) {
        File clientFile = null; // praso iniciavimo, tik del to NULL.

        try (FileOutputStream fos = new FileOutputStream(clientPath, true);
             PrintWriter registration = new PrintWriter(fos)) {
            clientFile = new File(clientPath); // sukuria objekta, kuris moka skaityti asmenini faila (clientPath)
            clientFile.createNewFile(); // default metodas sukurti faila, jeigu tokio nera

            if (readFile(clientPath, "<!DOCTYPE html>") == 0) { //jeigu failas - tuscias
                registration.println(headers); //irsaso header eilute
                registration.println(clientInfo); //irsaso kliento informacijos eilute
                registration.flush(); // nuleido
            }
            if (readFile(clientPath, "<!DOCTYPE html>") == 1) { //jeigu failas - sukurtas ir netuscias
                registration.println(clientInfo);//irsaso kliento informacijos eilute
                registration.flush(); // nuleido
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFile(String pathname) {
        File fileForDelete = new File(pathname);
        if (fileForDelete.exists()){
            boolean check = fileForDelete.delete();
        }
    }
}
