import java.util.Scanner;

public class Main {

    public static void menu(){
        System.out.println("1.View employee by id");
        System.out.println("2.Insert employee");
        System.out.println("3.Delete employee");
        System.out.println("4.Update employee");
        System.out.println("5.Exit");
        System.out.print("Please choose operation to be performed(1-5):");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CRUD crud = new CRUD();

        //provide URL, username, password.
        String url = "JDBC:mysql://127.0.0.1:3306/employee_database";
        String username = "root";
        String password = "Root";
        //show menu to user.
        menu();
        try{
            int choice = scanner.nextInt();
                switch(choice){
                    case 1:
                        try{
                            System.out.print("Enter employee id:");
                            int empId = scanner.nextInt();
                            crud.getEmployee(url,username,password,empId);
                        }catch (Exception e){
                            System.out.println("Error on getting employee");
                        }
                        break;
                    case 2:
                        try{
                            System.out.print("Enter employee id:");
                            int empId = scanner.nextInt();
                            System.out.print("Enter employee name:");
                            String empName = scanner.next();
                            System.out.print("Enter employee department:");
                            String empDept = scanner.next();
                            System.out.print("Enter employee salary:");
                            double empSalary = scanner.nextDouble();
                            System.out.println(crud.insertEmployee(url,username,password,empId,empName,empDept,empSalary)>0?"Success":"failed");
                        }catch(Exception e){
                            System.out.println("Error on insertion");
                        }
                        break;
                    case 3:
                        try{
                            System.out.print("Enter employee id:");
                            int empId = scanner.nextInt();
                            System.out.println(crud.deleteEmployee(url,username,password,empId)>0?"success":"fail");
                        }catch(Exception e){
                            System.out.println("Error on deletion");
                        }
                        break;
                    case 4:
                        try{
                            System.out.print("Enter employee id to update:");
                            int empId = scanner.nextInt();
                            System.out.print("Enter employee updated name:");
                            String empName = scanner.next();
                            System.out.print("Enter employee updated department:");
                            String empDept = scanner.next();
                            System.out.print("Enter employee updated salary:");
                            double empSalary = scanner.nextDouble();
                            System.out.println(crud.updateEmployee(url,username,password,empId,empName,empDept,empSalary)>0?"Success.":"Fail.");
                        }catch(Exception e){
                            System.out.println("Error on update.");
                        }
                    case 5:
                        break;
                    default:
                        System.out.println("Error, Wrong value provided.");
                }
        }catch (Exception e){
            System.out.println("Error"+ e);
        }
    }
}