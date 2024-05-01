public class Main {
    public static void main(String[] args) {
      Bank b = new Bank("Eurobank");
      Client cl = new Client("Homer",231321,10000);
      b.addClient(cl);
      b.addClient(cl);
      b.removeClient(cl);
      b.removeClient(cl);
    }
}