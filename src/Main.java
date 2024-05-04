import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static final Toolkit toolkit = Toolkit.getDefaultToolkit();
    public static final Dimension screenSize = toolkit.getScreenSize();
    public static void main(String[] args) {
        ArrayList<Bank> banks = new ArrayList<>();
        ArrayList<Client> users = new ArrayList<>();

        String fileName = "C:\\Users\\chris\\IdeaProjects\\BankSystem1\\src\\Banks.txt";

        //Reading the file line by line to get all the names of the banks
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line contains a name
                Bank bank = new Bank(line.trim()); // Assuming your Bank class has a constructor taking the name
                banks.add(bank);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        new MainPage(banks,users);
    }
}