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

    public void addClient(Client cl){
        clients.add(cl);
        numberOfClients++;
        JOptionPane.showMessageDialog(null, "Bank Account Created", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void removeClient(Client cl){
        clients.remove(cl);
        numberOfClients--;
        JOptionPane.showMessageDialog(null, "Bank Account Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getName() {
        return name;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return name;
    }
}
