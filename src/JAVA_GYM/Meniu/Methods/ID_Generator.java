package JAVA_GYM.Meniu.Methods;

public class ID_Generator {
    private String id;

    public ID_Generator(String a, String b) {
        int number = randomNumber();
        randomNumber();
        String id = a.toUpperCase().substring(0, 1) + "" + b.toUpperCase().substring(0, 1) + "" + number;
        this.id = id;
    }

    private static int randomNumber() {
        int random = (int) Math.floor(Math.random() * 899) + 100;
        return random;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method generates unique Client ID TODO    ID validation
     */
//    public static String newID() {
//        int number = randomNumber();
//        randomNumber();
//        String id = a.toUpperCase().substring(0, 1) + "" + b.toUpperCase().substring(0, 1) + "" + number;
//        return id;
//    }


}
