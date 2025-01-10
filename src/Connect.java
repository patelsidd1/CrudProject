
import java.sql.*;
public class Connect {
    public static final String url = "jdbc:mysql://localhost:3306/employee";
    public static final String user = "root";
    public static final String password = "abcd@123";

    public static void conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }


    }
}
