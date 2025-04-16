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
public class VhService {
    @Id
    private String serviceId;

    private String serviceName;
    private double price;
    private String description;

}