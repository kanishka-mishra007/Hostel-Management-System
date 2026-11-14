import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class view extends JFrame {

    // =========================
    // COLORS
    // =========================

    Color DARK_BLUE = new Color(0, 51, 102);
    Color LIGHT_BLUE = new Color(240, 246, 252);
    Color RED = new Color(220, 53, 69);
    Color GREY = new Color(108, 117, 125);

    JTable table;
    DefaultTableModel model;
    JTextField searchField;
    TableRowSorter<DefaultTableModel> sorter;


    // =========================
    // CONSTRUCTOR
    // =========================

    public view() {

        setTitle("Hostel Management System - View Students");

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setExtendedState(
                JFrame.MAXIMIZED_BOTH
        );

        setLayout(
                new BorderLayout()
        );

        createHeader();

        createMainPanel();

        createFooter();

        setVisible(true);
    }


    // =========================
    // HEADER
    // =========================

    private void createHeader() {

        JPanel headerPanel =
                new JPanel(
                        new BorderLayout()
                );

        headerPanel.setBackground(
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


        headerPanel.add(
                imageLabel,
                BorderLayout.CENTER
        );


        // Blue line below header

        JLabel titleBar =
                new JLabel(
                        "HOSTEL MANAGEMENT SYSTEM"
                );


        titleBar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );


        titleBar.setForeground(
                Color.WHITE
        );


        titleBar.setBackground(
                DARK_BLUE
        );


        titleBar.setOpaque(true);


        titleBar.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        titleBar.setPreferredSize(
                new Dimension(
                        100,
                        38
                )
        );


        headerPanel.add(
                titleBar,
                BorderLayout.SOUTH
        );


        add(
                headerPanel,
                BorderLayout.NORTH
        );
    }


    // =========================
    // MAIN PANEL
    // =========================

    private void createMainPanel() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );


        mainPanel.setBackground(
                LIGHT_BLUE
        );


        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );


        // =========================
        // WHITE CARD
        // =========================

        JPanel card =
                new JPanel(
                        new BorderLayout()
                );


        card.setBackground(
                Color.WHITE
        );


        card.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                200,
                                210,
                                220
                        )
                )
        );


        // =========================
        // TOP PANEL
        // =========================

        JPanel topPanel =
                new JPanel(
                        new BorderLayout()
                );


        topPanel.setBackground(
                Color.WHITE
        );


        // =========================
        // TITLE
        // =========================

        JLabel title =
                new JLabel(
                        "VIEW STUDENT DETAILS"
                );


        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27
                )
        );


        title.setForeground(
                DARK_BLUE
        );


        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        title.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        10,
                        15,
                        10
                )
        );


        topPanel.add(
                title,
                BorderLayout.CENTER
        );


        // =========================
        // SEARCH PANEL - TOP RIGHT
        // =========================

        JPanel searchPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                12
                        )
                );


        searchPanel.setBackground(
                Color.WHITE
        );


        JLabel searchLabel =
                new JLabel(
                        "Search:"
                );


        searchLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        searchField =
                new JTextField(
                        15
                );


        searchField.setPreferredSize(
                new Dimension(
                        200,
                        38
                )
        );


        // =========================
        // SEARCH BUTTON
        // =========================

        JButton searchButton =
                new JButton(
                        "SEARCH"
                );


        searchButton.setPreferredSize(
                new Dimension(
                        115,
                        40
                )
        );


        searchButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        searchButton.setBackground(
                DARK_BLUE
        );


        searchButton.setForeground(
                Color.WHITE
        );


        searchButton.setFocusPainted(
                false
        );


        // =========================
        // CLEAR BUTTON
        // =========================

        JButton clearButton =
                new JButton(
                        "CLEAR"
                );


        clearButton.setPreferredSize(
                new Dimension(
                        100,
                        40
                )
        );


        clearButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        clearButton.setBackground(
                RED
        );


        clearButton.setForeground(
                Color.WHITE
        );


        clearButton.setFocusPainted(
                false
        );


        searchPanel.add(
                searchLabel
        );


        searchPanel.add(
                searchField
        );


        searchPanel.add(
                searchButton
        );


        searchPanel.add(
                clearButton
        );


        topPanel.add(
                searchPanel,
                BorderLayout.EAST
        );


        card.add(
                topPanel,
                BorderLayout.NORTH
        );


        // =========================
        // TABLE
        // =========================

        String[] columns = {

                "ID",
                "Name",
                "Father's Name",
                "Gender",
                "DOB",
                "Phone",
                "Email",
                "Address",
                "Course",
                "Year",
                "Room No."

        };


        model =
                new DefaultTableModel(
                        columns,
                        0
                );


        // =========================
        // STUDENT DATA
        // =========================
        loadStudentsFromDatabase();


        table =
                new JTable(
                        model
                );


        table.setRowHeight(
                38
        );


        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );


        table.getTableHeader().setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );


        table.getTableHeader().setBackground(
                DARK_BLUE
        );


        table.getTableHeader().setForeground(
                Color.WHITE
        );


        // =========================
        // TABLE SORTER
        // =========================

        sorter =
                new TableRowSorter<>(
                        model
                );


        table.setRowSorter(
                sorter
        );


        JScrollPane scrollPane =
                new JScrollPane(
                        table
                );


        card.add(
                scrollPane,
                BorderLayout.CENTER
        );


        // =========================
        // BOTTOM PANEL
        // =========================

        JPanel bottomPanel =
                new JPanel(
                        new BorderLayout()
                );


        bottomPanel.setBackground(
                Color.WHITE
        );


        // =========================
        // BACK BUTTON
        // =========================

        JPanel backPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                15,
                                12
                        )
                );


        backPanel.setBackground(
                Color.WHITE
        );


        JButton backButton =
                new JButton(
                        "← BACK"
                );


        backButton.setPreferredSize(
                new Dimension(
                        120,
                        42
                )
        );


        backButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        backButton.setBackground(
                GREY
        );


        backButton.setForeground(
                Color.WHITE
        );


        backButton.setFocusPainted(
                false
        );


        backButton.addActionListener(
                e -> dispose()
        );


        backPanel.add(
                backButton
        );

