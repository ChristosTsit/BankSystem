import java.util.ArrayList;

public class Bank {
    private String name;
    private int numberOfClients;
    private ArrayList<Client> clients;

    Bank(String name){
        this.name = name;
        this.numberOfClients = 0;
        this.clients = new ArrayList<>();
        System.out.println("Bank created successfully!!"+"\nName:"+this.name);
    }

    public void addClient(Client cl){
        if(clients.contains(cl)){
            System.out.println("Already a client!");
        }else{
            clients.add(cl);
            numberOfClients++;
            System.out.println("Client added SUCCESSFULLY!");
        }
    }

    public void removeClient(Client cl){
        if(clients.contains(cl)){
            clients.remove(cl);
            numberOfClients--;
            System.out.println("Client removed SUCCESSFULLY!");
        }else {
            System.out.println("Client not found!");
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
}
