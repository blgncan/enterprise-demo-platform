package com.blgncan.enterprise.api.service;

import com.blgncan.enterprise.api.dto.request.EmployeeRequest;
import com.blgncan.enterprise.api.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse createEmployee(EmployeeRequest request);
}
