
import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add extends JFrame {

    // =========================
    // TEXT FIELDS
    // =========================

    JTextField idField;
    JTextField nameField;
    JTextField fatherField;
    JTextField dobField;
    JTextField phoneField;
    JTextField emailField;
    JTextField addressField;
    JTextField courseField;
    JTextField yearField;
    JTextField roomField;

    JComboBox<String> genderBox;


    // =========================
    // COLORS
    // =========================

    private final Color darkBlue =
            new Color(0, 51, 102);

    private final Color lightBackground =
            new Color(240, 246, 252);

    private final Color borderColor =
            new Color(205, 215, 225);


    // =========================
    // CONSTRUCTOR
    // =========================

    public Add() {

        setTitle(
                "Hostel Management System - Add Student"
        );

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setSize(
                950,
                700
        );

        setLocationRelativeTo(null);

        setLayout(
                new BorderLayout()
        );


        // =========================
        // HEADER
        // =========================

        createHeader();


        // =========================
        // MAIN PANEL
        // =========================

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(
                lightBackground
        );

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        18,
                        35,
                        15,
                        35
                )
        );


        // =========================
        // TITLE
        // =========================

        JLabel title =
                new JLabel(
                        "ADD STUDENT DETAILS"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27
                )
        );

        title.setForeground(
                darkBlue
        );

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        0,
                        0,
                        18,
                        0
                )
        );

        mainPanel.add(
                title,
                BorderLayout.NORTH
        );


        // =========================
        // FORM PANEL
        // =========================

        JPanel formPanel =
                new JPanel(
                        new GridBagLayout()
                );

        formPanel.setBackground(
                Color.WHITE
        );

        formPanel.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                borderColor,
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                22,
                                30,
                                22,
                                30
                        )
                )
        );


        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        7,
                        12,
                        7,
                        12
                );

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weighty = 0;


        // =========================
        // ROW 1
        // =========================

        addFormRow(
                formPanel,
                gbc,
                0,
                0,
                "Student ID",
                idField = createTextField(),
                "Student Name",
                nameField = createTextField()
        );


        // =========================
        // ROW 2
        // =========================

        addFormRow(
                formPanel,
                gbc,
                1,
                0,
                "Father's Name",
                fatherField = createTextField(),
                "Gender",
                genderBox = createGenderBox()
        );


        // =========================
        // ROW 3
        // =========================

        addFormRow(
                formPanel,
                gbc,
                2,
                0,
                "Date of Birth",
                dobField = createTextField(),
                "Phone",
                phoneField = createTextField()
        );


        // =========================
        // ROW 4
        // =========================

        addFormRow(
                formPanel,
                gbc,
                3,
                0,
                "Email",
                emailField = createTextField(),
                "Course",
                courseField = createTextField()
        );


        // =========================
        // ROW 5
        // =========================

        addFormRow(
                formPanel,
                gbc,
                4,
                0,
                "Year",
                yearField = createTextField(),
                "Room No.",
                roomField = createTextField()
        );
        // =========================
