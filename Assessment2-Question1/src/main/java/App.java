
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.service.EmployeeManager;
import com.example.model.Employee;

public class App {
    public static void main(String[] args) {
        // Initialize Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.example"); // Scan for Spring components under com.example package
        context.refresh();
        
        // Get EmployeeManager bean from Spring context
        EmployeeManager employeeManager = context.getBean(EmployeeManager.class);
        
        // Test CRUD operations
        // 1. Add employee
        Employee newEmployee = new Employee(1, "lavanya", "IT");
        employeeManager.addEmployee(newEmployee);
        
        // 2. Get all employees
        System.out.println("All Employees:");
        employeeManager.getAllEmployees().forEach(System.out::println);
        
        // 3. Get employee by id
        Employee foundEmployee = employeeManager.getEmployeeById(1);
        System.out.println("\nEmployee with id 1:");
        System.out.println(foundEmployee);
        
        // 4. Update employee
        foundEmployee.setName("lavanya");
        employeeManager.updateEmployee(foundEmployee);
        
        // 5. Delete employee
        employeeManager.deleteEmployee(1);
        
        // Close Spring context
        context.close();
    }
}
