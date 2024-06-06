package com.rajeshkawali.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private SmoothiePreference smoothiePreference;

    private Long mobileNumber;
}