package Question1;

import java.util.HashMap;
import java.util.Collection;

public class StudentManager {
    private HashMap<Integer, Student> students = new HashMap<>();

    // Add a new student to the collection
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    // Return a list of all students
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    // Return a student by their id
    public Student getStudentById(int id) {
        return students.get(id);
    }

    // Update the details of a student by their id
    public void updateStudent(int id, String name, int age) {
        Student student = students.get(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
        }
    }

    // Remove a student from the collection by their id
    public void deleteStudent(int id) {
        students.remove(id);
    }
}

