import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "ls_code.pl";

    // Konstruktor
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Wywolamy metode (zapytamy o dzial) co zwroci department
        this.department = setDepartment();

        // Wywolamy metode (random password) co zwroci password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("You password is: " + this.password);

        // Dodanie elementow i wygenerowanie maila
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."+ companySuffix;
    }

    // Pytamy o dzial w firmie.
    private String setDepartment(){
        System.out.print("Select the deparment:\n1 :: Sales \n2 :: Development \n3 :: Accounting \n0 :: none\nEnter departmend index: ");
        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();
        if (departmentChoice == 1){ return "sales";}
        else if (departmentChoice == 2){ return "development";}
        else if (departmentChoice == 3){ return "accounting";}
        else if (departmentChoice == 0){ return "none";}
        else {
            return "";
        }
    }

    // Generowanie losowego hasla
    private String randomPassword(int lenght){
        String passwordSet = "QWERTYUIOP1234567890ASDFGHJKLZXCVBNM!@#$%^&*";
        char[] password = new char[lenght];
        for (int i = 0; i <lenght ; i++) {
            int random = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Ustawienie mailbox
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    // Ustawienie alternatywnego emaila
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    // Umozliwienie zmiany hasla
    public void changePassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Name: ").append(firstName).append(" ").append(lastName)
                .append("\n").append("Company email: ").append(email).append("\n")
                .append("MailBox Capacity: ").append(mailBoxCapacity).append(" mb").toString();
    }
}
