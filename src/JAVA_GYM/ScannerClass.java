package JAVA_GYM;

import java.util.Scanner;

public class ScannerClass {

    public static String getStringInputValue() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static int getIntInputValue() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public static double getIntDoubleValue() {
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        return input;
    }

    public static long getIntLongValue() {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        return input;
    }
}
