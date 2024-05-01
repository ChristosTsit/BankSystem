import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserPage extends JFrame {
    private JPanel panel = new JPanel();
    private JPanel personalPanel = new JPanel();
    private JPanel bankPanel = new JPanel();
    private JPanel accountsPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private JButton logoutButton = new JButton("Log Out");
    private JButton createBankAcc = new JButton("Create Bank Account");
    private JButton accessButton = new JButton("Access Account");

    private JLabel banksLabel = new JLabel("Banks:");
    private JLabel usernameLabel = new JLabel();
    private JLabel salaryLabel = new JLabel();
    private JLabel accountsLabel = new JLabel("Accounts");

    private  JList<BankAccount> bankAccountsList;
    private JList<Bank> bankList;


    UserPage(ArrayList<Bank> banks ,ArrayList<Client> users, Client cl){
        usernameLabel.setText("Name:"+cl.getName());
        salaryLabel.setText("Salary:"+cl.getSalary()+"$");

        Bank[] bankArray = banks.toArray(new Bank[0]);
        BankAccount[] accArray = cl.getAccounts().toArray(new BankAccount[0]);

        bankList = new JList<>(bankArray);
        bankAccountsList = new JList<>(accArray);
        
        personalPanel.add(usernameLabel);
        personalPanel.add(salaryLabel);

        bankPanel.add(banksLabel);
        bankPanel.add(bankList);

        accountsPanel.add(accountsLabel);
        accountsPanel.add(bankAccountsList);

        buttonPanel.add(createBankAcc);
        buttonPanel.add(accessButton);
        buttonPanel.add(logoutButton);

        panel.add(personalPanel);
        panel.add(bankPanel);
        panel.add(accountsPanel);
        panel.add(buttonPanel);


        createBankAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bank b = bankList.getSelectedValue();
                if(b==null){
                    JOptionPane.showMessageDialog(null, "You need to select a Bank", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    cl.joinBank(b);
                    // Retrieve the updated list of BankAccount objects after joining the bank
                    BankAccount[] accArray = cl.getAccounts().toArray(new BankAccount[0]);

                    // Update the JList with the new array of BankAccount objects
                    bankAccountsList.setListData(accArray);
                }

            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateUserPage(banks,users);
                dispose();
            }
        });

        this.setContentPane(panel);
        this.setVisible(true);
		this.setSize(600, 300);
		this.setTitle("Create User");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
