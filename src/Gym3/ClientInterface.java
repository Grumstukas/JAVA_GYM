package Gym3;

public interface ClientInterface {
    public void writeClientInfoToFile(String registrationInput, String pathNameAllClient);
    public boolean readFile(String pathToReed, String clientInfo);
}
