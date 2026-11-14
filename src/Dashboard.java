import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class Dashboard extends JFrame {

    // =========================================================
    // COLORS
    // =========================================================

    private final Color darkBlue = new Color(5, 57, 105);
    private final Color topBlue = new Color(7, 61, 112);
    private final Color titleBlue = new Color(15, 65, 145);
    private final Color lightBlue = new Color(235, 244, 255);
    private final Color borderBlue = new Color(90, 160, 230);
    private final Color footerBlue = new Color(4, 38, 90);


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Dashboard() {

        setTitle("Hostel Management System - Dashboard");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new BorderLayout());


        // =====================================================
        // HEADER
        // =====================================================

        JPanel headerPanel = new JPanel(new BorderLayout());

        headerPanel.setBackground(Color.WHITE);

        headerPanel.setPreferredSize(
                new Dimension(0, 135)
        );


        JLabel headerImage = new JLabel();

        headerImage.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        URL imageURL = getClass().getResource(
                "/image/poornima.jpeg"
        );


        if (imageURL != null) {

            ImageIcon originalIcon =
                    new ImageIcon(imageURL);

            Image image =
                    originalIcon.getImage();

            Image resizedImage =
                    image.getScaledInstance(
                            620,
                            115,
                            Image.SCALE_SMOOTH
                    );

            headerImage.setIcon(
                    new ImageIcon(resizedImage)
            );

        } else {

            headerImage.setText(
                    "POORNIMA INSTITUTE OF ENGINEERING & TECHNOLOGY"
            );

            headerImage.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            22
                    )
            );

            headerImage.setForeground(
                    titleBlue
            );
        }


        headerPanel.add(
                headerImage,
                BorderLayout.CENTER
        );


        add(
                headerPanel,
                BorderLayout.NORTH
        );


        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(Color.WHITE);


        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar =
                new JPanel(new BorderLayout());

        sidebar.setBackground(darkBlue);

        sidebar.setPreferredSize(
                new Dimension(290, 0)
        );


        // =====================================================
        // SIDEBAR MENU
        // =====================================================

        JPanel menuPanel = new JPanel();

        menuPanel.setLayout(
                new BoxLayout(
                        menuPanel,
                        BoxLayout.Y_AXIS
                )
        );

        menuPanel.setBackground(darkBlue);

        menuPanel.setBorder(
                new EmptyBorder(
                        35,
                        12,
                        20,
                        12
                )
        );


        // =====================================================
        // DASHBOARD / HOME
        // =====================================================

        JButton dashboardButton =
                createSideButton(
                        "🏠",
                        "DASHBOARD"
                );

        menuPanel.add(
                dashboardButton
        );


        menuPanel.add(
                Box.createVerticalStrut(12)
        );


        // =====================================================
        // ADD
        // =====================================================

        JButton addButton =
                createSideButton(
                        "👤+",
                        "ADD"
                );

        menuPanel.add(
                addButton
        );


        menuPanel.add(
                Box.createVerticalStrut(12)
        );


        // =====================================================
        // VIEW
        // =====================================================

        JButton viewButton =
                createSideButton(
                        "👥",
                        "VIEW"
                );

        menuPanel.add(
                viewButton
        );


        menuPanel.add(
                Box.createVerticalStrut(12)
        );


        // =====================================================
        // EDIT
        // =====================================================

        JButton editButton =
                createSideButton(
                        "✎",
                        "EDIT"
                );

        menuPanel.add(
                editButton
        );


        sidebar.add(
                menuPanel,
                BorderLayout.NORTH
        );


        // =====================================================
        // LOGOUT
        // =====================================================

        JPanel logoutPanel =
                new JPanel(
                        new BorderLayout()
                );

        logoutPanel.setBackground(
                darkBlue
        );

        logoutPanel.setBorder(
                BorderFactory.createMatteBorder(
                        1,
                        0,
                        0,
                        0,
                        new Color(
                                45,
                                100,
                                155
                        )
                )
        );


        JButton logoutButton =
                createSideButton(
                        "⇥",
                        "LOGOUT"
                );


        JPanel logoutWrapper =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                22,
                                15
                        )
                );

        logoutWrapper.setBackground(
                darkBlue
        );


        logoutWrapper.add(
                logoutButton
        );


        logoutPanel.add(
                logoutWrapper,
                BorderLayout.CENTER
        );


        sidebar.add(
                logoutPanel,
                BorderLayout.SOUTH
        );


        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );


        // =====================================================
        // RIGHT SIDE
        // =====================================================

        JPanel rightPanel =
                new JPanel(
                        new BorderLayout()
                );

        rightPanel.setBackground(
                Color.WHITE
        );


        // =====================================================
        // BLUE TOP BAR
        // =====================================================

        JPanel blueTitleBar =
                new JPanel(
                        new BorderLayout()
                );

        blueTitleBar.setBackground(
                topBlue
        );

        blueTitleBar.setPreferredSize(
                new Dimension(
                        0,
                        47
                )
        );


        JLabel smallTitle =
                new JLabel(
                        "HOSTEL MANAGEMENT SYSTEM"
                );

        smallTitle.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        smallTitle.setForeground(
                Color.WHITE
        );

        smallTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );


        blueTitleBar.add(
                smallTitle,
                BorderLayout.CENTER
        );


        rightPanel.add(
                blueTitleBar,
                BorderLayout.NORTH
        );


        // =====================================================
        // CONTENT
        // =====================================================

        JPanel contentPanel =
                new JPanel();


        contentPanel.setLayout(
                new BoxLayout(
                        contentPanel,
                        BoxLayout.Y_AXIS
                )
        );


        contentPanel.setBackground(
                Color.WHITE
        );


        // =====================================================
        // MAIN TITLE
        // =====================================================

        JLabel mainTitle =
                new JLabel(
                        "HOSTEL MANAGEMENT SYSTEM"
                );


        mainTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        36
                )
        );


        mainTitle.setForeground(
                titleBlue
        );


        mainTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        contentPanel.add(
                Box.createVerticalStrut(38)
        );


        contentPanel.add(
                mainTitle
        );


        // =====================================================
        // WELCOME
        // =====================================================

        JLabel welcomeText =
                new JLabel(
                        "Welcome to your Hostel Management Dashboard"
                );


        welcomeText.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        19
                )
        );


        welcomeText.setForeground(
                new Color(
                        110,
                        110,
                        110
                )
        );


        welcomeText.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        contentPanel.add(
                Box.createVerticalStrut(8)
        );


        contentPanel.add(
                welcomeText
        );


        // =====================================================
        // ABOUT SECTION
        // =====================================================

        JPanel aboutPanel =
                new JPanel();


        aboutPanel.setLayout(
                new BoxLayout(
                        aboutPanel,
                        BoxLayout.Y_AXIS
                )
        );


        aboutPanel.setBackground(
                Color.WHITE
        );


        aboutPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        // =====================================================
        // ABOUT TITLE
        // NO EMOJI HERE
        // =====================================================

        JLabel aboutTitle =
                new JLabel(
                        "ABOUT THE HMS"
                );


        aboutTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        27
                )
        );


        aboutTitle.setForeground(
                titleBlue
        );


        aboutTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        aboutPanel.add(
                aboutTitle
        );


        // =====================================================
        // ABOUT DESCRIPTION
        // =====================================================

        JLabel aboutText =
                new JLabel(
                        "<html>" +
                                "The HMS helps you to manage student information.<br>" +
                                "You can add, view, edit and delete student details in one place." +
                                "</html>"
                );


        aboutText.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        18
                )
        );


        aboutText.setForeground(
                Color.BLACK
        );


        aboutText.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        aboutPanel.add(
                Box.createVerticalStrut(14)
        );


        aboutPanel.add(
                aboutText
        );


        // =====================================================
        // ABOUT WRAPPER
        // THIS CONTROLS LEFT POSITION
        // =====================================================

        JPanel aboutWrapper =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                0,
                                0
                        )
                );


        aboutWrapper.setBackground(
                Color.WHITE
        );


        aboutWrapper.setBorder(
                new EmptyBorder(
                        0,
                        45,
                        0,
                        0
                )
        );


        aboutWrapper.add(
                aboutPanel
        );


        contentPanel.add(
                Box.createVerticalStrut(55)
        );


        contentPanel.add(
                aboutWrapper
        );


        // =====================================================
        // ACTION BUTTONS
        // =====================================================

        JPanel actionPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                25,
                                10
                        )
                );


        actionPanel.setBackground(
                Color.WHITE
        );


        // ADD
        JButton addActionButton =
                createActionButton(
                        "👤+   ADD"
                );


        // VIEW
        JButton viewActionButton =
                createActionButton(
                        "👥   VIEW"
                );


        // EDIT
        JButton editActionButton =
                createActionButton(
                        "✎   EDIT"
                );


        actionPanel.add(
                addActionButton
        );


        actionPanel.add(
                viewActionButton
        );


        actionPanel.add(
                editActionButton
        );


        contentPanel.add(
                Box.createVerticalStrut(50)
        );


        contentPanel.add(
                actionPanel
        );


        // =====================================================
        // RIGHT PANEL
        // =====================================================

        rightPanel.add(
                contentPanel,
                BorderLayout.CENTER
        );


        mainPanel.add(
                rightPanel,
                BorderLayout.CENTER
        );


        // =====================================================
        // FOOTER
        // =====================================================

        JPanel footer =
                new JPanel(
                        new BorderLayout()
                );


        footer.setBackground(
                footerBlue
        );


        footer.setPreferredSize(
                new Dimension(
                        0,
                        42
                )
        );


        JLabel footerText =
                new JLabel(
                        "Created by Kanishka | 2026"
                );


        footerText.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        footerText.setForeground(
                Color.WHITE
        );


        footerText.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );


        footer.add(
                footerText,
                BorderLayout.CENTER
        );


        // =====================================================
        // ADD PANELS
        // =====================================================

        add(
                mainPanel,
                BorderLayout.CENTER
        );


        add(
                footer,
                BorderLayout.SOUTH
        );


        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        // DASHBOARD
        dashboardButton.addActionListener(
                e -> setVisible(true)
        );


        // ADD
        addButton.addActionListener(
                e -> openAddPage()
        );


        addActionButton.addActionListener(
                e -> openAddPage()
        );


        // VIEW
        viewButton.addActionListener(
                e -> openViewPage()
        );


        viewActionButton.addActionListener(
                e -> openViewPage()
        );


        // EDIT
        editButton.addActionListener(
                e -> openEditPage()
        );


        editActionButton.addActionListener(
                e -> openEditPage()
        );


        // LOGOUT
        logoutButton.addActionListener(
                e -> {

                    int choice =
                            JOptionPane.showConfirmDialog(
                                    this,
                                    "Are you sure you want to logout?",
                                    "Logout",
                                    JOptionPane.YES_NO_OPTION
                            );


                    if (choice ==
                            JOptionPane.YES_OPTION) {

                        new Login().setVisible(true);

                        dispose();
                    }
                }
        );


        // =====================================================
        // SHOW
        // =====================================================

        setVisible(true);
    }


    // =========================================================
    // SIDEBAR BUTTON
    // =========================================================

    private JButton createSideButton(
            String icon,
            String text
    ) {


        JButton button =
                new JButton();


        button.setLayout(
                new BorderLayout()
        );


        button.setPreferredSize(
                new Dimension(
                        265,
                        66
                )
        );


        button.setMaximumSize(
                new Dimension(
                        265,
                        66
                )
        );


        button.setMinimumSize(
                new Dimension(
                        265,
                        66
                )
        );


        // =====================================================
        // ICON
        // =====================================================

        JLabel iconLabel =
                new JLabel(
                        icon
                );


        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        27
                )
        );


        iconLabel.setForeground(
                Color.WHITE
        );


        iconLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        iconLabel.setPreferredSize(
                new Dimension(
                        65,
                        60
                )
        );


        // =====================================================
        // TEXT
        // =====================================================

        JLabel textLabel =
                new JLabel(
                        text
                );


        textLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        17
                )
        );


        textLabel.setForeground(
                Color.WHITE
        );


        button.add(
                iconLabel,
                BorderLayout.WEST
        );


        button.add(
                textLabel,
                BorderLayout.CENTER
        );


        // =====================================================
        // STYLE
        // =====================================================

        button.setBackground(
                darkBlue
        );


        button.setForeground(
                Color.WHITE
        );


        button.setFocusPainted(
                false
        );


        button.setBorderPainted(
                false
        );


        button.setOpaque(
                true
        );


        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );


        // =====================================================
        // HOVER
        // =====================================================

        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e
                    ) {

                        button.setBackground(
                                new Color(
                                        20,
                                        105,
                                        190
                                )
                        );
                    }


                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e
                    ) {

                        button.setBackground(
                                darkBlue
                        );
                    }
                }
        );


        return button;
    }


    // =========================================================
    // ACTION BUTTON
    // =========================================================

    private JButton createActionButton(
            String text
    ) {


        JButton button =
                new JButton(
                        text
                );


        button.setPreferredSize(
                new Dimension(
                        250,
                        80
                )
        );


        button.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        18
                )
        );


        button.setForeground(
                new Color(
                        5,
                        57,
                        105
                )
        );


        button.setBackground(
                lightBlue
        );


        button.setFocusPainted(
                false
        );


        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );


        button.setBorder(
                BorderFactory.createLineBorder(
                        borderBlue,
                        1
                )
        );


        // =====================================================
        // HOVER
        // =====================================================

        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e
                    ) {

                        button.setBackground(
                                new Color(
                                        215,
                                        235,
                                        255
                                )
                        );
                    }


                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e
                    ) {

                        button.setBackground(
                                lightBlue
                        );
                    }
                }
        );


        return button;
    }


    // =========================================================
    // OPEN ADD
    // =========================================================

    private void openAddPage() {

        Add addPage =
                new Add();


        addPage.setVisible(true);


        setVisible(false);


        addPage.addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosed(
                            WindowEvent e
                    ) {

                        setVisible(true);
                    }
                }
        );
    }


    // =========================================================
    // OPEN VIEW
    // =========================================================

    private void openViewPage() {

        view viewPage =
                new view();


        viewPage.setVisible(true);


        setVisible(false);


        viewPage.addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosed(
                            WindowEvent e
                    ) {

                        setVisible(true);
                    }
                }
        );
    }


    // =========================================================
    // OPEN EDIT
    // =========================================================

    private void openEditPage() {

        Edit editPage =
                new Edit();


        editPage.setVisible(true);


        setVisible(false);


        editPage.addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosed(
                            WindowEvent e
                    ) {

                        setVisible(true);
                    }
                }
        );
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> new Dashboard()
        );
    }
}