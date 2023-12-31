package com.rizvankarimov.springboot.spring_data_jpa.service;

import com.rizvankarimov.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.rizvankarimov.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements com.rizvankarimov.springboot.spring_data_jpa.service.EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {                                 // ishchi id nomresine gore elde etmek uchun
        Employee employee = null;                                         // bu ishchi yoxdursa null qaytaracaq
        Optional<Employee> optional = employeeRepository.findById(id);    // bu ishchi varsa onu qaytaracaq
        if(optional.isPresent()){                                         // ishchi varsa
            employee = optional.get();                                    // ishchi obyektini elde et
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByName(String name) {                          // ishchini adina gore axtarish
        List<Employee> employees = employeeRepository.findByName(name);
        return employees;
    }

    @Override
    public List<Employee> findByDepartment(String Department) {
        List<Employee> employees = employeeRepository.findByDepartment(Department);  // ishchini departamentine gore axtarish
        return employees;
    }
}
