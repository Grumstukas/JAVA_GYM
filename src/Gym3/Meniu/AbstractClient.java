package Gym3.Meniu;

public abstract class AbstractClient {
    private String clientID;
    private String clientName;
    private String clientSurname;
    private String email;
    private String phoneNumber;
    private double clientWeight;
    private double clientHeight;
    private double clientBMI;

//    public AbstractClient(String clientName, String clientSurname, String email, long phoneNumber,
//                          double clientWeight, double clientHeight) {
//        this.clientName = clientName;
//        this.clientSurname = clientSurname;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.clientWeight = clientWeight;
//        this.clientHeight = clientHeight;
//    }

    public String getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getClientWeight() {
        return clientWeight;
    }

    public double getClientHeight() {
        return clientHeight;
    }

    public double getClientBMI() {
        return clientBMI;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setClientName(String clientName) {
        if (clientName.equals("") & clientName == null) {
            System.out.println("Name must contain letters a-z.");
        } else {
            this.clientName = clientName;
        }
        if (clientName.length() > 20) {
            System.out.println("Name must contain not more than 20 letters");
        } else {
            this.clientName = clientName;
        }
    }

    public void setClientSurname(String clientSurname) {
        if (clientSurname.equals("") & clientSurname == null) {
            System.out.println("Name must contain letters a-z.");
        } else {
            this.clientSurname = clientSurname;
        }
        if (clientSurname.length() > 20) {
            System.out.println("Name must contain not more than 20 letters");
        } else {
            this.clientSurname = clientSurname;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (String.valueOf(phoneNumber).length() != 8)
        {
            System.out.println("Rest of the phone number must contain 8 numbers.");
        } else{
            this.phoneNumber = phoneNumber;
        }
    }

    public void setClientWeight(double clientWeight) {
        if (clientWeight > 200 || clientWeight < 20) {
            System.out.println("Please enter a valid weight.");
        } else {
            this.clientWeight = clientWeight;
        }
    }

    public void setClientHeight(double clientHeight) {
        if (clientHeight > 250 || clientHeight < 50) {
            System.out.println("Please enter a valid height.");
        } else {
            this.clientHeight = clientHeight;
        }
    }

    public void setClientBMI(double clientBMI) {
        this.clientBMI = clientBMI;
    }

}
