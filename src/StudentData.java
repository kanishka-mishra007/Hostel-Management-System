import java.util.ArrayList;

public class StudentData {

    public static class Student {

        public String studentId;
        public String name;
        public String fatherName;
        public String dob;
        public String phone;
        public String email;
        public String course;
        public String year;
        public String room;
        public String address;
        public String gender;
        public String hostel;
        public String department;

        public Student(
                String studentId,
                String name,
                String fatherName,
                String dob,
                String phone,
                String email,
                String course,
                String year,
                String room,
                String address,
                String gender,
                String hostel,
                String department) {

            this.studentId = studentId;
            this.name = name;
            this.fatherName = fatherName;
            this.dob = dob;
            this.phone = phone;
            this.email = email;
            this.course = course;
            this.year = year;
            this.room = room;
            this.address = address;
            this.gender = gender;
            this.hostel = hostel;
            this.department = department;
        }
    }

    public static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
    }
}