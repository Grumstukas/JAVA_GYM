package Gym3;

public class ID_Generator {
    /**
     * This method generates unique Client ID TODO    ID validation
     */
    public static String newID(String a, String b) {
        String ID = a.toUpperCase().substring(0, 1) + "" + b.toUpperCase().substring(0, 1) + "" + (int) Math.floor(Math.random() * 999);
        return ID;
    }
}
