import java.util.Scanner;

public class Controller {
    public static  void control(){
        boolean isRunning = true;
        while (isRunning ) {

            System.out.println("1. Read all data : ");
            System.out.println("2. Find By Id : ");
            System.out.println("3. Insert data : ");
            System.out.println("4. Delete By Id : ");
            System.out.println("5. Update : ");
            System.out.println("6. Search By name : ");
            System.out.println("7. Search by Salary : ");
            System.out.println("8. Search by Department : ");
            System.out.println("9. Exit : ");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter choice : ");
            int choice = Integer.parseInt(sc.nextLine());
            System.out.println("Your Choice is :  " +choice );

            EmployeeDetails obj = new EmployeeDetails();
            switch (choice) {
                case 1:
                    obj.readData();

                    break;
                case 2:
                    obj.findById();

                    break;
                case 3:
                    obj.insertData();

                    break;
                case 4:
                    obj.deleteById();

                    break;
                case 5:
                    obj.updateData();

                    break;
                case 6:
                    obj.findByName();

                    break;
                case 7:
                    obj.findBySalary();

                    break;
                case 8:
                    obj.findByDepartment();

                    break;
                case 9:
                    isRunning = false;
                    System.out.println("Thanks Visit Again : ");
                    break;
                default:
                    System.out.println("Incorrect Choice  ");
                    break;

            }
        }
    }
}