// ROW 6
// =========================

        addFormRow(
                formPanel,
                gbc,
                5,
                0,
                "Address",
                addressField = createTextField(),
                "",
                new JLabel("")
        );


        mainPanel.add(
                formPanel,
                BorderLayout.CENTER
        );


        // =========================
        // BUTTON PANEL
        // =========================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                18,
                                12
                        )
                );

        buttonPanel.setBackground(
                lightBackground
        );


        // =========================
        // BACK BUTTON
        // =========================

        JButton backButton =
                new JButton(
                        "← BACK"
                );

        styleButton(
                backButton,
                new Color(
                        108,
                        117,
                        125
                ),
                120
        );

        backButton.addActionListener(
                e -> dispose()
        );


        // =========================
        // CLEAR BUTTON
        // =========================

        JButton clearButton =
                new JButton(
                        "CLEAR"
                );

        styleButton(
                clearButton,
                new Color(
                        220,
                        53,
                        69
                ),
                120
        );

        clearButton.addActionListener(
                e -> clearFields()
        );


        // =========================
        // ADD BUTTON
        // =========================

        JButton addButton =
                new JButton(
                        "ADD STUDENT"
                );

        styleButton(
                addButton,
                new Color(
                        0,
                        102,
                        204
                ),
                155
        );

        addButton.addActionListener(
                e -> addStudent()
        );


        buttonPanel.add(
                backButton
        );

        buttonPanel.add(
                clearButton
        );

        buttonPanel.add(
                addButton
        );


        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );


        // =========================
        // ADD MAIN PANEL
        // =========================

        add(
                mainPanel,
                BorderLayout.CENTER
        );


        // =========================
        // FOOTER
        // =========================

        createFooter();
    }


    // =========================
    // CREATE TEXT FIELD
    // =========================

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

        field.setPreferredSize(
                new Dimension(
                        250,
                        32
                )
        );

        field.setMinimumSize(
                new Dimension(
                        150,
                        32
                )
        );

        field.setMaximumSize(
                new Dimension(
                        350,
                        32
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        190,
                                        200,
                                        210
                                )
                        ),

                        BorderFactory.createEmptyBorder(
                                5,
                                9,
                                5,
                                9
                        )
                )
        );

        return field;
    }


    // =========================
    // CREATE GENDER BOX
    // =========================

    private JComboBox<String> createGenderBox() {

        JComboBox<String> box =
                new JComboBox<>(
                        new String[]{
                                "Select Gender",
                                "Male",
                                "Female",
                                "Other"
                        }
                );

        box.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        box.setPreferredSize(
                new Dimension(
                        250,
                        32
                )
        );

        return box;
    }


    // =========================
    // ADD FORM ROW
    // =========================

    private void addFormRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            int column,
            String label1,
            JComponent field1,
            String label2,
            JComponent field2
    ) {

        // First label
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;

        panel.add(
                createLabel(label1),
                gbc
        );


        // First field
        gbc.gridx = 1;
        gbc.weightx = 1;

        panel.add(
                field1,
                gbc
        );


        // Second label
        gbc.gridx = 2;
        gbc.weightx = 0;

        panel.add(
                createLabel(label2),
                gbc
        );


        // Second field
        gbc.gridx = 3;
        gbc.weightx = 1;

        panel.add(
                field2,
                gbc
        );
    }


    // =========================
    // LABEL
    // =========================

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
                new Color(
                        50,
                        50,
                        50
                )
        );

        return label;
    }


    // =========================
    // BUTTON STYLE
    // =========================

    private void styleButton(
            JButton button,
            Color background,
            int width
    ) {

        button.setPreferredSize(
                new Dimension(
                        width,
                        43
                )
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        button.setBackground(
                background
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFocusPainted(
                false
        );

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        5,
                        15,
                        5,
                        15
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }


    // =========================
    // HEADER
    // =========================

    private void createHeader() {

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(
                Color.WHITE
        );


        JLabel imageLabel =
                new JLabel();


        try {

            ImageIcon originalImage =
                    new ImageIcon(
                            getClass().getResource(
                                    "/image/poornima.jpeg"
                            )
                    );


            Image scaledImage =
                    originalImage.getImage()
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

        } catch (Exception e) {

            imageLabel.setText(
                    "POORNIMA"
            );

            imageLabel.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            25
                    )
            );
        }


        imageLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        header.add(
                imageLabel,
                BorderLayout.CENTER
        );


        // =========================
        // BLUE LINE
        // =========================

        JLabel blueLine =
                new JLabel(
                        "HOSTEL MANAGEMENT SYSTEM"
                );

        blueLine.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        blueLine.setForeground(
                Color.WHITE
        );

        blueLine.setBackground(
                darkBlue
        );

        blueLine.setOpaque(
                true
        );

        blueLine.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        blueLine.setVerticalAlignment(
                SwingConstants.CENTER
        );

        blueLine.setPreferredSize(
                new Dimension(
                        100,
                        38
                )
        );


        header.add(
                blueLine,
                BorderLayout.SOUTH
        );


        add(
                header,
                BorderLayout.NORTH
        );
    }


    // =========================
    // ADD STUDENT + VALIDATION
    // =========================

    private void addStudent() {

        // =========================
        // STUDENT ID
        // =========================

        String id =
                idField.getText().trim();

        if (id.isEmpty()) {

            showError(
                    "Please enter Student ID."
            );

            idField.requestFocus();

            return;
        }

        if (!id.matches("(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]+")) {

            showError(
                    "Invalid Student ID!\n"
                            + "Student ID must contain both letters and numbers.\n"
                            + "Example: STU001"
            );

            idField.requestFocus();

            return;
        }


        // =========================
        // STUDENT NAME
        // =========================

        String name =
                nameField.getText().trim();

        if (name.isEmpty()) {

            showError(
                    "Please enter Student Name."
            );

            nameField.requestFocus();

            return;
        }

        if (!name.matches("[a-zA-Z ]+")) {

            showError(
                    "Invalid Student Name!\n"
                            + "Name must contain letters and spaces only."
            );

            nameField.requestFocus();

            return;
        }


        // =========================
        // FATHER'S NAME
        // =========================

        String father =
                fatherField.getText().trim();

        if (father.isEmpty()) {

            showError(
                    "Please enter Father's Name."
            );

            fatherField.requestFocus();

            return;
        }

        if (!father.matches("[a-zA-Z ]+")) {

            showError(
                    "Invalid Father's Name!\n"
                            + "Father's Name must contain letters and spaces only."
            );

            fatherField.requestFocus();

            return;
        }


        // =========================
        // GENDER
        // =========================

        if (genderBox.getSelectedIndex() == 0) {

            showError(
                    "Please select Gender."
            );

            genderBox.requestFocus();

            return;
        }


        // =========================
        // DATE OF BIRTH
        // =========================

        String dob =
                dobField.getText().trim();

        if (dob.isEmpty()) {

            showError(
                    "Please enter Date of Birth.\n"
                            + "Use format: DD-MM-YYYY"
            );

            dobField.requestFocus();

            return;
        }

        if (!dob.matches("\\d{2}-\\d{2}-\\d{4}")) {

            showError(
                    "Invalid Date of Birth!\n"
                            + "Please enter DOB in DD-MM-YYYY format.\n"
                            + "Example: 26-03-2007"
            );

            dobField.requestFocus();

            return;
        }


        // =========================
        // PHONE NUMBER
        // =========================

        String phone =
                phoneField.getText().trim();

        if (phone.isEmpty()) {

            showError(
                    "Please enter Phone Number."
            );

            phoneField.requestFocus();

            return;
        }

        if (!phone.matches("\\d{10}")) {

            showError(
                    "Invalid Phone Number!\n"
                            + "Phone Number must contain exactly 10 digits."
            );

            phoneField.requestFocus();

            return;
        }


        // =========================
        // EMAIL
        // =========================

        String email =
                emailField.getText().trim();

        if (email.isEmpty()) {

            showError(
                    "Please enter Email Address."
            );

            emailField.requestFocus();

            return;
        }

        String emailPattern =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!Pattern.matches(
                emailPattern,
                email
        )) {

            showError(
                    "Invalid Email Address!\n"
                            + "Please enter a valid email.\n"
                            + "Example: student@gmail.com"
            );

            emailField.requestFocus();

            return;
        }
