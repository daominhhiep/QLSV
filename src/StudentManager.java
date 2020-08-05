import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class StudentManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Student> studentList;
    private StudentFile studentFile;

    public StudentManager() {
        studentFile = new StudentFile();
        studentList = studentFile.read();
    }


    public void add() {
        int id = studentList.size();
        if (id > 0) {
            id += 1;
        } else {
            id = 1;
        }
        System.out.println("Id sinh viên = " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        float gpa = inputGpa();
        Student student = new Student(id, name, age, address, gpa);
        studentList.add(student);
        studentFile.write(studentList);
    }


    public void edit(int id) {
        boolean isExisted = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                isExisted = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setGpa(inputGpa());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("Id = %d không tồn tại.\n", id);
        } else {
            studentFile.write(studentList);
        }
    }


    public void delete(int id) {
        Student student = null;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if (student != null) {
            studentList.remove(student);
            studentFile.write(studentList);
        } else {
            System.out.printf("Id = %d không tồn tại.\n", id);
        }
    }


    public void sortStudentByName() {
        Collections.sort(studentList, new SortStudentByName());
    }


    public void sortStudentByGPA() {
        Collections.sort(studentList, new SortStudentByGPA());
    }


    public void show() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("| %5s | ", "ID");
        System.out.printf("%20s | ", "Tên sinh viên");
        System.out.printf("%5s | ", "Tuổi");
        System.out.printf("%7s","");
        System.out.printf("%-13s | ", "Địa chỉ");
        System.out.printf("%10s |", "Điểm TB");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        for (Student student : studentList) {
            System.out.printf("| %5d | ", student.getId());
            System.out.printf("%20s | ", student.getName());
            System.out.printf("%5d | ", student.getAge());
            System.out.printf("%20s | ", student.getAddress());
            System.out.printf("%10s |", student.getGpa());
            System.out.println();
            System.out.println("----------------------------------------------------------------------------");        }
    }


    public int inputId() {
        System.out.print("Nhập vào id sinh viên: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.err.print("Không hợp lệ! Nhập lại id sinh viên: ");
            }
        }
    }

    private String inputName() {
        System.out.print("Họ và tên sinh viên: ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.print("Địa chỉ: ");
        return scanner.nextLine();
    }


    private byte inputAge() {
        System.out.print("Tuổi sinh viên: ");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.err.print("Không hợp lệ! Nhập lại tuổi sinh viên: ");
            }
        }
    }

    private float inputGpa() {
        System.out.print("Điểm trung bình: ");
        while (true) {
            try {
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa < 0.0 && gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.err.print("Không hợp lệ! Nhập lại điểm trung bình sinh viên: ");
            }
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}