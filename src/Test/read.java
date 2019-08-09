package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class read {
    public static void main(String[] args) throws FileNotFoundException {
        String found="";
        List<String> allThisFileLines = readAllGivenFileLinesAndReturnListOfAllLines("All_Clients\\All.csv");
        List<String> ListOfThingtsThatYouAreLookingFor = new ArrayList<>(); // busimas ieskomu elementu sarasas.
//        System.out.println(readAllGivenFileLinesAndReturnListOfAllLines("All_Clients\\All.csv").get(0));
        for (int i = 0; i<allThisFileLines.size(); i++){
            String line[] = allThisFileLines.get(i).split(",");
            ListOfThingtsThatYouAreLookingFor.add(line[0]);
        }
        if (ListOfThingtsThatYouAreLookingFor.size()>0 & ListOfThingtsThatYouAreLookingFor.contains("TT454")){ // tikrina ar ne tusias '&' iesko ar jau yra ieskomas elementas.
            found = "radau";
        }else {
            found = "neradau";
        }
        System.out.println(found);
//        writeClientInfoToFile("ID,Name,Surname,phone,email,weight,height,BMI"
//                ,"PL101,Lina,Zemaityte,860804121,tasgdsdnaite@gmail.com,71.0,183.0,24.66","All_Clients\\PL101.csv");
    }


//    public static void writeClientInfoToFile(String headers, String clientInfo, String clientPath) throws FileNotFoundException {
//        File allThisFileLines = null; // praso iniciavimo, tik del to NULL.
//        File newDirectory = new File("All_Clients"); // kuria FOLDERY.
//        boolean check = newDirectory.mkdir(); // PATS pirmas kartas gauna FALSE, sekanti karta gauna TRUE.
//        try (FileOutputStream fos = new FileOutputStream(clientPath, true)){
//            PrintWriter registration = new PrintWriter(fos); // praso iniciavimo, tik del to NULL.
//            allThisFileLines = new File(clientPath); // sukuria objekta, kuris moka skaityti asmenini faila (clientPath)
//            if (!allThisFileLines.exists()) { // AR egzistuoja '!'
//
//                allThisFileLines.createNewFile(); // default metodas sukurti faila.
//            }
//            if (readFile(clientPath, clientInfo) == 0){
//                registration.println(headers);
//                registration.println(clientInfo);
//                registration.flush(); // nuleido
//                registration.close(); // uzdare dangti.
//            }
//            if (readFile(clientPath, clientInfo) == 1) { // Pereina i sekanti metoda.
//                registration.println(clientInfo);
//                registration.flush(); // nuleido
//                registration.close(); // uzdare dangti.
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static int readFile(String pathToRead, String clientInfo) {
//        int newLineInClientBook = 0; // praso iniciavimo, tik del to FALSE.
//        List<String> allThisFileLines = readAllGivenFileLinesAndReturnListOfAllLines(pathToRead);
//
//        for (int i = 0; i < allThisFileLines.size(); i++) { // iteruojasi per visas eilutes (viena eilute - vienas elementas)
//            if (allThisFileLines.size() == 0) {
//                newLineInClientBook = 0; // jeigu esi tuscias, tai ok as irasysiu papildoma eilute.
//            } else if (!allThisFileLines.contains(clientInfo)) { // jeigu ne tuscias "!", klausiu ar neturi jau tokio pacio "contains".
//                newLineInClientBook = 1; // jeigu turi(contains), tai neirasau.
//            } else {
//                newLineInClientBook = 2;
//            }
//        }
//        return newLineInClientBook;
//    }


    private static List<String> readAllGivenFileLinesAndReturnListOfAllLines(String pathToRead) {
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
}
