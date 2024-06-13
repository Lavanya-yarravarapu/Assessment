package com.example.springbootdemo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
