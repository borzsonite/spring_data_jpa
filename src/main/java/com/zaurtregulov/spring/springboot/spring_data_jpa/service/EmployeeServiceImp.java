package com.zaurtregulov.spring.springboot.spring_data_jpa.service;


import com.zaurtregulov.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> newEmployee = employeeRepository.findById(id);
        if(newEmployee.isPresent()) {
            employee = newEmployee.get();
        }
            return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
       employeeRepository.deleteById(id);
    }
}
