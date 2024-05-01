import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateUserPage extends JFrame {
    private JPanel panel = new JPanel();
    private JButton  createButton = new JButton("Create User");
    private JButton loginButton = new JButton("Log In");
    private JTextField name = new JTextField("Enter Name...");
    private JTextField ssn = new JTextField("Enter Social Security Number...");
    private JTextField salary = new JTextField("Enter Salary...");
    private ArrayList<Client> users = new ArrayList<>();

    CreateUserPage(ArrayList<Bank> banks){
        panel.add(name);
        panel.add(ssn);
        panel.add(salary);
        panel.add(createButton);
        panel.add(loginButton);

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
        ButtonListener listener = new ButtonListener();
        createButton.addActionListener(listener);


        this.setContentPane(panel);
        this.setVisible(true);
		this.setSize(600, 300);
		this.setTitle("Create User");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
            Client cl = new Client(name.getText(),Long.parseLong(ssn.getText()),Integer.parseInt(salary.getText()));
            if(users.contains(cl)){
                JOptionPane.showMessageDialog(null, "User Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                users.add(cl);
                JOptionPane.showMessageDialog(null, "User Created Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
		}
	}

}
