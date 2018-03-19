import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) throws IOException {
        //Tworze liste typu Account do ktorej dodamy wczytane z pliku dane
        List<Account> accounts = new LinkedList<Account>();


        // Wgrywamy plik do listy
        String file = "C:\\[Luck]\\[Java]\\BankApp\\src\\files\\file.csv";

        List<String[]> newCustomers = utilities.CSV.read(file);
        for (String[] s : newCustomers) {
            String name = s[0];
            String sSn = s[1];
            String accountType = s[2];
            double initDeposit = Double.parseDouble(s[3]);

            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSn, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSn, initDeposit));
            } else
                System.out.println("ERROR ACOUNT TYPE");
        }

        // drukujemy wyniki
        for (Account account : accounts) {
            account.showInfo();
            System.out.println("----------------------------------");
        }

    }
}
