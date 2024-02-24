package com.srinivas.ems.service.impl;

import com.srinivas.ems.dto.EmployeeDto;
import com.srinivas.ems.repository.EmployeeRepository;
import com.srinivas.ems.service.EmployeeService;
import com.srinivas.ems.entity.Employee;
import com.srinivas.ems.exception.ResourceNotFoundException;
import com.srinivas.ems.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee does not exist with given id "+employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        List<EmployeeDto> employeeDtos=new ArrayList<>();
        for(Employee emp:employees){
            EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(emp);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
       Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("employee does not exists with given id "+employeeId));
       employee.setFirstName(updatedEmployee.getFirstName());
       employee.setLastName(updatedEmployee.getLastName());
       employee.setEmail(updatedEmployee.getEmail());
       Employee UpdatedemployeeObj=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(UpdatedemployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("employee does not exists with given id "+employeeId));
        employeeRepository.deleteById(employeeId);

    }
}
