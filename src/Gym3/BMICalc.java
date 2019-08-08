package Gym3;

public class BMICalc {

    /**
     * counts client BMI
     *
     * @param Weight 
     * @param Height
     * @return - BMI + recommendations
     */
    public static double calcBMI(double Weight, double Height) {
        double BMI = Weight / Math.pow(Height/100,2);
        System.out.println();
        System.out.format("Your body mass index is - " + "%.2f%n", BMI);
        if (BMI < 18.5) {
            System.out.println("BMI is less than normal, visiting nutritionist is highly recommended");
        }
        if (18.5 < BMI && BMI < 25) {
            System.out.println("BMI is normal, no special recommendations.");
        }
        if (25 <= BMI && BMI < 30) {
            System.out.println("BMI is a little higher than normal, visiting nutritionist is highly recommended");
        }
        if (30 <= BMI) {
            System.out.println("BMI is much higher than normal, visiting nutritionist is highly recommended, weakened gym program recommended.");
        }
        return  (double) Math.round(BMI * 100) / 100;
    }
}

