package org.example.vehicleservice3.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    private String adminId;
    private String name;
    private String email;
    private String password;

    // Getters and Setters
}