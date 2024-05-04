import javax.swing.*;

public class BankAccount {
    private int balance;
    private int loan;
    private Client owner;
    private Bank bank;

    BankAccount(Client client, Bank bank){
        this.balance = 0;
        this.owner = client;
        this.bank = bank;
    }

    public void withdraw(int amount){
        if(balance<amount){
            JOptionPane.showMessageDialog(null, "Insufficient Funds", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            balance-=amount;
            JOptionPane.showMessageDialog(null, "Withdraw Completed\nYour new balance is:"+balance+"$", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deposit(int amount){
        balance+=amount;
        JOptionPane.showMessageDialog(null, "Deposit Completed\nYour new balance is:"+balance+"$", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void takeLoan(int amount){
            balance+=amount;
            loan= loan + amount+(amount*20/100);
            JOptionPane.showMessageDialog(null, "Loan Granted\nYour new balance is:"+balance+"$", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void payLoan(int amount){
        if(loan==0){
            JOptionPane.showMessageDialog(null, "There are no pending payments!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if (amount <= balance) {
                if(amount<loan){
                    balance-=amount;
                    loan-=amount;
                    JOptionPane.showMessageDialog(null, "Payment Completed!\n"+loan+"$ remaining!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    balance-=loan;
                    loan = 0;
                    JOptionPane.showMessageDialog(null, "The loan has been repayed", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Insufficient Funds", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public int getBalance() {
        return balance;
    }

    public Client getOwner() {
        return owner;
    }

    public int getLoan() {
        return loan;
    }

    public Bank getBank() {
        return bank;
    }

    @Override
    public String toString(){
        return getBank().getName()+" Account";
    }
}
