package com.zaurtregulov.spring.springboot.spring_data_jpa.dao;

import com.zaurtregulov.spring.springboot.spring_course_springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

////////////////////////////////Реализация через Hibernate//////////////////////
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
////////////////////////////////или///////////////////
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

////////////////////////////////Реализация через JPA//////////////////////////
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
////////////////////////////////Реализация через Hibernate//////////////////////
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

////////////////////////////////Реализация через JPA////////////////////////////
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
////////////////////////////////Реализация через Hibernate//////////////////////
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

////////////////////////////////Реализация через JPA////////////////////////////
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
////////////////////////////////Реализация через Hibernate//////////////////////
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =: employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

////////////////////////////////Реализация через JPA///////////////////////////
        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
