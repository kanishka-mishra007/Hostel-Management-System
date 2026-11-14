
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;

public  class insert{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the student");
        String name=sc.nextLine();

        System.out.println("Enter the password of the student");
        String pass=sc.nextLine();
        String url="jdbc:mysql://localhost:3306/kanishka";
        String username = "root";
        String  password = "K@n26071";

        String sql="insert into student(name, password)values(?,?)";

        try {
            Connection con = DriverManager.getConnection(
            url,
                    username,
                    password );
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, pass);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("inserted successfully");
            } else {
                System.out.println("not inserted ");
            }
            ps.close();
            con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();

        }

    }
}


