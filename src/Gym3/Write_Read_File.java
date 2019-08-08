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
        FileWriter registration = null; // praso iniciavimo, tik del to NULL.
        File allThisFileLines = null; // praso iniciavimo, tik del to NULL.

        File newDirectory = new File("All_Clients"); // kuria FOLDERY.
        boolean check = newDirectory.mkdir(); // PATS pirmas kartas gauna FALSE, sekanti karta gauna TRUE.
        try {
            allThisFileLines = new File(clientPath); // sukuria objekta, kuris moka skaityti asmenini faila (clientPath)
            if (!allThisFileLines.exists()) { // AR egzistuoja '!'

                allThisFileLines.createNewFile(); // default metodas sukurti faila.
            }
            if (readFile(clientPath, clientInfo) == false) { // Pereina i sekanti metoda.
                registration = new FileWriter(allThisFileLines, true); // yra turinys?? iraso nauja sekancia eilute.
                registration.write(clientInfo); // ka irasyti.
                registration.write(System.getProperty("line.separator")); // zino, kad turi nauja elementa "eilute" irasyti i nauja eilute.
                registration.flush(); // nuleido
                registration.close(); // uzdare dangti.
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
    public static boolean readFile(String pathToRead, String clientInfo) {
        boolean newLineInClientBook = false; // praso iniciavimo, tik del to FALSE.
        List<String> allThisFileLines = new ArrayList<String>(); // sukuria failo eiluciu sarasa.  
        File fileForRead = new File(pathToRead); 
        try (Scanner scanner = new Scanner(fileForRead)) {
            while (scanner.hasNextLine()) { // kol randa ka skaityti tol irasineja tas eilutes i sarasa.
                allThisFileLines.add(scanner.next());
                scanner.nextLine();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        for (int i = 0; i < allThisFileLines.size(); i++) { // iteruojasi per visas eilutes (viena eilute - vienas elementas)
            if (allThisFileLines.size() == 0) {
                newLineInClientBook = true; // jeigu esi tuscias, tai ok as irasysiu papildoma eilute.
            } else if (!allThisFileLines.contains(clientInfo)) { // jeigu ne tuscias "!", klausiu ar neturi jau tokio pacio "contains".
                newLineInClientBook = false; // jeigu turi(contains), tai neirasau.
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
    public static String findSomething (String pathToRead, int index) {
        List<String> allThisFileLines = new ArrayList<String>(); // atskira dezute viska ka perskaito po eilute sudeda i nauja sarasa.
        File fileForRead = new File(pathToRead); // 
        try (Scanner scanner = new Scanner(fileForRead)) { // 
            while (scanner.hasNextLine()) {
                allThisFileLines.add(scanner.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        String firstLine =  allThisFileLines.get(0); // pirmas elementas - pirma eilute.
        String firstLineElements [] = firstLine.split("\t|\t"); // pirmos eilutes elementu sarasas.
        return firstLineElements [index]; 
    }

    /**
     * Metodas skaito visa faila po eilute
     * @param pathToReed skaitomo failo adresas
     * @param index ieskomo dalyko eiles numeris
     * @param thatSomething stringo tipo ieskomas dalykas
     * @return boolean True- jeigu rado, false- jei nerado.
     */
    public static boolean findSomethingInAllFile (String pathToRead, int index, String thatSomething) {
        boolean found = false; // inicializacija
        List<String> allThisFileLines = new ArrayList<>(); // atskira dezute viska ka perskaito po eilute sudeda i nauja sarasa.
        List<String> ListOfThingtsThatYouAreLookingFor = new ArrayList<>(); // busimas ieskomu elementu sarasas.
        File fileForRead = new File(pathToRead); // skaitau ir surasau i nauja sarasa. 
        try (Scanner scanner = new Scanner(fileForRead)) {
            while (scanner.hasNextLine()) {
                allThisFileLines.add(scanner.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        for (int i = 0; i<allThisFileLines.size(); i++){ // iteruoja per visa sudarytu eiluciu sarasa.
            String line[] = allThisFileLines.get(i).split("\t|\t"); // sukuria po nauja masyva kikevienai eilutei.
            ListOfThingtsThatYouAreLookingFor.add(line[index]); // is kiekvienos eilutes masyvo ima konkrecia reiksme "index" ir talpina i nauja ieskomu elementu sarasa.
        }
        if (ListOfThingtsThatYouAreLookingFor.size()>0 & ListOfThingtsThatYouAreLookingFor.contains(thatSomething)){ // tikrina ar ne tusias '&' iesko ar jau yra ieskomas elementas.
            found = true;
        }else {
            found = false;
        }
        return found;
    }
}
