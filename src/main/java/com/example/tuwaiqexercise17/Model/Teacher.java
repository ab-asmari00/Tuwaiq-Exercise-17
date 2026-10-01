package com.example.tuwaiqexercise17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "integer not null")
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must not exceed 255 characters")
    @Column(columnDefinition = "varchar(255) not null")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Column(columnDefinition = "integer not null")
    private Integer age;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    @Size(max = 254, message = "Email must not exceed 254 characters")
    @Column(columnDefinition = "varchar(254) not null")
    private String email;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than zero")
    @Column(columnDefinition = "double precision not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

}
