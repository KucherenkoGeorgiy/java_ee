package com.hillel.crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
