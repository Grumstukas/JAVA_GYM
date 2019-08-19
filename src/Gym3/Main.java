package Gym3;

import Gym3.Meniu.Methods.InputValidation;
import Gym3.Meniu.Methods.ProgressCounter;
import Gym3.Meniu.Methods.Payment;
import Gym3.Meniu.NewGymClient;
import Gym3.Meniu.OldGymClient;

import java.text.ParseException;

public class Main {

    /**
     * First JavaGym registration pop-up, demands to choose an option.
     * Depending on chosen option this method call second further "registration" or "existing user" method.
     *
     * @author Angry Code Bat
     */
    public static void meniu() throws ParseException {
        System.out.print("Sveiki !\n");
        System.out.println("1. Press ' 1 ' jeigu norite uzsiregistruoti");
        System.out.println("2. Press ' 2 ' jeigu Jums jau suteiktas prisijungimo ID");

        String userInput = InputValidation.isThisChoiceValid(ScannerClass.getStringInputValue(), "2");
        switch (userInput) {

            case "1":
                NewGymClient clientNew = new NewGymClient();
                clientNew.takeInfo();
                System.out.println("Gal norite gauti savaitine specialai Jums balansuota programa? (spauskite 1)");
                String option = InputValidation.isThisChoiceValid(ScannerClass.getStringInputValue(), "2");
                if (option.equals("1")) {
                    GymPrograms.chooseProgram(clientNew.getClientID());
                } else {
                    return;
                }

                System.out.println("Aciu, kad sportuojate JavaGym !");
                break;
            case "2":
                System.out.print("Iveskit savo ID numeri:\t");
                String userID = Identification.isThisClientIDValid(ScannerClass.getStringInputValue());
                Identification.salutation(userID);
                int stop = 1;
                do {
                    System.out.println("1. Press ' 1 ' Pasportavote ? atnaujinkite duomenis!");
                    System.out.println("2. Press ' 2 ' informacija apie Jusu svorio pokyti per nurodyta laika");
                    System.out.println("3. Press ' 3 ' informacija apie Jusu kuno mases indekso pokyti per nurodyta laika");
                    System.out.println("4. Press ' 4 ' atsiskaitymas uz treniruotes");
                    System.out.println("5. Press ' 5 ' Aciu, viso gero!");
                    String userInput2 = InputValidation.isThisChoiceValid(ScannerClass.getStringInputValue(), "5");
                    switch (userInput2) {
                        case "1":
                            OldGymClient clientOld = new OldGymClient(userID);
                            clientOld.updateInfo();
                            System.out.println("Gal norite gauti savaitine specialai Jums balansuota programa? (spauskite 1)");
                            String option2 = InputValidation.isThisChoiceValid(ScannerClass.getStringInputValue(), "2");
                            if (option2.equals("1")) {
                                GymPrograms.chooseProgram(userID);
                            } else {
                                return;
                            }
                            stop = 1;
                            break;
                        case "2":
                            ProgressCounter.getInfo(userID, 5, "weight");
                            stop = 1;
                            break;
                        case "3":
                            ProgressCounter.getInfo(userID, 6, "bmi");
                            stop = 1;
                            break;
                        case "4":
                            Payment.countPriceToPay(userID);
                            stop = 1;
                            break;
                        case "5":
                            stop = 2;
                            break;
                        default:
                            System.out.println("Aciu, kad sportuojate JavaGym !");
                    }
                } while (stop == 1);

            default:
                System.out.println("Aciu, kad sportuojate JavaGym !");
        }
    }

    public static void main(String[] args) throws ParseException {
        meniu();
    }
}