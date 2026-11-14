

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBConnection {

        private static final String URL =
                "jdbc:mysql://localhost:3306/kanishka";

        private static final String USER = "root";

        // Yahan apna working MySQL password likho.
        private static final String PASSWORD = "K@n260712";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
        }
    }


