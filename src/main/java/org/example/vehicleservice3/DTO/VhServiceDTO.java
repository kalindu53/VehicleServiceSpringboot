package org.example.vehicleservice3.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VhServiceDTO {
    private String serviceId;
    private String serviceName;
    private double price;
    private String description;
}
