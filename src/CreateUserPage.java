import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CreateUserPage extends JFrame {
    //Panel
    private JPanel panel = new JPanel();
    //Buttons
    private JButton  createButton = new JButton("Create User");
    private JButton loginButton = new JButton("Log In");
    private JButton exitButton = new JButton("Exit");
    //Labels
    private JLabel nameLabel = new JLabel("Name:");
    private JLabel ssnLabel = new JLabel("SSN:");
    //Texts
    private JTextField name = new JTextField("Enter Name...");
    private JTextField ssn = new JTextField("Enter Social Security Number...");


    CreateUserPage(ArrayList<Bank> banks, ArrayList<Client> users){
        //Adding components to the panel
        panel.add(nameLabel);
        panel.add(name);
        panel.add(ssnLabel);
        panel.add(ssn);
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

        //Creating Button Listeners
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText();
                String ssnText = ssn.getText();
                long ssnValue;

                //Checking if all fields are filled
                if(nameText.isEmpty() ||ssnText.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You need to fill all of the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!Pattern.matches("[a-zA-Z]+", nameText)) {
                    JOptionPane.showMessageDialog(null, "Invalid Name Input\nOnly letters are allowed", "Error", JOptionPane.ERROR_MESSAGE);
                } else{

                    //Checking if format is correct
                    try {
                        ssnValue = Long.parseLong(ssnText);

                        Client cl = new Client(nameText,ssnValue);
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
                //Exiting current window
                new MainPage(banks,users);
                dispose();
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText();
                String ssnText = ssn.getText();

                long ssnValue;

                //Checking if format is correct
                try {
                    ssnValue = Long.parseLong(ssnText);

                    Client cl = new Client(nameText,ssnValue);

                    //Checking if user already exists to achieve login
                    if(users.contains(cl)){
                        cl = users.get(users.indexOf(cl));
                        JOptionPane.showMessageDialog(null, "Successful Log In", "Information", JOptionPane.INFORMATION_MESSAGE);
                        new UserPage(banks,users,cl);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Invalid Format. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        this.setContentPane(panel);
        this.setVisible(true);
		this.setSize(700, 100);
		this.setTitle("Create User");
        this.setLocation((Main.screenSize.width-this.getWidth())/2,(Main.screenSize.height-this.getHeight())/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
