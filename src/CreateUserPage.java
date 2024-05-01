import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateUserPage extends JFrame {
    private JPanel panel = new JPanel();
    private JButton  createButton = new JButton("Create User");
    private JButton loginButton = new JButton("Log In");
    private JButton exitButton = new JButton("Exit");
    private JLabel nameLabel = new JLabel("Name:");
    private JLabel ssnLabel = new JLabel("SSN:");
    private JLabel salaryLabel = new JLabel("Salary:");
    private JTextField name = new JTextField("Enter Name...");
    private JTextField ssn = new JTextField("Enter Social Security Number...");
    private JTextField salary = new JTextField("Enter Salary...");


    CreateUserPage(ArrayList<Bank> banks, ArrayList<Client> users){
        panel.add(nameLabel);
        panel.add(name);
        panel.add(ssnLabel);
        panel.add(ssn);
        panel.add(salaryLabel);
        panel.add(salary);
        panel.add(createButton);
        panel.add(loginButton);
        panel.add(exitButton);

        //Making TextFields Blank OnClick
        name.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                name.setText("");
            }
        });
        ssn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                ssn.setText("");
            }
        });
        salary.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                salary.setText("");
            }
        });

        //Creating Button Listeners
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText();
                String ssnText = ssn.getText();
                String salaryText = salary.getText();
                long ssnValue;
                int salaryValue;

                if(nameText.isEmpty() ||ssnText.isEmpty()||salaryText.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You need to fill all of the fields", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    //Check if format is correct
                    try {
                        ssnValue = Long.parseLong(ssnText);
                        salaryValue = Integer.parseInt(salaryText);

                        Client cl = new Client(nameText,ssnValue,salaryValue);
                        if(users.contains(cl)){
                            JOptionPane.showMessageDialog(null, "User Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
                        }else {
                            users.add(cl);
                            JOptionPane.showMessageDialog(null, "User Created Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException error) {
                        JOptionPane.showMessageDialog(null, "Invalid Format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText();
                String ssnText = ssn.getText();
                String salaryText = salary.getText();
                long ssnValue;
                int salaryValue;
                try {
                    ssnValue = Long.parseLong(ssnText);
                    salaryValue = Integer.parseInt(salaryText);

                    Client cl = new Client(nameText,ssnValue,salaryValue);
                    if(users.contains(cl)){
                        JOptionPane.showMessageDialog(null, "Successful Log In", "Information", JOptionPane.INFORMATION_MESSAGE);
                        new UserPage(banks,users,cl);
                        dispose();
                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        this.setContentPane(panel);
        this.setVisible(true);
		this.setSize(700, 300);
		this.setTitle("Create User");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
