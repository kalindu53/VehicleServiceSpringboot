package org.example.vehicleservice3.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class VehicleDTO {
    private Long id;
    private Long customerId;
    private String plateNumber;
    private String model;

    // Constructors
    public VehicleDTO() {}

    public VehicleDTO(Long id, Long customerId, String plateNumber, String model) {
        this.id = id;
        this.customerId = customerId;
        this.plateNumber = plateNumber;
        this.model = model;
    }


}
