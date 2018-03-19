import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter number of student to enroll: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();
        Student[] students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter next student: ");
            students[i] = new Student();
            students[i].enroll();
            students[i].payment();
            System.out.println(students[i].showInfo());
            System.out.println("\n");
        }

    }
}
