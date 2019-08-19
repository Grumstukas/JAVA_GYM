package Gym3;

import Gym3.Meniu.Methods.ProgressCounter;

import java.text.ParseException;
import java.util.Comparator;

public class Identification {
    public static void salutation(String userID) {
        String name = Write_Read_File.findSomething("All_Clients\\" + userID + "\\" + userID + ".csv", 7);

        StringBuilder salutation = new StringBuilder();
        if (name.charAt(name.length() - 2) == 'a' && name.charAt(name.length() - 1) == 's') { //baigiasi "as"
            for (int i = 0; i < name.length() - 1; i++) {
                salutation.append(name.charAt(i));
            }
            salutation.append("i");
        } else if ((name.charAt(name.length() - 2) == 'i' || name.charAt(name.length() - 2) == 'y') && name.charAt(name.length() - 1) == 's') { //baigiasi "is" arba "ys"
            for (int i = 0; i < name.length() - 1; i++) {
                salutation.append(name.charAt(i));
            }
        } else if (name.charAt(name.length() - 2) == 'u' && name.charAt(name.length() - 1) == 's') { //baigiasi "is"
            for (int i = 0; i < name.length() - 2; i++) {
                salutation.append(name.charAt(i));
            }
            salutation.append("a");
            salutation.append("u");
        } else if (name.charAt(name.length() - 1) == 'e') { //baigiasi "is"
            for (int i = 0; i < name.length() - 1; i++) {
                salutation.append(name.charAt(i));
            }
            salutation.append("e");
        }

        System.out.println("Labas " + salutation + "!");
    }


    public static String isThisClientIDValid(String ClientID) {
        while (!Write_Read_File.findSomethingInAllFile("All_Clients\\All.csv", 0, ClientID)) {
            System.out.println("Toks ID neegzistuoja, pabandykite is naujo, arba uzsirgistruokite");
            ClientID = ScannerClass.getStringInputValue();
        }
        return ClientID;
    }
}
