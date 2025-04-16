package org.example.vehicleservice3.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class AppointmentEntity {

    @ManyToOne
    @JoinColumn(name = "vehicle_id")  // The foreign key to the vehicle table
    private VehicleEntity vehicle;    // Use this to represent the vehicle entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private LocalDateTime appointmentDate;
    private String status;

}
