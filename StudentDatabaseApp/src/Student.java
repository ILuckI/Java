import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String courses;
    private String studentID;
    private int balance;
    private int costOfCourse = 400;
    private static int id = 1000;

    public Student() {
        // Prosze usera o imie i nazwisko
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter student first last name: ");
        this.lastName = scanner.nextLine();
        setStudentId();

    }

    // Generowanie id dla studenta
    private void setStudentId() {
        id++;
        this.studentID = "#" + id;
    }

    // Zapisy na zajecia
    public void enroll() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter course to enroll (Q  to quit): ");
            String course = scanner.nextLine();

            if (!course.equals("Q")) {
                courses += course + ", ";
                balance = balance + costOfCourse;
            }
            else {
                break;
            }
        } while (1 != 0);

    }
    // Pokaz balance
    public void viewBalance(){
        System.out.println("Your balance is : $ " + balance);
    }

    // Zaplac
    public void payment(){
        Scanner scanner = new Scanner(System.in);
        viewBalance();
        System.out.print("Enter you payment: ");
        int payment = scanner.nextInt();
        balance = balance - payment;
        System.out.println("Thank you for payment");
        viewBalance();
    }

    // Pokaz status
    public String showInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(firstName).append(" ").append(lastName);
        sb.append("\nStudent ID: ").append(studentID);
        sb.append("\nCourses Enrolled: ").append(courses);
        sb.append("\nBalance: ").append(balance);
        return sb.toString();
    }

}
