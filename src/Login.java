import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;

    JButton loginButton;
    JButton cancelButton;
    JButton eyeButton;

    JLabel forgotLabel;

    // =========================================================
    // CURRENT PASSWORD
    // =========================================================

    String savedPassword = "Hostel@123";

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Login() {

        // =================================================
        // WINDOW
        // =================================================

        setTitle("Hostel Management System");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new BorderLayout());

        // =================================================
        // HEADER
        // =================================================

        JPanel headerPanel =
                new JPanel(new GridBagLayout());

        headerPanel.setBackground(Color.WHITE);

        JLabel headerLabel = new JLabel();

        // =================================================
        // HEADER IMAGE
        // =================================================
        // Image location:
        // src/image/poornima.jpeg
        // =================================================

        ImageIcon originalImage =
                new ImageIcon(
                        Login.class.getResource(
                                "/image/poornima.jpeg"
                        )
                );

        Image scaledImage =
                originalImage.getImage().getScaledInstance(
                        600,
                        100,
                        Image.SCALE_SMOOTH
                );

        ImageIcon headerImage =
                new ImageIcon(scaledImage);

        headerLabel.setIcon(headerImage);

        headerLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        headerLabel.setVerticalAlignment(
                SwingConstants.CENTER
        );

        headerPanel.setPreferredSize(
                new Dimension(80, 110)
        );

        headerPanel.add(headerLabel);

        add(
                headerPanel,
                BorderLayout.NORTH
        );

        // =================================================
        // MAIN BACKGROUND
        // =================================================

        JPanel mainPanel =
                new JPanel(new GridBagLayout());

        mainPanel.setBackground(
                new Color(225, 238, 255)
        );

        // =================================================
        // LOGIN CARD
        // =================================================

        JPanel loginCard =
                new JPanel();

        loginCard.setPreferredSize(
                new Dimension(500, 400)
        );

        loginCard.setBackground(Color.WHITE);

        loginCard.setLayout(null);

        // =================================================
        // LOGIN CARD BORDER
        // =================================================

        loginCard.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(0, 70, 150),
                                2
                        ),

                        BorderFactory.createEmptyBorder(
                                10,
                                10,
                                10,
                                10
                        )
                )
        );

        // =================================================
        // TITLE
        // =================================================

        JLabel title =
                new JLabel(
                        "HOSTEL MANAGEMENT SYSTEM"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        title.setForeground(
                new Color(0, 51, 153)
        );

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        title.setBounds(
                25,
                25,
                450,
                40
        );

        loginCard.add(title);

        // =================================================
        // SUBTITLE
        // =================================================

        JLabel subtitle =
                new JLabel("Admin Login");

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        18
                )
        );

        subtitle.setForeground(
                new Color(90, 90, 90)
        );

        subtitle.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        subtitle.setBounds(
                150,
                65,
                200,
                30
        );

        loginCard.add(subtitle);

        // =================================================
        // USERNAME LABEL
        // =================================================

        JLabel userLabel =
                new JLabel("Username:");

        userLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        userLabel.setBounds(
                55,
                125,
                120,
                30
        );

        loginCard.add(userLabel);

        // =================================================
        // USERNAME FIELD
        // =================================================

        usernameField =
                new JTextField();

        usernameField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        usernameField.setBounds(
                175,
                120,
                250,
                38
        );

        usernameField.setBorder(
                BorderFactory.createLineBorder(
                        new Color(170, 170, 170)
                )
        );

        loginCard.add(usernameField);

        // =================================================
        // PASSWORD LABEL
        // =================================================

        JLabel passwordLabel =
                new JLabel("Password:");

        passwordLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        passwordLabel.setBounds(
                55,
                185,
                120,
                30
        );

        loginCard.add(passwordLabel);

        // =================================================
        // PASSWORD FIELD
        // =================================================

        passwordField =
                new JPasswordField();

        passwordField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        passwordField.setEchoChar('•');

        passwordField.setBorder(null);

        // =================================================
        // EYE BUTTON
        // =================================================

        eyeButton =
                new JButton("👁");

        eyeButton.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        16
                )
        );

        eyeButton.setFocusPainted(false);

        eyeButton.setBorderPainted(false);

        eyeButton.setContentAreaFilled(false);

        eyeButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        // =================================================
        // PASSWORD PANEL
        // =================================================

        JPanel passwordPanel =
                new JPanel(new BorderLayout());

        passwordPanel.setBounds(
                175,
                180,
                250,
                38
        );

        passwordPanel.setBackground(Color.WHITE);

        passwordPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(170, 170, 170)
                )
        );

        passwordPanel.add(
                passwordField,
                BorderLayout.CENTER
        );

        passwordPanel.add(
                eyeButton,
                BorderLayout.EAST
        );

        loginCard.add(passwordPanel);

        // =================================================
        // SHOW / HIDE PASSWORD
        // =================================================

        eyeButton.addActionListener(
                new ActionListener() {

                    boolean passwordVisible = false;

                    @Override
                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        if (passwordVisible) {

                            passwordField.setEchoChar('•');

                            eyeButton.setText("👁");

                            passwordVisible = false;

                        } else {

                            passwordField.setEchoChar((char) 0);

                            eyeButton.setText("🙈");

                            passwordVisible = true;
                        }

                        passwordField.requestFocus();
                    }
                }
        );

        // =================================================
        // FORGOT PASSWORD
        // =================================================

        forgotLabel =
                new JLabel(
                        "<html><u>Forgot Password?</u></html>"
                );

        forgotLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        forgotLabel.setForeground(
                new Color(0, 82, 204)
        );

        forgotLabel.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        forgotLabel.setBounds(
                175,
                225,
                180,
                25
        );

        // =================================================
        // FORGOT PASSWORD ACTION
        // =================================================

        forgotLabel.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            MouseEvent e
                    ) {

                        JDialog dialog =
                                new JDialog(
                                        Login.this,
                                        "Change Password",
                                        true
                                );

                        dialog.setSize(
                                420,
                                270
                        );

                        dialog.setLocationRelativeTo(
                                Login.this
                        );

                        dialog.setLayout(null);

                        // =================================
                        // NEW PASSWORD LABEL
                        // =================================

                        JLabel newPasswordLabel =
                                new JLabel(
                                        "New Password:"
                                );

                        newPasswordLabel.setFont(
                                new Font(
                                        "Segoe UI",
                                        Font.BOLD,
                                        14
                                )
                        );

                        newPasswordLabel.setBounds(
                                35,
                                35,
                                120,
                                30
                        );

                        dialog.add(newPasswordLabel);

                        // =================================
                        // NEW PASSWORD FIELD
                        // =================================

                        JPasswordField newPasswordField =
                                new JPasswordField();

                        newPasswordField.setBounds(
                                160,
                                35,
                                200,
                                30
                        );

                        dialog.add(newPasswordField);

                        // =================================
                        // CONFIRM PASSWORD LABEL
                        // =================================

                        JLabel confirmLabel =
                                new JLabel(
                                        "Confirm Password:"
                                );

                        confirmLabel.setFont(
                                new Font(
                                        "Segoe UI",
                                        Font.BOLD,
                                        14
                                )
                        );

                        confirmLabel.setBounds(
                                35,
                                80,
                                120,
                                30
                        );

                        dialog.add(confirmLabel);

                        // =================================
                        // CONFIRM PASSWORD FIELD
                        // =================================

                        JPasswordField confirmField =
                                new JPasswordField();

                        confirmField.setBounds(
                                160,
                                80,
                                200,
                                30
                        );

                        dialog.add(confirmField);

                        // =================================
                        // CHANGE PASSWORD BUTTON
                        // =================================

                        JButton changeButton =
                                new JButton(
                                        "CHANGE PASSWORD"
                                );

                        changeButton.setFont(
                                new Font(
                                        "Segoe UI",
                                        Font.BOLD,
                                        13
                                )
                        );

                        changeButton.setBounds(
                                105,
                                135,
                                200,
                                40
                        );

                        dialog.add(changeButton);

                        // =================================
                        // CHANGE PASSWORD ACTION
                        // =================================

                        changeButton.addActionListener(
                                new ActionListener() {

                                    @Override
                                    public void actionPerformed(
                                            ActionEvent e
                                    ) {

                                        String newPassword =
                                                new String(
                                                        newPasswordField
                                                                .getPassword()
                                                );

                                        String confirmPassword =
                                                new String(
                                                        confirmField
                                                                .getPassword()
                                                );

                                        // Check empty
                                        if (newPassword.isEmpty()
                                                ||
                                                confirmPassword.isEmpty()) {

                                            JOptionPane.showMessageDialog(
                                                    dialog,
                                                    "Please enter the password."
                                            );

                                            return;
                                        }

                                        // Check minimum length
                                        if (newPassword.length() < 4) {

                                            JOptionPane.showMessageDialog(
                                                    dialog,
                                                    "Password must contain at least 4 characters."
                                            );

                                            return;
                                        }

                                        // Check passwords
                                        if (!newPassword.equals(
                                                confirmPassword
                                        )) {

                                            JOptionPane.showMessageDialog(
                                                    dialog,
                                                    "Passwords do not match!"
                                            );

                                            return;
                                        }

                                        // Save new password
                                        savedPassword =
                                                newPassword;

                                        JOptionPane.showMessageDialog(
                                                dialog,
                                                "Password changed successfully!"
                                        );

                                        dialog.dispose();
                                    }
                                }
                        );

                        dialog.setVisible(true);
                    }
                }
        );

        loginCard.add(forgotLabel);

        // =================================================
        // LOGIN BUTTON
        // =================================================

        loginButton =
                new JButton("LOGIN");

        loginButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        loginButton.setForeground(Color.WHITE);

        loginButton.setBackground(
                new Color(0, 102, 204)
        );

        loginButton.setFocusPainted(false);

        loginButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        loginButton.setBounds(
                85,
                280,
                140,
                42
        );

        loginButton.addActionListener(this);

        loginCard.add(loginButton);

        // =================================================
        // CANCEL BUTTON
        // =================================================

        cancelButton =
                new JButton("CANCEL");

        cancelButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        cancelButton.setForeground(Color.WHITE);

        cancelButton.setBackground(
                new Color(220, 53, 69)
        );

        cancelButton.setFocusPainted(false);

        cancelButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        cancelButton.setBounds(
                265,
                280,
                140,
                42
        );

        cancelButton.addActionListener(this);

        loginCard.add(cancelButton);

        // =================================================
        // FOOTER
        // =================================================

        JLabel footer =
                new JLabel(
                        "Created by Kanishka | 2026"
                );

        footer.setFont(
                new Font(
                        "Segoe UI",
                        Font.ITALIC,
                        12
                )
        );

        footer.setForeground(Color.GRAY);

        footer.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        footer.setBounds(
                100,
                345,
                300,
                25
        );

        loginCard.add(footer);

        // =================================================
        // ADD LOGIN CARD
        // =================================================

        mainPanel.add(loginCard);

        add(
                mainPanel,
                BorderLayout.CENTER
        );

        // =================================================
        // SHOW LOGIN WINDOW
        // =================================================

        setVisible(true);
    }

    // =====================================================
    // BUTTON ACTIONS
    // =====================================================

    @Override
    public void actionPerformed(
            ActionEvent e
    ) {

        // =================================================
        // LOGIN BUTTON
        // =================================================

        if (e.getSource() == loginButton) {

            String username =
                    usernameField
                            .getText()
                            .trim();

            String enteredPassword =
                    new String(
                            passwordField
                                    .getPassword()
                    );

            // =================================================
            // CHECK LOGIN
            // =================================================

            if (username.equals("hosteladmin")
                    &&
                    enteredPassword.equals(savedPassword)) {

                // =============================================
                // LOGIN SUCCESS MESSAGE
                // =============================================

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!\n\n"
                                + "Welcome to Hostel Management System.",
                        "Login Successful",
                        JOptionPane.INFORMATION_MESSAGE
                );

                // =============================================
                // OPEN DASHBOARD WINDOW
                // =============================================

                Dashboard dashboard =
                        new Dashboard();

                dashboard.setVisible(true);

                // =============================================
                // CLOSE LOGIN WINDOW
                // =============================================

                this.dispose();

            } else {

                // =============================================
                // LOGIN FAILED
                // =============================================

                JOptionPane.showMessageDialog(
                        this,
                        "Incorrect Username or Password!\n\n"
                                + "Please try again.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // =================================================
        // CANCEL BUTTON
        // =================================================

        if (e.getSource() == cancelButton) {

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to cancel?",
                            "Cancel Login",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice == JOptionPane.YES_OPTION) {

                System.exit(0);
            }
        }
    }

    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(
            String[] args
    ) {

        String url = "jdbc:mysql://localhost:3306/sys";
        String username = "root";
        String password = "K@n26071";
        try{
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password);
        }
        catch(SQLException e){
            System.out.println();
        }
        String sql="insert into student(name, password)values(?,?)";

        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {

                        new Login();
                    }
                }
        );
    }
}