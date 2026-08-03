package com.blgncan.enterprise.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private BigDecimal salary;

    private String departmentName;
}
