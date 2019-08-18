package Gym3.Meniu.Methods;

import Gym3.ScannerClass;
import Gym3.Write_Read_File;

import java.text.ParseException;
import java.time.LocalDate;

public class InputValidation {
    public static String validateString(String inputToValidate) {
        try {
            while (!inputToValidate.matches("[a-zA-Z]+")) {
                System.out.print("Go ask your parents how to write a word:");
                inputToValidate = ScannerClass.getStringInputValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputToValidate;
    }

    public static String validateStringLength(String inputToValidate) {
        while (inputToValidate.length() > 20) {
            System.out.print("I'll call you John, okay?");
            inputToValidate = ScannerClass.getStringInputValue();
        }
        return inputToValidate;
    }

    public static int validateInt(int inputToValidate) {
        while (inputToValidate > 200) {
            System.out.println("too much");
            inputToValidate = ScannerClass.getIntInputValue();
        }
        return inputToValidate;
    }

    public static String validateDouble(String inputToValidate) {
        try {
            while (!inputToValidate.matches("[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?")) {
                System.out.print("turi buti skaicius:");
                inputToValidate = ScannerClass.getStringInputValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputToValidate;
    }

    public static String validatePhoneNumber(String phoneNumber) {
        while (String.valueOf(phoneNumber).length() != 8 || !phoneNumber.matches("[0-9]+")) {
            System.out.print("Please enter valid phone number, must contain 8 numbers.");
            phoneNumber = ScannerClass.getStringInputValue();
        }
        return phoneNumber;
    }

    public static String isThisDateValid(String date, String ClientID) throws ParseException {
        while (!Write_Read_File.findSomethingInAllFile("All_Clients\\" + ClientID + "\\" + ClientID + ".csv",
                1, ProgressCounter.dateToString(ProgressCounter.parseToDate(date)))) {
            System.out.println("netinkama data, bandykite dar karta");
            date = ScannerClass.getStringInputValue();
        }
        return date;
    }

    public static String isThisChoiceValid(String choice, String maxChoice) throws ParseException {
        String x = maxChoice;
        while (!(choice.matches("[1-"+x+"]+"))) {
            System.out.println("tokios paslaugos neteikiame, rinkites dar karta");
            choice = ScannerClass.getStringInputValue();
        }
        return choice;
    }
}
