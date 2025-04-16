package org.example.vehicleservice3.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.vehicleservice3.Entity.WorkerEntity;

import java.time.LocalDate;

@Getter
@Setter
@Data

@Entity
public class ServiceReport {
    @Id
    private String reportId;
    private LocalDate date;
    private String details;

    @ManyToOne
    private AppointmentEntity appointment;

    @ManyToOne
    private WorkerEntity worker;


}