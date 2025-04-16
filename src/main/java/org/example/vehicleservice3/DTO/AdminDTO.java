package org.example.vehicleservice3.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private String adminId;
    private String name;
    private String email;
    private String password;
}
