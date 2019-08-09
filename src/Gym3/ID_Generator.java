package Gym3;

public class ID_Generator {
    /**
     * This method generates unique Client ID TODO    ID validation
     */
    public static String newID(String a, String b) {
        int number = randomNumber();
        randomNumber();
        String ID = a.toUpperCase().substring(0, 1) + "" + b.toUpperCase().substring(0, 1) + "" + number;
        return ID;
    }

    private static int randomNumber() {
        int random = (int) Math.floor(Math.random() * 899) + 100;
        return random;
    }
}
