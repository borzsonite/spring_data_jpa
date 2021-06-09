package com.zaurtregulov.spring.springboot.spring_data_jpa.dao;




import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
