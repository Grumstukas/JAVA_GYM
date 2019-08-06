package Gym3;

public abstract class AbstractClient {
    private String clientName;
    private String phoneNumber;
    private String email;
    private double clientWeight;
    private double clientHeight;
    private double clientBMI;
    private int sportTime;
    private Object localDate;

    public AbstractClient(String clientName) {
        this.clientName = clientName;
    }

}
