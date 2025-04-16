package org.example.vehicleservice3.DTO;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceReportDTO {
    private String reportId;
    private LocalDate date;
    private String details;
    private String appointmentId;
    private String workerId;

    public ServiceReportDTO(String reportId, LocalDate date, String details, Long id, Long workerId) {
        this.reportId = reportId;
        this.date = date;
        this.details = details;
        this.workerId = workerId.toString();

    }
}
