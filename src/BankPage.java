import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BankPage extends JFrame {
    private JPanel panel = new JPanel();
    private JPanel listPanel = new JPanel();

    private JLabel nameLabel = new JLabel();
    private JLabel numOfClients = new JLabel();
    private JLabel clientsLabel = new JLabel("Clients:");

    private JList<Client> clientList;

    private Client[] clArray;

    private JButton deleteClientButton = new JButton("Delete Client");
    private JButton logoutButton = new JButton("Log Out");

    BankPage(ArrayList<Bank> banks,ArrayList<Client> users, Bank b){
        panel.setLayout(new GridLayout(5, 1));

        nameLabel.setText(b.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 30));

        numOfClients.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 30));
        numOfClients.setText("Number of clients:"+b.getNumberOfClients());

        numOfClients.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        clArray = b.getClients().toArray(new Client[0]);

        clientList = new JList<>(clArray);

        listPanel.add(clientsLabel);
        listPanel.add(clientList);

        panel.add(nameLabel);
        panel.add(numOfClients);
        panel.add(listPanel);
        panel.add(deleteClientButton);
        panel.add(logoutButton);

        deleteClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client cl = clientList.getSelectedValue();
                if(cl==null){
                    JOptionPane.showMessageDialog(null, "You need to select a Client", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    cl.leaveBank(b);

                    clArray = b.getClients().toArray(new Client[0]);
                    clientList.setListData(clArray);
                    numOfClients.setText("Number of clients:"+String.valueOf(b.getNumberOfClients()));
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateBankPage(banks,users);
                dispose();
            }
        });

        this.setContentPane(panel);
        this.setSize(600,600);
        this.setVisible(true);
        this.setTitle("Bank Page");
        this.setLocation((Main.screenSize.width-this.getWidth())/2,(Main.screenSize.height-this.getHeight())/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
