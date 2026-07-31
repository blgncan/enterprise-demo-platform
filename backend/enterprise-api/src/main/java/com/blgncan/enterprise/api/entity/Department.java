package com.blgncan.enterprise.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 100,unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Boolean active=true;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false,updatable = false)
    private LocalDateTime updatedDate;


    public Department() {

    }

    @PrePersist
    public void prePersist()
    {
        this.createdDate = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate()
    {
        this.updatedDate = LocalDateTime.now();
    }

}
