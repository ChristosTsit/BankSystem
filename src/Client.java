import java.util.ArrayList;

public class Client {
    private String name;
    private long ssn;
    private int salary;
    private ArrayList<BankAccount> accounts;

    Client(String name, long ssn, int salary){
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
        accounts = new ArrayList<>();
    }

    public int maxLoan(){
        if(salary<10000){
            return 0;
        }else if(salary<20000){
            return 2000;
        }else if(salary<40000){
            return 4000;
        }else if(salary<60000){
            return 6000;
        }else if(salary<80000){
            return 8000;
        }else{
            return 10000;
        }
    }

    public void joinBank(Bank b){
        if(!b.getClients().contains(this)){
            b.addClient(this);
        }
    }

    public void leaveBank(Bank b){
        if(b.getClients().contains(this)){
            b.removeClient(this);
        }
    }

    public void createAccount(int balance, Bank b){
        BankAccount bankAccount = new BankAccount(balance,this,b);
        if(!accounts.contains(bankAccount)){
            accounts.add(bankAccount);
        }
    }

    public void deleteAccount(BankAccount acc){
        if(accounts.contains(acc)){
            accounts.remove(acc);
        }else {
            System.out.println("No Such Account");
        }
    }

    public String getName() {
        return name;
    }

    public long getSsn() {
        return ssn;
    }

    public int getSalary() {
        return salary;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void printUser(){
        System.out.println("Name:"+name+"\nSSN:"+ssn+"\nSalary"+salary);
    }

    @Override
    public boolean equals(Object obj) {

        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Client)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Client cl= (Client) obj;

        // Compare the data members and return accordingly
        return ssn == cl.getSsn();
    }
}
