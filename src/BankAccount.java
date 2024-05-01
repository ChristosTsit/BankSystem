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
            System.out.println("Insufficient Funds");
        }else{
            balance-=amount;
            System.out.println("Withdraw Completed");
        }
    }

    public void deposit(int amount){
        balance+=amount;
        System.out.println("Deposit Completed");
    }

    public void takeLoan(int amount){
        if (amount< owner.maxLoan()){
            System.out.println("Insufficient Credit Score");
        }else {
            balance+=amount;
            loan+=(amount*20/100);
            System.out.println("Loan Approved");
        }
    }

    public void payupLoan(int amount){
        if (amount <= balance) {
            balance-=amount;
            loan-=amount;
            if(loan==0){
                System.out.println("The loan has been repayed!");
            }else {
                System.out.println("Payment Completed!\n"+loan+"$ remaining!");
            }
        }else {
            System.out.println("Insufficient Funds");
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
        return this.getBank().getName()+" Account";
    }
}
