import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserPage extends JFrame {
    //Panels
    private JPanel panel = new JPanel();
    private JPanel personalPanel = new JPanel();
    private JPanel bankPanel = new JPanel();
    private JPanel accountsPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    //Buttons
    private JButton logoutButton = new JButton("Log Out");
    private JButton createBankAcc = new JButton("Create Bank Account");
    private JButton accessButton = new JButton("Access Account");
    //Labels
    private JLabel banksLabel = new JLabel("Banks:");
    private JLabel usernameLabel = new JLabel();
    private JLabel accountsLabel = new JLabel("Accounts");
    //Lists
    private  JList<BankAccount> bankAccountsList;
    private JList<Bank> bankList;
    //Arrays to be used for the JLists
    private BankAccount[] accArray;
    private Bank[] bankArray;

    UserPage(ArrayList<Bank> banks ,ArrayList<Client> users, Client cl){
        usernameLabel.setText("Name:"+cl.getName());
        usernameLabel.setFont(usernameLabel.getFont().deriveFont(Font.BOLD, 30));

        //Initialising arrays
        bankArray = banks.toArray(new Bank[0]);
        accArray = cl.getAccounts().toArray(new BankAccount[0]);

        //Setting up window's layout
        panel.setLayout(new GridLayout(4, 1));

        //Filling JLists
        bankList = new JList<>(bankArray);
        bankAccountsList = new JList<>(accArray);

        //Adding components to the panels
        personalPanel.add(usernameLabel);

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

        //Creating a bank account for the chosen bank of the specific JList
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

        //Access to bank account's information and actions
        accessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankAccount acc = bankAccountsList.getSelectedValue();
                if(acc==null){
                    JOptionPane.showMessageDialog(null, "You need to select a Bank Account", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    new BankAccountGUI(banks ,users, cl,acc);
                    dispose();
                }
            }
        });

        //Returning to login page
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateUserPage(banks,users);
                dispose();
            }
        });

        this.setContentPane(panel);
        this.setVisible(true);
		this.setSize(600, 600);
		this.setTitle("User Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
