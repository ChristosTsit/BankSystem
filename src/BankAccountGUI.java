import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BankAccountGUI extends JFrame {
    private JPanel panel = new JPanel();
    private JPanel labelPanel = new JPanel();
    private JPanel withdrawPanel = new JPanel();
    private JPanel depositPanel = new JPanel();
    private JPanel loanPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private  JLabel balanceLabel = new JLabel();
    private  JLabel loanLabel = new JLabel();
    private JLabel bankLabel = new JLabel();

    private JTextField withdrawTextField = new JTextField("Enter amount to withdraw...");
    private JTextField depositTextField = new JTextField("Enter amount to deposit...");
    private JTextField loanTextField = new JTextField("Enter amount for loan...");
    private JTextField payLoanTextField = new JTextField("Enter amount to pay...");

    private JButton withdrawButton = new JButton("Withdraw");
    private JButton depositButton = new JButton("Deposit");
    private JButton getLoanButton = new JButton("Get Loan");
    private JButton payLoanButton = new JButton("Pay Loan");
    private JButton goBackButton = new JButton("Exit");
    private JButton deleteAccButton = new JButton("Delete Account");

    BankAccountGUI(ArrayList<Bank> banks , ArrayList<Client> users, Client cl, BankAccount acc){
        bankLabel.setText("Bank:"+acc.getBank());
        balanceLabel.setText("Balance:"+acc.getBalance()+"$");
        loanLabel.setText("Loan:"+acc.getLoan()+"$");

        balanceLabel.setFont(balanceLabel.getFont().deriveFont(Font.BOLD, 30));
        loanLabel.setFont(loanLabel.getFont().deriveFont(Font.BOLD, 30));
        bankLabel.setFont(bankLabel.getFont().deriveFont(Font.BOLD,30));

        bankLabel.setHorizontalAlignment(JLabel.CENTER);

        depositTextField.setPreferredSize(new Dimension(150, 20));
        withdrawTextField.setPreferredSize(new Dimension(170, 20));
        payLoanTextField.setPreferredSize(new Dimension(150, 20));
        loanTextField.setPreferredSize(new Dimension(150, 20));

        //Setting up window's layout
        panel.setLayout(new GridLayout(6, 1));

        panel.add(bankLabel);

        labelPanel.add(balanceLabel);
        labelPanel.add(loanLabel);
        panel.add(labelPanel);

        withdrawPanel.add(withdrawTextField);
        withdrawPanel.add(withdrawButton);
        panel.add(withdrawPanel);

        depositPanel.add(depositTextField);
        depositPanel.add(depositButton);
        panel.add(depositPanel);

        loanPanel.add(loanTextField);
        loanPanel.add(getLoanButton);
        loanPanel.add(payLoanTextField);
        loanPanel.add(payLoanButton);
        panel.add(loanPanel);

        buttonPanel.add(goBackButton);
        buttonPanel.add(deleteAccButton);
        panel.add(buttonPanel);


        //Emptying textfields on click
        withdrawTextField.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                withdrawTextField.setText("");
            }
        });

        depositTextField.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                depositTextField.setText("");
            }
        });

        loanTextField.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                loanTextField.setText("");
            }
        });

        payLoanTextField.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                payLoanTextField.setText("");
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount;
                try {
                    amount = Integer.parseInt(withdrawTextField.getText());
                    acc.withdraw(amount);
                    balanceLabel.setText("Balance:"+acc.getBalance()+"$");
                }catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount;
                try{
                    amount = Integer.parseInt(depositTextField.getText());
                    acc.deposit(amount);
                    balanceLabel.setText("Balance:"+acc.getBalance()+"$");
                }catch (NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount;
                try{
                    amount = Integer.parseInt(loanTextField.getText());
                    acc.takeLoan(amount);
                    balanceLabel.setText("Balance:"+acc.getBalance()+"$");
                    loanLabel.setText("Loan:"+acc.getLoan()+"$");
                }catch (NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        payLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount;
                try{
                    amount = Integer.parseInt(payLoanTextField.getText());
                    acc.payLoan(amount);
                    balanceLabel.setText("Balance:"+acc.getBalance()+"$");
                    loanLabel.setText("Loan:"+acc.getLoan()+"$");
                }catch (NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserPage(banks,users,cl);
                dispose();
            }
        });

        deleteAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.leaveBank(acc.getBank());
                new UserPage(banks,users,cl);
                dispose();
            }
        });

        this.setContentPane(panel);
        this.setVisible(true);
		this.setSize(600, 500);
		this.setTitle("Bank Account Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