// =========================
// DELETE STUDENT BUTTON
// =========================

        JPanel deletePanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 15, 12)
        );

        deletePanel.setBackground(Color.WHITE);

        JButton deleteButton = new JButton("DELETE STUDENT");

        deleteButton.setPreferredSize(
                new Dimension(170, 42)
        );

        deleteButton.setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        deleteButton.setBackground(RED);

        deleteButton.setForeground(Color.WHITE);

        deleteButton.setFocusPainted(false);

        deleteButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        deleteButton.addActionListener(
                e -> deleteSelectedStudent()
        );

        deletePanel.add(deleteButton);

        bottomPanel.add(deletePanel, BorderLayout.WEST);
        bottomPanel.add(
                backPanel,
                BorderLayout.EAST
        );


        card.add(
                bottomPanel,
                BorderLayout.SOUTH
        );


        mainPanel.add(
                card,
                BorderLayout.CENTER
        );


        add(
                mainPanel,
                BorderLayout.CENTER
        );


        // =========================
        // SEARCH BUTTON ACTION
        // =========================

        searchButton.addActionListener(
                e -> {

                    String text =
                            searchField
                                    .getText()
                                    .trim();


                    if (text.isEmpty()) {

                        sorter.setRowFilter(null);

                    } else {

                        sorter.setRowFilter(
                                RowFilter.regexFilter(
                                        "(?i)" +
                                                java.util.regex.Pattern
                                                        .quote(text)
                                )
                        );
                    }
                }
        );


        // =========================
        // PRESS ENTER TO SEARCH
        // =========================

        searchField.addActionListener(
                e -> searchButton.doClick()
        );


        // =========================
        // CLEAR BUTTON ACTION
        // =========================

        clearButton.addActionListener(
                e -> {

                    searchField.setText("");

                    sorter.setRowFilter(null);

                    table.clearSelection();
                }
        );
    }


    // =========================
    // FOOTER
    // =========================
// =========================
// LOAD STUDENTS FROM DATABASE
// =========================

    private void loadStudentsFromDatabase() {

        String sql = "SELECT id, name, father_name, gender, dob, "
                + "phone, email, address, course, study_year, room "
                + "FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {


                        Object[] row = {
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
                };

                model.addRow(row);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to load student records from database.\n"
                            + "Error: " + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    // =========================
// DELETE STUDENT
// =========================

    private void deleteSelectedStudent() {

        // Check selected row
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a student to delete.",
                    "No Student Selected",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Convert view row into model row
        int modelRow = table.convertRowIndexToModel(selectedRow);

        // Get Student ID
        String studentId = model.getValueAt(modelRow, 0).toString();

        String studentName = model.getValueAt(modelRow, 1).toString();

        // Confirmation popup
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this student?\n\n"
                        + "Student ID: " + studentId
                        + "\nName: " + studentName,
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {

            String sql = "DELETE FROM students WHERE id = ?";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, studentId);

                int result = ps.executeUpdate();

                if (result > 0) {

                    // Remove student from JTable
                    model.removeRow(modelRow);

                    JOptionPane.showMessageDialog(
                            this,
                            "Student deleted successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Student record not found in database.",
                            "Delete Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            } catch (SQLException ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Unable to delete student.\n"
                                + "Error: " + ex.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
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


    // =========================
    // MAIN
    // =========================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> new view()
        );
    }
}