package com.blgncan.enterprise.api.mapper;

import com.blgncan.enterprise.api.dto.request.EmployeeRequest;
import com.blgncan.enterprise.api.dto.response.EmployeeResponse;
import com.blgncan.enterprise.api.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "department", ignore = true)
    Employee toEntity(EmployeeRequest request);

    @Mapping(target = "departmentName", source = "department.name")
    EmployeeResponse toResponse(Employee employee);
}
