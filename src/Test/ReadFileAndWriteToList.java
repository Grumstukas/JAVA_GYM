package Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFileAndWriteToList {
    public static void main(String[] args) {
        List<String> allThisFileLines = readAllGivenFileLinesAndReturnListOfAllLines("All_Clients\\All.csv");
        System.out.println(readAllGivenFileLinesAndReturnListOfAllLines("All_Clients\\All.csv"));
        System.out.println(allThisFileLines);
        System.out.println(allThisFileLines.size());
        System.out.println(allThisFileLines.get(0));
        String line[] = allThisFileLines.get(0).split("\t|\t");
        System.out.println(Arrays.toString(line));
    }
        private static List<String> readAllGivenFileLinesAndReturnListOfAllLines(String pathToRead) {
        List<String> allThisFileLines = new ArrayList<String>(); // sukuria failo eiluciu sarasa.
        File fileForRead = new File(pathToRead);
        try (Scanner scanner = new Scanner(fileForRead)) {
            while (scanner.hasNextLine()) { // kol randa ka skaityti tol irasineja tas eilutes i sarasa.
                allThisFileLines.add(scanner.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return allThisFileLines;
    }
}
