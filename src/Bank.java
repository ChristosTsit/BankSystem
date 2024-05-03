import javax.swing.*;
import java.util.ArrayList;

public class Bank {
    private String name;
    private int numberOfClients;
    private ArrayList<Client> clients;

    Bank(String name){
        this.name = name;
        this.numberOfClients = 0;
        this.clients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return name;
    }
}
