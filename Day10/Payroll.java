package Day10;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee

 {
     private int  id;
     public  String name;

     Employee(String name ,int  id)
     {
         this.name=name;
         this.id=id;
     }

     public String getName()
     {
         return  name;
     }
     public int getId()
     {
         return  id;
     }

    public abstract double calculateSalary();

     @Override
     public String toString()
     {
         return "Employee[name="+name+",id="+id+",salary="+calculateSalary()+"]";
     }
 }


 class FullTimeEmployee extends  Employee {
     private double monthlySalary;

     public FullTimeEmployee(String name,int id ,double monthlySalary)
     {
         super(name, id);
         this.monthlySalary=monthlySalary;
     }


     @Override
     public double calculateSalary() {
         return monthlySalary;
     }
 }



 class PartTimeEmployee extends  Employee
 {

     private  int hoursWorked;
     private double hourlyRate;

     public PartTimeEmployee(String name ,int id ,int hoursWorked,int hourlyRate)
     {

         super(name, id);
         this.hoursWorked=hoursWorked;
         this.hourlyRate=hourlyRate;


     }

     @Override
     public double calculateSalary() {
         return  hourlyRate*hoursWorked;
     }
 }

 class PayrollSystem{

     private ArrayList<Employee> employeeList;

     public  PayrollSystem()
     {
         employeeList =new ArrayList<>();
     }
     public void addEmployee(Employee employee)
     {
         employeeList.add(employee);
     }
     public void removeEmployee(int id)
     {
         Employee employeeToRemove=null;
         for(Employee employee : employeeList)
         {
             if(employee.getId()==id)
             {
                 employeeToRemove=employee;
             }
         }
         if(employeeToRemove!=null)
         {
             employeeList.remove(employeeToRemove);
         }
     }

     public void displayEmployee()
     {
         for(Employee employee: employeeList)
         {
             System.out.println(employee);
         }
     }

 }



  class Mainn {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("If you want to Insert data OF FullTimeEmployee Then Press 1 Otherwise Insert data of PartTime then Press To:");
        int n=sc.nextInt();
        PayrollSystem payrollSystem=new PayrollSystem();
        if(n==1)
        {
            System.out.println("Enter Details Of FullTime Employees");
            System.out.print("Enter Name:");
            String name=sc.next();
            System.out.print("Enter id:");
            int id=sc.nextInt();
            System.out.print("Enter Salary:");
            double salary=sc.nextDouble();
            FullTimeEmployee emp1=new FullTimeEmployee(name,id,salary);
            payrollSystem.addEmployee(emp1);
        }
        else if(n==2)
        {
            System.out.println("Enter Details Of PartTime Employees");
            System.out.print("Enter Name:");
            String name=sc.next();
            System.out.print("Enter Id:");
            int id=sc.nextInt();
            System.out.print("Enter Hours You Work:");
           int hourWork=sc.nextInt();
            System.out.print("Enter  Your RateOf Hours:");
          int  hourlyRate=sc.nextInt();

            PartTimeEmployee emp2=new PartTimeEmployee(name, id ,hourWork,hourlyRate);

            payrollSystem.addEmployee(emp2);
        }

        System.out.println("Initial Employee details");
        payrollSystem.displayEmployee();
        System.out.println("Removing Employee");
        System.out.println("Enter id For Remove Employees");
        int removeId=sc.nextInt();
        payrollSystem.removeEmployee(removeId);
        System.out.println("Remaining Employees Details");
        payrollSystem.displayEmployee();
    }

}
