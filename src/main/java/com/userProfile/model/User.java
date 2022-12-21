package com.userProfile.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@Table(name = "assignment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotEmpty
    @Size(min = 2 , max = 20 , message = "Name must be between 2 to 20")
    private String name;

    @NotEmpty
    @Size(min = 5 , max = 50 , message = "Address must be between 5 to 50")
    private String address;

    @Min(value = 100000 , message = "Pin-code must be greater than 100000")
    @Max(value = 999999 , message = "Pin-code must be less than 999999")
    private int pin_code;

    private Boolean state = true;

    @CreationTimestamp
    private Date timestamp;
}
