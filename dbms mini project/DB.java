import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;


public class DB {
    Connection conn =null;
    java.sql.PreparedStatement pst;
    public static Connection dbconnect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject","root","3002");
            return conn;
        }
        catch (Exception e2)
        {
            System.out.println(e2);
            return null;
        }
    }
}
