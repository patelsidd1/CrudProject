
import java.sql.*;
import java.util.Scanner;

public class EmployeeDetails {
    static Scanner sc = new Scanner(System.in);
    Connection con;
    {
        try {
            con = DriverManager.getConnection(Connect.url, Connect.user, Connect.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  void readData(){
        try {
                String query = "select * from employee_info";
                Statement s = con.createStatement();
                ResultSet r  = s.executeQuery(query);
                System.out.println("Showing all the data : ");
                while(r.next()){

                    int id = r.getInt(1);
                    String name = r.getString(2);
                    int age = r.getInt(3);
                    double salary = r.getDouble(4);
                    String department = r.getString(5);
                    String address = r.getString(6);

                    System.out.println(id+ "  : "+name+ "  : " +age+ "  : "+salary+"   : "+department+"   : "+address);

                }con.close();
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
    public  void findById(){
        try {
            String query = "SELECT * FROM employee_info WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter the Id no.  ");
            int id = sc.nextInt();
            ps.setInt(1,id);
            ResultSet r = ps.executeQuery();
            boolean hasData = false ;

            while (r.next()) {
                hasData = true ;

                System.out.println("Employee details are...");
                int Id = r.getInt(1);
                String name = r.getString(2);
                int age = r.getInt(3);
                double salary = r.getDouble(4);
                String department = r.getString(5);
                String address = r.getString(6);

                System.out.println(Id + "   : " + name + "   : " + age + "   : " + salary + "   : " + department + "   : " + address);

            }con.close();
            sc.close();

            if (!hasData){
                System.out.println("Wrong Id...");
            }
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
    public  void insertData(){
        try{
            String query = "insert into employee_info(name, age, salary, department, address) values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("What is the name ? ");
            String name = sc.nextLine();
            System.out.println("What is the age ? ");
            int age = sc.nextInt();
            System.out.println("What is the salary ? ");
            double salary = sc.nextDouble();

            System.out.println("What is the Department ? ");
            sc.nextLine();
            String Department = sc.nextLine();
            System.out.println("What is the address ? ");

            String Address = sc.nextLine();
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setDouble(3,salary);
            ps.setString(4,Department);
            ps.setString(5,Address);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Inserted Successfully....");
            }else {
                System.out.println("Not Inserted.... ");
            }
            String query2 = "select * from employee_info order by id desc limit 1";
            Statement s1 = con.createStatement();
            ResultSet r1 = s1.executeQuery(query2);
            while (r1.next()) {

                System.out.println("Employee details are...");
                int id = r1.getInt(1);
                name = r1.getString(2);
                age = r1.getInt(3);
                salary = r1.getDouble(4);
                Department = r1.getString(5);
                Address = r1.getString(6);

                System.out.println( id+" :  "+ name + "   : " + age + "   : " + salary + "   : " + Department + "   : " + Address);

            } con.close();
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
    public  void deleteById(){
        try {
            String query = "delete  from employee_info where id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter the id number...");
            int Id = sc.nextInt();
            ps.setInt(1,Id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected> 0 ){
                System.out.println("Deleted Sucessfully....");
            }else {
                System.out.println("This Id is not in Database...");
            } con.close();

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
    public void updateData(){
        try{
            String query = "UPDATE employee_info SET name = COALESCE(NULLIF(?, ''), name), age = COALESCE(NULLIF(?, ''), age), salary = COALESCE(NULLIF(?, ''), salary), department = COALESCE(NULLIF(?, ''), department), address = COALESCE(NULLIF(?, ''), address) WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            System.out.println("Enter the id ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the name...");
            String name = sc.nextLine();

            System.out.println("Enter the age ? ");
            int age = sc.nextInt();

            System.out.println("Enter the salary ? ");
            double salary = sc.nextDouble();

            System.out.println("Enter the Department ? ");
            sc.nextLine();
            String Department = sc.nextLine();

            System.out.println("Enter the address  ");
            String Address = sc.nextLine();

            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setDouble(3,salary);
            ps.setString(4,Department);
            ps.setString(5,Address);
            ps.setInt(6,id);

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected> 0){
                System.out.println("Updated Sucessfully....");
            }else {
                System.out.println("Not Updated....");
            }
            con.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void findByName(){
        try {
            String query = "select * from employee_info where name = ?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter the name...");
            String name1 = sc.nextLine();
            ps.setString(1, name1 );
            ResultSet r = ps.executeQuery();
            boolean hasData = false ;
            System.out.println("Employee details are...");
            while(r.next()){
                hasData = true;

                int Id = r.getInt(1);
                String name = r.getString(2);
                int age = r.getInt(3);
                double salary = r.getDouble(4);
                String department = r.getString(5);
                String address = r.getString(6);

                System.out.println(Id + "   : " + name + "   : " + age + "   : " + salary + "   : " + department + "   : " + address);
            }
            if (!hasData){
                System.out.println("Sorry.... Name is not in Database....");
            } con.close();

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
    public void findBySalary(){

        try {
            String query ="select * from employee_info where salary = ?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter the salary....");
            double salary1 = sc.nextDouble();
            ps.setDouble(1,salary1);
            ResultSet r = ps.executeQuery();
            boolean hasData = false ;
            System.out.println("Employee details are...");
            while(r.next()){
                hasData = true;

                int Id = r.getInt(1);
                String name = r.getString(2);
                int age = r.getInt(3);
                double salary = r.getDouble(4);
                String department = r.getString(5);
                String address = r.getString(6);

                System.out.println(Id + "   : " + name + "   : " + age + "   : " + salary + "   : " + department + "   : " + address);
            }
            if (!hasData){
                System.out.println("Sorry... No one of this salary....");
            } con.close();
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
    public void findByDepartment(){
        try {
            String query ="select * from employee_info where Department = ?";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter the Department...");
            String Department1 = sc.nextLine();
            ps.setString(1,Department1);
            ResultSet r = ps.executeQuery();
            boolean hasData = false;
            System.out.println("Employee details are...");
            while(r.next()){
                hasData = true ;

                int Id = r.getInt(1);
                String name = r.getString(2);
                int age = r.getInt(3);
                double salary = r.getDouble(4);
                String department = r.getString(5);
                String address = r.getString(6);

                System.out.println(Id + "   : " + name + "   : " + age + "   : " + salary + "   : " + department + "   : " + address);
            }
            if (!hasData ){
                System.out.println("Sorry... This is not valid Department Name....");
            }
            con.close();
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
}