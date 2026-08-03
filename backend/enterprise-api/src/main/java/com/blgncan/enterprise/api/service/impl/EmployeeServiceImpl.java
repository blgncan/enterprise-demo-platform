package com.blgncan.enterprise.api.service.impl;

import com.blgncan.enterprise.api.dto.request.EmployeeRequest;
import com.blgncan.enterprise.api.dto.response.EmployeeResponse;
import com.blgncan.enterprise.api.entity.Department;
import com.blgncan.enterprise.api.entity.Employee;
import com.blgncan.enterprise.api.exception.ResourceNotFoundException;
import com.blgncan.enterprise.api.mapper.EmployeeMapper;
import com.blgncan.enterprise.api.repository.DepartmentRepository;
import com.blgncan.enterprise.api.repository.EmployeeRepository;
import com.blgncan.enterprise.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper mapper;


    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }


    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found"));

        Employee employee = mapper.toEntity(request);

        employee.setDepartment(department);

        Employee saved = employeeRepository.save(employee);

        return mapper.toResponse(saved);
    }
}
