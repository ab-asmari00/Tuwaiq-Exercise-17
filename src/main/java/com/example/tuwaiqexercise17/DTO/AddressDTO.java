package com.example.tuwaiqexercise17.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "Teacher ID is required")
    @Positive(message = "Teacher ID must be greater than zero")
    private Integer teacher_id;

    @NotBlank(message = "Area is required")
    @Size(max = 255, message = "Area must not exceed 255 characters")
    private String area;

    @NotBlank(message = "Street is required")
    @Size(max = 255, message = "Street must not exceed 255 characters")
    private String street;

    @NotBlank(message = "Building number is required")
    @Size(max = 255, message = "Building number must not exceed 255 characters")
    private String buildingNumber;

}