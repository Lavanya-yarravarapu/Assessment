package com.example.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.model.Employee;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeManager {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public EmployeeManager(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employees (id, name, department) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getDepartment());
    }
    
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM Employees";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department")
                ));
    }
    
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM Employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department")
                ));
    }
    
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employees SET name = ?, department = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
    }
    
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employees WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

