import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPage extends JFrame{


    private JPanel panel = new JPanel();

    private JButton bankButton = new JButton("Banks Page");
    private JButton userButton = new JButton("Users Page");
    private JButton exitButton = new JButton("Exit");

    MainPage(ArrayList<Bank> banks,ArrayList<Client> users){
        panel.setLayout(new GridLayout(3, 1));

        panel.add(bankButton);
        panel.add(userButton);
        panel.add(exitButton);

        bankButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateBankPage(banks,users);
                dispose();
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateUserPage(banks,users);
                dispose();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.setContentPane(panel);
        this.setSize(200,200);
        this.setVisible(true);
        this.setTitle("Main Page");
        this.setLocation((Main.screenSize.width-this.getWidth())/2,(Main.screenSize.height-this.getHeight())/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
