import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Edit extends JFrame implements ActionListener {

    // =========================
    // COLORS
    // =========================

    Color DARK_BLUE = new Color(0, 51, 102);

    Color LIGHT_BLUE =
            new Color(235, 244, 255);

    Color GREEN =
            new Color(40, 167, 69);

    Color RED =
            new Color(220, 53, 69);

    Color GRAY =
            new Color(108, 117, 125);


    // =========================
    // COMPONENTS
    // =========================

    JComboBox<String> studentList;

    JTextField nameField;
    JTextField fatherNameField;
    JTextField dobField;
    JTextField phoneField;
    JTextField emailField;
    JTextField addressField;
    JTextField courseField;
    JTextField yearField;
    JTextField roomField;

    JComboBox<String> genderBox;

    JButton updateButton;
    JButton clearButton;
    JButton backButton;


    // =========================
    // STUDENT DATA
    // =========================

    ArrayList<Student> students =
            new ArrayList<>();


    // =========================
    // CONSTRUCTOR
    // =========================

    public Edit() {

        setTitle("Hostel Management System - Edit Student");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new BorderLayout());

        loadStudentsFromDatabase();

        createHeader();

        createEditPage();

        createFooter();

        setVisible(true);
    }


    // =========================================================
    // HEADER
    // =========================================================

    private void createHeader() {

        JPanel completeHeader =
                new JPanel(
                        new BorderLayout()
                );

        completeHeader.setBackground(
                Color.WHITE
        );


        // =========================
        // POORNIMA IMAGE
        // =========================

        JLabel imageLabel =
                new JLabel();


        try {

            InputStream imageStream =
                    getClass().getResourceAsStream(
                            "/image/poornima.jpeg"
                    );


            if (imageStream != null) {

                byte[] imageBytes =
                        imageStream.readAllBytes();


                ImageIcon originalImage =
                        new ImageIcon(
                                imageBytes
                        );


                Image scaledImage =
                        originalImage
                                .getImage()
                                .getScaledInstance(
                                        600,
                                        80,
                                        Image.SCALE_SMOOTH
                                );


                ImageIcon headerImage =
                        new ImageIcon(
                                scaledImage
                        );


                imageLabel.setIcon(
                        headerImage
                );


                imageLabel.setHorizontalAlignment(
                        SwingConstants.CENTER
                );


                imageLabel.setVerticalAlignment(
                        SwingConstants.CENTER
                );

            } else {

                imageLabel.setText(
                        "Poornima Header Image Not Found"
                );


                imageLabel.setForeground(
                        Color.RED
                );


                imageLabel.setHorizontalAlignment(
                        SwingConstants.CENTER
                );
            }


        } catch (Exception e) {

            imageLabel.setText(
                    "Unable to Load Poornima Header"
            );


            imageLabel.setForeground(
                    Color.RED
            );


            imageLabel.setHorizontalAlignment(
                    SwingConstants.CENTER
            );
        }


        // =========================
        // BLUE TITLE LINE
        // =========================

        JPanel titleBar =
                new JPanel(
                        new BorderLayout()
                );


        // Same colour as footer
        titleBar.setBackground(
                DARK_BLUE
        );


        titleBar.setPreferredSize(
                new Dimension(
                        100,
                        42
                )
        );


        JLabel titleLabel =
                new JLabel(
                        "HOSTEL MANAGEMENT SYSTEM"
                );


        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        17
                )
        );


        titleLabel.setForeground(
                Color.WHITE
        );


        titleLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        titleLabel.setVerticalAlignment(
                SwingConstants.CENTER
        );


        titleBar.add(
                titleLabel,
                BorderLayout.CENTER
        );


        // =========================
        // ADD HEADER
        // =========================

        completeHeader.add(
                imageLabel,
                BorderLayout.CENTER
        );


        completeHeader.add(
                titleBar,
                BorderLayout.SOUTH
        );


        completeHeader.setPreferredSize(
                new Dimension(
                        100,
                        122
                )
        );


        add(
                completeHeader,
                BorderLayout.NORTH
        );
    }


    // =========================================================
    // EDIT PAGE
    // =========================================================

    private void createEditPage() {

        JPanel mainPanel =
                new JPanel(
                        new GridBagLayout()
                );


        mainPanel.setBackground(
                LIGHT_BLUE
        );


        JPanel card =
                new JPanel(null);


        card.setPreferredSize(
                new Dimension(
                        950,
                        650
                )
        );


        card.setBackground(
                Color.WHITE
        );


        card.setBorder(
                BorderFactory.createLineBorder(
                        DARK_BLUE,
                        2
                )
        );


        // =========================
        // TITLE
        // =========================

        JLabel title =
                new JLabel(
                        "EDIT STUDENT DETAILS"
                );


        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );


        title.setForeground(
                DARK_BLUE
        );


        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        title.setBounds(
                190,
                20,
                570,
                40
        );


        card.add(title);


        // =========================
        // SELECT STUDENT
        // =========================

        JLabel selectLabel =
                createLabel(
                        "Select Student:"
                );


        selectLabel.setBounds(
                70,
                80,
                130,
                30
        );


        card.add(selectLabel);


        studentList =
                new JComboBox<>();


        studentList.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );


        studentList.setBounds(
                210,
                78,
                400,
                38
        );


        studentList.addItem(
                "Select a Student"
        );

        for (Student s : students) {

            studentList.addItem(
                    s.id + " - " + s.name
            );
        }

        studentList.addActionListener(
                e -> loadSelectedStudent()
        );

        card.add(studentList);

        // =========================
        // STUDENT NAME
        // =========================

        JLabel nameLabel =
                createLabel(
                        "Student Name:"
                );


        nameLabel.setBounds(
                70,
                145,
                120,
                30
        );


        card.add(nameLabel);


        nameField =
                createTextField();


        nameField.setBounds(
                190,
                143,
                250,
                35
        );


        card.add(nameField);


        // =========================
        // FATHER NAME
        // =========================

        JLabel fatherLabel =
                createLabel(
                        "Father's Name:"
                );


        fatherLabel.setBounds(
                490,
                145,
                120,
                30
        );


        card.add(fatherLabel);


        fatherNameField =
                createTextField();


        fatherNameField.setBounds(
                620,
                143,
                230,
                35
        );


        card.add(fatherNameField);


        // =========================
        // GENDER
        // =========================

        JLabel genderLabel =
                createLabel(
                        "Gender:"
                );


        genderLabel.setBounds(
                70,
                200,
                120,
                30
        );


        card.add(genderLabel);


        genderBox =
                new JComboBox<>(
                        new String[]{
                                "Select Gender",
                                "Male",
                                "Female",
                                "Other"
                        }
                );


        genderBox.setBounds(
                190,
                198,
                250,
                35
        );


        card.add(genderBox);


        // =========================
        // DATE OF BIRTH
        // =========================

        JLabel dobLabel =
                createLabel(
                        "Date of Birth:"
                );


        dobLabel.setBounds(
                490,
                200,
                120,
                30
        );


        card.add(dobLabel);


        dobField =
                createTextField();


        dobField.setBounds(
                620,
                198,
                230,
                35
        );


        card.add(dobField);


        // =========================
        // PHONE
        // =========================

        JLabel phoneLabel =
                createLabel(
                        "Phone:"
                );


        phoneLabel.setBounds(
                70,
                255,
                120,
                30
        );


        card.add(phoneLabel);


        phoneField =
                createTextField();


        phoneField.setBounds(
                190,
                253,
                250,
                35
        );


        card.add(phoneField);


        // =========================
        // EMAIL
        // =========================

        JLabel emailLabel =
                createLabel(
                        "Email:"
                );


        emailLabel.setBounds(
                490,
                255,
                120,
                30
        );


        card.add(emailLabel);


        emailField =
                createTextField();


        emailField.setBounds(
                620,
                253,
                230,
                35
        );


        card.add(emailField);


        // =========================
        // ADDRESS
        // =========================

        JLabel addressLabel =
                createLabel(
                        "Address:"
                );


        addressLabel.setBounds(
                70,
                310,
                120,
                30
        );


        card.add(addressLabel);


        addressField =
                createTextField();


        addressField.setBounds(
                190,
                308,
                660,
                35
        );


        card.add(addressField);


        // =========================
        // COURSE
        // =========================

        JLabel courseLabel =
                createLabel(
                        "Course:"
                );


        courseLabel.setBounds(
                70,
                365,
                120,
                30
        );


        card.add(courseLabel);


        courseField =
                createTextField();


        courseField.setBounds(
                190,
                363,
                250,
                35
        );


        card.add(courseField);


        // =========================
        // YEAR
        // =========================

        JLabel yearLabel =
                createLabel(
                        "Year:"
                );


        yearLabel.setBounds(
                490,
                365,
                120,
                30
        );


        card.add(yearLabel);


        yearField =
                createTextField();


        yearField.setBounds(
                620,
                363,
                230,
                35
        );


        card.add(yearField);


        // =========================
        // ROOM NUMBER
        // =========================

        JLabel roomLabel =
                createLabel(
                        "Room Number:"
                );


        roomLabel.setBounds(
                70,
                420,
                120,
                30
        );


        card.add(roomLabel);


        roomField =
                createTextField();


        roomField.setBounds(
                190,
                418,
                250,
                35
        );


        card.add(roomField);


        // =====================================================
        // UPDATE BUTTON
        // =====================================================

        updateButton =
                createButton(
                        "UPDATE",
                        GREEN
                );


        updateButton.setBounds(
                170,
                500,
                160,
                45
        );


        updateButton.addActionListener(
                this
        );


        card.add(updateButton);


        // =====================================================
        // BACK BUTTON
        // =====================================================

        backButton =
                createButton(
                        "BACK",
                        GRAY
                );


        backButton.setBounds(
                395,
                500,
                160,
                45
        );


        backButton.addActionListener(
                this
        );


        card.add(backButton);


        // =====================================================
        // CLEAR BUTTON
        // =====================================================

        clearButton =
                createButton(
                        "CLEAR",
                        RED
                );


        clearButton.setBounds(
                620,
                500,
                160,
                45
        );


        clearButton.addActionListener(
                this
        );


        card.add(clearButton);


        mainPanel.add(
                card
        );


        add(
                mainPanel,
                BorderLayout.CENTER
        );
    }
    private void loadStudentsFromDatabase() {

        students.clear();
        String sql = "SELECT id, name, father_name, gender, dob, "
                + "phone, email, address, course, study_year, room "
                + "FROM students";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Student student = new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("father_name"),
                        rs.getString("gender"),
                        rs.getString("dob"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("course"),
                        rs.getString("study_year"),
                        rs.getString("room")
                );

                students.add(student);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to load students from database.\n"
                            + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // FOOTER
    // =========================================================

    private void createFooter() {

        JPanel footer =
                new JPanel(
                        new BorderLayout()
                );


        footer.setBackground(
                DARK_BLUE
        );


        footer.setPreferredSize(
                new Dimension(
                        100,
                        35
                )
        );


        JLabel footerText =
                new JLabel(
                        "Created by Kanishka | 2026"
                );


        footerText.setForeground(
                Color.WHITE
        );


        footerText.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );


        footerText.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        footer.add(
                footerText,
                BorderLayout.CENTER
        );


        add(
                footer,
                BorderLayout.SOUTH
        );
    }


    // =========================================================
    // LABEL
    // =========================================================

    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(
                        text
                );


        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        label.setForeground(
                Color.BLACK
        );


        return label;
    }


    // =========================================================
    // TEXT FIELD
    // =========================================================

    private JTextField createTextField() {

        JTextField field =
                new JTextField();


        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );


        return field;
    }


    // =========================================================
    // BUTTON
    // =========================================================

    private JButton createButton(
            String text,
            Color color
    ) {

        JButton button =
                new JButton(
                        text
                );


        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        button.setForeground(
                Color.WHITE
        );


        button.setBackground(
                color
        );


        button.setFocusPainted(
                false
        );


        button.setBorderPainted(
                false
        );


        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );


        return button;
    }


    // =========================================================
    // SAMPLE STUDENTS
    // =========================================================

    private void addSampleStudents() {

        students.add(
                new Student(
                        "STU001",
                        "Rahul Sharma",
                        "Rakesh Sharma",
                        "Male",
                        "15/05/2006",
                        "9876543210",
                        "rahul@gmail.com",
                        "Jaipur, Rajasthan",
                        "B.Tech CSE",
                        "2nd Year",
                        "101"
                )
        );


        students.add(
                new Student(
                        "STU002",
                        "Priya Singh",
                        "Rajesh Singh",
                        "Female",
                        "20/08/2005",
                        "9876501234",
                        "priya@gmail.com",
                        "Delhi",
                        "B.Tech IT",
                        "3rd Year",
                        "102"
                )
        );


        students.add(
                new Student(
                        "STU003",
                        "Aman Verma",
                        "Suresh Verma",
                        "Male",
                        "10/01/2007",
                        "9876512345",
                        "aman@gmail.com",
                        "Lucknow",
                        "B.Tech CSE",
                        "1st Year",
                        "103"
                )
        );


        students.add(
                new Student(
                        "STU004",
                        "Neha Gupta",
                        "Anil Gupta",
                        "Female",
                        "12/11/2006",
                        "9876523456",
                        "neha@gmail.com",
                        "Agra",
                        "BCA",
                        "2nd Year",
                        "104"
                )
        );
    }


    // =========================================================
    // LOAD STUDENT
    // =========================================================

    private void loadSelectedStudent() {

        int index =
                studentList.getSelectedIndex();


        if (index <= 0) {

            clearDetails();

            return;
        }


        Student student =
                students.get(
                        index - 1
                );


        nameField.setText(
                student.name
        );


        fatherNameField.setText(
                student.fatherName
        );


        genderBox.setSelectedItem(
                student.gender
        );


        dobField.setText(
                student.dob
        );


        phoneField.setText(
                student.phone
        );


        emailField.setText(
                student.email
        );


        addressField.setText(
                student.address
        );


        courseField.setText(
                student.course
        );


        yearField.setText(
                student.year
        );


        roomField.setText(
                student.room
        );
    }


    // =========================================================
    // UPDATE STUDENT
    // =========================================================

    // =========================================================
