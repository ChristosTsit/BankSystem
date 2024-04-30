import java.util.ArrayList;

public class Bank {
    private String name;
    private int numberOfClients;
    private ArrayList<Client> clients;

    Bank(String name){
        this.name = name;
        this.numberOfClients = 0;
        this.clients = new ArrayList<>();
        System.out.println("Bank created successfully!!"+"Name:"+this.name);
    }


}
