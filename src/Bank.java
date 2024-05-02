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
        if(clients.contains(cl)){
            JOptionPane.showMessageDialog(null, "Already a client", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            clients.add(cl);
            numberOfClients++;
            JOptionPane.showMessageDialog(null, "Client Added", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void removeClient(Client cl){
        if(clients.contains(cl)){
            clients.remove(cl);
            numberOfClients--;
            JOptionPane.showMessageDialog(null, "Client Removed", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Client not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
