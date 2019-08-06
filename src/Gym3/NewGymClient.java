package Gym3;

import java.util.Scanner;

public class NewGymClient extends ClientMethods {
    protected String clientID;
    protected String clientName;
    protected String clientSurname;
    protected String phoneNumber;
    protected String email;
    protected double clientWeight;
    protected double clientHeight;
    protected double clientBMI;

    /**
     * Constructor contains only client name
     *
     * @param clientName
     */
    public NewGymClient(String clientName) {
        this.clientName = clientName;
    }

    /**
     * method asks of all other parameters that client must have
     */
    void takeInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Kokia Jusu pavarde?\t|\t");
        setClientSurname(input.next());

        System.out.println("Prasau pateikite informacija reikalinga registracijos ivykdymui");

        System.out.print("telefono numeris: \t\t|\t");
        setPhoneNumber(input.next());

        System.out.print("elektroninis pastas: \t|\t");
        setEmail(input.next());

        System.out.print("kuno mase (kg): \t\t\t|\t");
        setClientWeight(input.nextDouble());

        System.out.print("kuno ugis(cm): \t\t\t|\t");
        setClientHeight(input.nextDouble());

        newID();
        setClientBMI(calcBMI(clientWeight, clientHeight/100));
        String clientPath = "All_Clients\\"+getClientID()+".txt";
        String clientInfo = clientName +"\t|\t" + clientSurname+
                "\t|\t"+ phoneNumber +"\t|\t"+ email +"\t|\t"+ clientWeight +"\t|\t"+ clientHeight +"\t|\t"+ (clientBMI/100)*100D;

        writeClientInfoToFile(clientInfo, clientPath);//asmrenine
        writeClientInfoToFile(clientInfo, "All_Clients\\All.txt");
        System.out.println("Jums suteiktas ID yra   " + getClientID() + "   " +
                "\nPrasau issaugokite ji, jo jums prireiks norint ateityje lankyti JAVAGYM sporto kluba :)");
    }

    /**
     * This method generates unique Client ID TODO    ID validation
     */
    void newID() {
        String ID = getClientName().substring(0, 1) + "" + getClientSurname().substring(0, 1) + "" + (int) Math.floor(Math.random() * 999);
        setClientID(ID);
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
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

    public String getClientName() {
        return clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientID() {
        return clientID;
    }

}
