package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="uuser", schema = "reddit")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @Email
    @NotEmpty(message= "Email is required")
    private String email;

    private Instant created;

    private boolean enabled;
}
