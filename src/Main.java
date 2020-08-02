import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId;

        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentManager.add();
                    break;
                case "2":
                    studentId = studentManager.inputId();
                    studentManager.edit(studentId);
                    break;
                case "3":
                    studentId = studentManager.inputId();
                    studentManager.delete(studentId);
                    break;
                case "4":
                    studentManager.sortStudentByGPA();
                    break;
                case "5":
                    studentManager.sortStudentByName();
                    break;
                case "6":
                    studentManager.show();
                    break;
                case "0":
                    System.out.println("Exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! Please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            showMenu2();
            String choose2 = scanner.nextLine();
            switch (choose2) {
                case "1":
                    System.out.println("Return menu");
                    showMenu();
                    break;
                case "2":
                    System.out.println("Exited!");
                    exit = true;
                    break;
            }
        }
    }


    public static void showMenu() {
        System.out.println("-----------Menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort student by gpa.");
        System.out.println("5. Sort student by name.");
        System.out.println("6. Show student.");
        System.out.println("0. Exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    public static void showMenu2(){
        System.out.println("1. Back menu");
        System.out.println("2. Exit.");
    }
}