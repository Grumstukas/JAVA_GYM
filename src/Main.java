import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Client[] clients = new Client[100];
        int clientsCount = 0;

        System.out.println("hello");

        hello(clients, clientsCount);
        clients[0].RegisterClientToFile(clients[0].getName(),clients[0].getHeight(),clients[0].getMass());
        clients[1].RegisterClientToFile(clients[1].getName(),clients[1].getHeight(),clients[1].getMass());
        clients[0].readFile();
        readFileWithScanner(clientsCount);
        System.out.println("all clients = "+clientsCount);

    }

    private static void hello(Client[] clients, int clientsCount) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("press 1 for new client\n" +
                    "press 2 to get client progress");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    createNew(clients, clientsCount);
                    break;
                case 2:
                    System.out.println("your are old");
                    break;
                default:
                    System.out.println("That's not a choice");
            }
        } catch (InputMismatchException ex) {
            System.out.println("That's not a choice"+ex);
        }
    }

    private static int createNew(Client[] clients, int clientsCount) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("name");
            String name = input.next();

            System.out.print("height");
            double height = input.nextDouble();

            System.out.print("mass");
            double mass = input.nextDouble();

            clients[clientsCount] = new Client(name, height, mass);
            if (clientsCount + 1 < 10) {
                clients[clientsCount].setClientID("ID00" + (clientsCount + 1));
            }
            if (clientsCount + 1 > 10) {
                clients[clientsCount].setClientID("ID0" + (clientsCount + 1));
            }
            clientsCount += 1;
            System.out.println("Register one more Client ? \n yes (press 1),   \n no (press any other button)");
            int more = input.nextInt();
            if (more == 1) {
                createNew(clients, clientsCount);
            } else {
                System.out.println("Goodbye");
            }
        } catch (InputMismatchException ex) {
            System.out.println(ex);
        }
        return clientsCount;
    }

    public static int readFileWithScanner(int clientsCount){
        clientsCount = 0;
        List<String> allClients = new ArrayList<String>();
        List<String> filteredClients = new ArrayList<String>();
        File fileForRead = new File("clients\\all_clients.txt");
        try(Scanner scanner = new Scanner(fileForRead)){
            while(scanner.hasNextLine()){
                allClients.add(scanner.next());
                scanner.nextLine();
                clientsCount = allClients.size();
            }
        }catch (IOException ex){
            System.out.println(ex);
        }
        for (String client:allClients){
            if (!filteredClients.contains(client)){
                filteredClients.add(client);
            }
        }
        clientsCount = filteredClients.size();
        System.out.println(filteredClients.toString());
        System.out.println("all clients = "+clientsCount);
        return clientsCount;
    }
}
