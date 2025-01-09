
// JDBC can throw Exception Like ClassNotFoundException and SQLException
import java.sql.*;
public class JdbcConnection {
        // Copy from MYSQL database at localhost instance
        public static final String url = "jdbc:mysql://localhost:3306/?user=root";
        // username of database
        public static final String user = "root";
        // password of database
        public static final String password = "abcd@123";

        public static void main(String[] args) {

            try{
                // It is JDBC Driver through we can connect by using of Driver
                Class.forName("com.mysql.cj.jdbc.Driver");


            } catch (ClassNotFoundException e ){

                System.out.println(e.getMessage());
            }
            try {
                // Now we can create the connection by using Connection Interface
                Connection con = DriverManager.getConnection(url,user,password);

                // Now we write the Query for database
                String query = "insert / delete/ read/ create";

                // Now we can create Statement using Statement interface and PreparedStatement Interface Like
                Statement s = con.createStatement();
                PreparedStatement ps= con.prepareStatement(query);

                //If we require to see the data from database we use ResultSet
                ResultSet r = ps.executeQuery();

                //We use 3 methods to execute and fetch the values
                ps.execute();         // It returns boolean only
                ps.executeUpdate();   // Use to perform any update in database
                ps.executeQuery();    // Use to fetch data only



            }catch (SQLException e ){
                System.out.println(e.getMessage());
            }

        }
    }

