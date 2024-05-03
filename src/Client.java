import javax.swing.*;
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
            b.getClients().add(this);
            b.setNumberOfClients(b.getNumberOfClients()+1);
            BankAccount bankAccount = new BankAccount(this,b);
            if(!accounts.contains(bankAccount)){
                accounts.add(bankAccount);
            }
            JOptionPane.showMessageDialog(null, "Bank Account Created", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "You already own an account on this bank", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void leaveBank(Bank b){
        if(b.getClients().contains(this)){
            b.getClients().remove(this);
            b.setNumberOfClients(b.getNumberOfClients()-1);
            for(int i=0;i<accounts.size();i++){
                if(accounts.get(i).getBank()==b){
                    accounts.remove(accounts.get(i));
                }
            }
            JOptionPane.showMessageDialog(null, "Bank Account Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Bank Account Not Found", "Error", JOptionPane.ERROR_MESSAGE);
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
