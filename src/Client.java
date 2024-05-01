import java.util.ArrayList;

public class Client {
    private String name;
    private long ssn;
    private int salary;
    private ArrayList<BankAccount> accounts;

    Client(String name, long ssn){
        this.name = name;
        this.ssn = ssn;
        accounts = new ArrayList<>();
    }

    public void joinBank(Bank b){
        if(!b.getClients().contains(this)){
            b.addClient(this);
            BankAccount bankAccount = new BankAccount(this,b);
            if(!accounts.contains(bankAccount)){
                accounts.add(bankAccount);
            }
        }
    }

    public void leaveBank(Bank b){
        if(b.getClients().contains(this)){
            b.removeClient(this);
            for(BankAccount bs:accounts){
                if(bs.getBank()==b){
                    accounts.remove(bs);
                }
            }
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
        return (ssn == cl.getSsn()&& name.equals(cl.getName()));
    }
}
