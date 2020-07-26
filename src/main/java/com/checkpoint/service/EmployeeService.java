package com.checkpoint.service;
import com.checkpoint.entity.Employee;
import com.checkpoint.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee setEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }
    /* # TODO:
        public List<Employee> getEmployeesReportingToManagerById(Long id){
            return repository.fin(id);
        }
    */
    public String deleteEmployeeById(Long id) {
        repository.deleteById(id);
        return String.format("Employee with id %d has been deleted", id);
    }

    public Employee updateEmployeeById(Employee employee) {
        Employee existingEmployee = repository.findById(employee.getId()).
                orElseThrow(() -> new IllegalArgumentException(String.format("Employee %d not found", employee.getId())));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPositionName(employee.getPositionName());
        existingEmployee.setTeamName(employee.getTeamName());
        existingEmployee.setManagerId(employee.getManagerId());
        existingEmployee.setPhone(employee.getPhone());
        return repository.save(existingEmployee);
    }


}
