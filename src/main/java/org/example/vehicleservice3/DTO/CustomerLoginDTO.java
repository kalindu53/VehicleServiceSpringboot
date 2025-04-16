package org.example.vehicleservice3.DTO;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginDTO {
    private String email;
    private String phone;
}
