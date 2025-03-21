import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection
{
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String USER = "root";
    private static final String PASSWORD = "mickoo";
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("❌ Database connection failed: " + e.getMessage());
            return null;
        }
    }
    public static void main(String[] args)
    {
        Connection conn = getConnection();
        if (conn != null)
            System.out.println("✅ Database connected successfully!");
        else
            System.out.println("❌ Failed to connect to the database.");
    }
}
