package JAVA_GYM;

import java.io.IOException;
import java.text.ParseException;

public class Identification {
    public static void salutation(String userID) {
        String name = Write_Read_File.findSomething("All_Clients\\" + userID + "\\" + userID + ".csv", 7);

        StringBuilder salutation = new StringBuilder();
        if ( name.charAt(name.length() - 2) == 'a' && name.charAt(name.length() - 1) == 's' ) { //baigiasi "as"
            for ( int i = 0; i < name.length() - 1; i++ ) {
                salutation.append(name.charAt(i));
            }
            salutation.append("i");
        } else if ( (name.charAt(name.length() - 2) == 'i' || name.charAt(name.length() - 2) == 'y') && name.charAt(name.length() - 1) == 's' ) { //baigiasi "is" arba "ys"
            for ( int i = 0; i < name.length() - 1; i++ ) {
                salutation.append(name.charAt(i));
            }
        } else if ( name.charAt(name.length() - 2) == 'u' && name.charAt(name.length() - 1) == 's' ) { //baigiasi "is"
            for ( int i = 0; i < name.length() - 2; i++ ) {
                salutation.append(name.charAt(i));
            }
            salutation.append("a");
            salutation.append("u");
        } else if ( name.charAt(name.length() - 1) == 'e' ) { //baigiasi "e"
            for ( int i = 0; i <= name.length() - 1; i++ ) {
                salutation.append(name.charAt(i));
            }
        } else if ( name.charAt(name.length() - 1) == 'a' ) { //baigiasi "a"
            for ( int i = 0; i <= name.length() - 1; i++ ) {
                salutation.append(name.charAt(i));
            }
        }

        System.out.println("Labas " + salutation + "!");
    }


    public static String isThisClientIDValid(String ClientID) throws IOException, ParseException {
        while ( (!Write_Read_File.findSomethingInAllFile("All_Clients\\All.csv", 0, ClientID)) ) {
            System.out.println("Toks ID neegzistuoja, pabandykite is naujo, arba uzsirgistruokite (2)");
            ClientID = ScannerClass.getStringInputValue();
        }
        return ClientID;
    }
}
