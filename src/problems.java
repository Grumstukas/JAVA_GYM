import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problems {
    public static void main(String[] args) {
        readFile("All_Clients\\All.csv", "AT922");
        System.out.println( readFile("All_Clients\\All.csv", "AT922"));
    }

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