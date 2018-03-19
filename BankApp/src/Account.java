public abstract class Account implements IRate {
    // private uzywam tylko w klasie abstrakcyjnej Account
    private String name;
    private String sSN;
    private double balance;
    private static int index = 10000;

    // protected uzywam w ramach paczki (Pola uzywane przez Savings, Checking class)
    protected double rate;
    protected String accountNumber;

    // Konstruktor
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        // podnosimy wartosc index za kazdym razem jak tworzymy obiekt
        index++;

        // przypisujemy zmiennej accountNumber Stringa z metody
        this.accountNumber = setAccountNumber();

        // wywolana metoda (ustaw stawke/procent)
        setRate();
    }

    // metoda abstrakcyjna powoduje wymuszenie jej na klasach ktore dziedzicza po tej klasie
    public abstract void setRate();

    // metoda ustawiajaca (generujaca) numer konta bankowego
    // sklada sie z :  wyciecia 2 ostatnich cyfr z numeru sSn
                    // dodania pola index (10000) + 1 za kazdym razem gdy tworzymy instancje
                    // dodania wygenerowanego random 3 cyfrowego nuymera
    private String setAccountNumber() {
        String latTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
        int rndNumber = (int) (Math.random() * Math.pow(10, 3));
        return latTwoOfSSN + uniqueID + rndNumber;

    }

    // metoda oblicza narastajacy przychod na podstawie danych
    public void compound() {
        double accruedIntrest = balance * (rate / 100);
        balance = balance + accruedIntrest;

    }

    // metoda dodaje srodki na konto
    public void deposit(double amount) {
        balance = balance + amount;
    }

    // metoda odejmuje srodki z konta
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    // metoda wykonujaca przelew
    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transfer " + amount + " to " + toWhere);
    }

    // metoda drukujaca saldo
    public void printBalance() {
        System.out.println("Your balance is now: " + balance);
    }

    // metoda pokazuje informacje konta
    public void showInfo() {
        System.out.println("Name: " + name + "\nAccount number: " + accountNumber + "\nBalance: " + balance);
    }

}
