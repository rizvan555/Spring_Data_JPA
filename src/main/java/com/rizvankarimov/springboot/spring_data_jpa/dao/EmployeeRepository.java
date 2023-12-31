package com.rizvankarimov.springboot.spring_data_jpa.dao;



import com.rizvankarimov.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByName(String name);  // ishchini adina gore axtarish
    List<Employee> findByDepartment(String department); // ishchini departamentine gore axtarish

}
