package Gym3;

import java.util.Scanner;

import static Gym3.Main.sportsman;

public class NewGymClient {
    protected String clientName;
    protected String phoneNumber;
    protected String email;
    protected double clientWeight;
    protected double clientHeight;
    protected double clientBMI;

    public NewGymClient(String clientName) {
        this.clientName = clientName;
    }

    void takeInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Prasau pateikite informacija reikalinga registracijos ivykdymui");

        System.out.print("telefono numeris: \t\t|\t");
        setPhoneNumber(input.next());

        System.out.print("elektroninis pastas: \t|\t");
        String email = input.next();
        try {
            setEmail(email);
        }catch (NullPointerException ex){
            setEmail("no email");
        }


        System.out.print("kuno mase (kg): \t\t\t|\t");
        setClientWeight(input.nextDouble());

        System.out.print("kuno ugis(cm): \t\t\t|\t");
        setClientHeight(input.nextDouble());
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setClientWeight(double clientWeight) {
        this.clientWeight = clientWeight;
    }
    public void setClientHeight(double clientHeight) {
        this.clientHeight = clientHeight;
    }
    public void setClientBMI(double clientBMI) {
        this.clientBMI = clientBMI;
    }
}
