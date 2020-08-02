import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId;


        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentManager.add();
                    System.out.println("-----Done!-----");
                    showMenu();
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
                    System.out.println("---Đã sắp xếp xong---");
                    break;
                case "5":
                    studentManager.sortStudentByName();
                    System.out.println("---Đã sắp xếp xong---");
                    break;
                case "6":
                    studentManager.show();
                    break;
                case "0":
                    System.out.println("Exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("Không hợp lệ! Vui lòng nhập lại!");
                    showMenu2();
                    String choose2 = scanner.nextLine();
                    switch (choose2) {
                        case "0":
                            System.out.println("Exited!");
                            exit = true;
                            break;
                        default:
                            showMenu();
                            break;
                    }
                    if (exit) {
                        break;
                    }
            }
        }
    }


    public static void showMenu() {
        System.out.println("-----------Menu------------");
        System.out.println("1. Thêm thông tin sinh viên.");
        System.out.println("2. Sửa thông tin sinh viên theo id.");
        System.out.println("3. Xóa thông tin sinh viên theo id.");
        System.out.println("4. Sắp xếp danh sách học viên theo điểm trung bình.");
        System.out.println("5. Sắp xếp danh sách học viên theo họ tên.");
        System.out.println("6. Hiển thị danh sách học viên.");
        System.out.println("0. Thoát.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

    public static void showMenu2() {
        System.out.println("---------------------------");
        System.out.println("1. Nhập số bất kỳ để trở lại menu");
        System.out.println("0. Thoát.");
        System.out.print("Please choose: ");
    }
}