// UPDATE STUDENT IN DATABASE
// =========================================================

    private void updateStudent() {

        int index = studentList.getSelectedIndex();

        if (index <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a student first.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Student student = students.get(index - 1);

        String name = nameField.getText().trim();
        String fatherName = fatherNameField.getText().trim();
        String gender = genderBox.getSelectedItem().toString();
        String dob = dobField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String address = addressField.getText().trim();
        String course = courseField.getText().trim();
        String year = yearField.getText().trim();
        String room = roomField.getText().trim();

        // VALIDATION

        if (name.isEmpty()
                || fatherName.isEmpty()
                || dob.isEmpty()
                || phone.isEmpty()
                || email.isEmpty()
                || course.isEmpty()
                || year.isEmpty()
                || room.isEmpty()
                || gender.equals("Select Gender")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all required fields.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (!phone.matches("\\d{10}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Phone number must contain exactly 10 digits.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            phoneField.requestFocus();

            return;
        }

        String sql = "UPDATE students SET "
                + "name = ?, "
                + "father_name = ?, "
                + "gender = ?, "
                + "dob = ?, "
                + "phone = ?, "
                + "email = ?, "
                + "course = ?, "
                + "study_year = ?, "
                + "room = ? "
                + "WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setString(2, fatherName);
            ps.setString(3, gender);
            ps.setString(4, dob);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, course);
            ps.setString(8, year);
            ps.setString(9, room);
            ps.setString(10, student.id);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {

                // Update Java object after database success

                student.name = name;
                student.fatherName = fatherName;
                student.gender = gender;
                student.dob = dob;
                student.phone = phone;
                student.email = email;
                student.course = course;
                student.year = year;
                student.room = room;

                // Refresh selected student's name in combo box

                studentList.removeItemAt(index);

                studentList.insertItemAt(
                        student.id + " - " + student.name,
                        index
                );

                studentList.setSelectedIndex(index);

                JOptionPane.showMessageDialog(
                        this,
                        "Student details updated successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student not found in database. No changes were saved.",
                        "Update Failed",
                        JOptionPane.WARNING_MESSAGE
                );
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to update student details.\n"
                            + "Error: " + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }




    // =========================================================
    // CLEAR
    // =========================================================

    private void clearDetails() {

        nameField.setText("");

        fatherNameField.setText("");

        genderBox.setSelectedIndex(
                0
        );

        dobField.setText("");

        phoneField.setText("");

        emailField.setText("");

        addressField.setText("");

        courseField.setText("");

        yearField.setText("");

        roomField.setText("");
    }


    // =========================================================
    // ACTION LISTENER
    // =========================================================

    @Override
    public void actionPerformed(
            ActionEvent e
    ) {

        if (
                e.getSource() ==
                        updateButton
        ) {

            updateStudent();
        }


        else if (
                e.getSource() ==
                        clearButton
        ) {

            studentList.setSelectedIndex(
                    0
            );

            clearDetails();
        }


        else if (
                e.getSource() ==
                        backButton
        ) {

            dispose();
        }
    }


    // =========================================================
    // STUDENT CLASS
    // =========================================================

    static class Student {

        String id;
        String name;
        String fatherName;
        String gender;
        String dob;
        String phone;
        String email;
        String address;
        String course;
        String year;
        String room;


        Student(
                String id,
                String name,
                String fatherName,
                String gender,
                String dob,
                String phone,
                String email,
                String address,
                String course,
                String year,
                String room
        ) {

            this.id = id;
            this.name = name;
            this.fatherName = fatherName;
            this.gender = gender;
            this.dob = dob;
            this.phone = phone;
            this.email = email;
            this.address = address;
            this.course = course;
            this.year = year;
            this.room = room;
        }
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> new Edit()
        );
    }
}