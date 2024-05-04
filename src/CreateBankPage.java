import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CreateBankPage extends JFrame {
    JPanel panel = new JPanel();

    JLabel nameLabel = new JLabel("Firm:");

    JTextField nameField = new JTextField("Enter firm's name...");

    JButton createButton = new JButton("Create Bank");
    JButton loginButton = new JButton("Log in");
    JButton exitButton = new JButton("Exit");

    CreateBankPage(ArrayList<Bank> banks, ArrayList<Client> users){
        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(createButton);
        panel.add(loginButton);
        panel.add(exitButton);

        nameField.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                nameField.setText("");
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if(Pattern.matches("[a-zA-Z]+",name)){
                    Bank b = new Bank(name);
                    if(!banks.contains(b)){
                        banks.add(b);
                        JOptionPane.showMessageDialog(null, "Bank Created", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null, "Bank Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Input\nOnly letters are allowed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage(banks,users);
                dispose();
            }
        });


        this.setContentPane(panel);
        this.setSize(500,100);
        this.setVisible(true);
        this.setTitle("Create Bank Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