// =========================
// ADDRESS
// =========================

        String address =
                addressField.getText().trim();

        if (address.isEmpty()) {

            showError(
                    "Please enter Address."
            );

            addressField.requestFocus();

            return;
        }

        if (address.length() > 150) {

            showError(
                    "Address cannot exceed 150 characters."
            );

            addressField.requestFocus();

            return;
        }

        // =========================
        // COURSE
        // =========================

        String course =
                courseField.getText().trim();

        if (course.isEmpty()) {

            showError(
                    "Please enter Course."
            );

            courseField.requestFocus();

            return;
        }

        if (!course.matches("[a-zA-Z ]+")) {

            showError(
                    "Invalid Course!\n"
                            + "Course must contain letters and spaces only."
            );

            courseField.requestFocus();

            return;
        }


        // =========================
        // YEAR
        // =========================

        String year =
                yearField.getText().trim();

        if (year.isEmpty()) {

            showError(
                    "Please enter Year."
            );

            yearField.requestFocus();

            return;
        }
        if (!year.matches("(?i)(1st|2nd|3rd|4th)\\s+Year")) {

            showError(
                    "Invalid Year!\n"
                            + "Please enter 1st Year, 2nd Year, "
                            + "3rd Year or 4th Year."
            );

            yearField.requestFocus();

            return;
        }

        // =========================
        // ROOM NUMBER
        // =========================

        String room =
                roomField.getText().trim();

        if (room.isEmpty()) {

            showError(
                    "Please enter Room Number."
            );

            roomField.requestFocus();

            return;
        }

        if (!room.matches("\\d+")) {

            showError(
                    "Invalid Room Number!\n"
                            + "Room Number must contain numbers only."
            );

            roomField.requestFocus();

            return;
        }


        // =========================
        // SUCCESS
        // =========================
        String sql = "INSERT INTO students "
                + "(id, name, father_name, gender, dob, phone, "
                + "email, address, course, study_year, room) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, father);
            ps.setString(4, genderBox.getSelectedItem().toString());
            ps.setString(5, dob);
            ps.setString(6, phone);
            ps.setString(7, email);
            ps.setString(8, address);
            ps.setString(9, course);
            ps.setString(10, year);
            ps.setString(11, room);

            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows);
            if (rows > 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Student added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                clearFields();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to save student details in database.\n"
                            + "Error: " + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =========================
    // ERROR POPUP
    // =========================

    private void showError(
            String message
    ) {

        JOptionPane.showMessageDialog(
                this,
                message,
                "Invalid Input",
                JOptionPane.WARNING_MESSAGE
        );
    }


    // =========================
    // CLEAR FIELDS
    // =========================

    private void clearFields() {

        idField.setText("");

        nameField.setText("");

        fatherField.setText("");

        dobField.setText("");

        phoneField.setText("");

        emailField.setText("");

        addressField.setText("");

        courseField.setText("");

        yearField.setText("");

        roomField.setText("");

        genderBox.setSelectedIndex(
                0
        );
    }


    // =========================
    // FOOTER
    // =========================

    private void createFooter() {

        JPanel footer =
                new JPanel(
                        new BorderLayout()
                );

        footer.setBackground(
                darkBlue
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


    // =========================
    // MAIN
    // =========================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> {

                    Add addPage =
                            new Add();

                    addPage.setVisible(
                            true
                    );
                }
        );
    }
}

