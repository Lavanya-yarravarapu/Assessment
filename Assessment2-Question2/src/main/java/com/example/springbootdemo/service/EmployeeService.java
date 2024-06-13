package com.example.springbootdemo.service;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null; // Or throw an exception indicating not found
    }
}

