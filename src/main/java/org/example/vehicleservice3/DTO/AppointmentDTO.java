package org.example.vehicleservice3.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter

public class AppointmentDTO {
    private Long id;
    private Long customerId;
    private Long vehicleId;
    private LocalDateTime appointmentDate;
    private String status; // e.g., "Scheduled", "Completed", "Cancelled"

    // Constructors
    public AppointmentDTO() {}

    public AppointmentDTO(Long id, Long customerId, Long vehicleId, LocalDateTime appointmentDate, String status) {
        this.id = id;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }


}
