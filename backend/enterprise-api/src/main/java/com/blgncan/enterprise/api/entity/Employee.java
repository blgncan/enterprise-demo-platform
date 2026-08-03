package com.blgncan.enterprise.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 250,unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private BigDecimal salary;

    private LocalDateTime hireDate;

    @Column(nullable = false)
    private Boolean active=true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @PrePersist
    public void prePersist()
    {
        LocalDateTime now = LocalDateTime.now();

        this.createdDate = now;
        this.updatedDate = now;
    }
    @PreUpdate
    public void preUpdate()
    {
        this.updatedDate = LocalDateTime.now();
    }
}
