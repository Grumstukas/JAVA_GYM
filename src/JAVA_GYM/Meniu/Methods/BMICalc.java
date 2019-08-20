package JAVA_GYM.Meniu.Methods;

public class BMICalc {

    private double BMI;

    public BMICalc(double Weight, double Height) {
        this.BMI = (double) Math.round((Weight / Math.pow(Height / 100, 2)) * 100) / 100;
        System.out.println();
        System.out.format("Your body mass index is - " + "%.2f%n", this.BMI);
        if ( this.BMI < 18.5 ) {
            System.out.println("BMI is less than normal, visiting nutritionist is highly recommended");
        }
        if ( 18.5 < this.BMI && this.BMI < 25 ) {
            System.out.println("BMI is normal, no special recommendations.");
        }
        if ( 25 <= this.BMI && this.BMI < 30 ) {
            System.out.println("BMI is a little higher than normal, visiting nutritionist is highly recommended");
        }
        if ( 30 <= this.BMI ) {
            System.out.println("BMI is much higher than normal, visiting nutritionist is highly recommended, weakened gym program recommended.");
        }
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double bMI) {
        this.BMI = bMI;
    }

}

