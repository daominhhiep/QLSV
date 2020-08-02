import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFile {
    private static final String STUDENT_FILE_NAME = "student.txt";

    public void write(List<Student> studentList) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(STUDENT_FILE_NAME));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fileOutputStream);
            closeStream(objectOutputStream);
        }
    }


    public List<Student> read() {
        List<Student> studentList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(STUDENT_FILE_NAME));
            objectInputStream = new ObjectInputStream(fileInputStream);
            studentList = (List<Student>) objectInputStream.readObject();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } finally {
            closeStream(fileInputStream);
            closeStream(objectInputStream);
        }
        return studentList;
    }


    private void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}