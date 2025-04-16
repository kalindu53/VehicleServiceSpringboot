package org.example.vehicleservice3.Service;

import org.example.vehicleservice3.DTO.ServiceReportDTO;

import java.util.List;

public interface ServiceReportService {
    void saveServiceReport(ServiceReportDTO dto);
    void updateServiceReport(ServiceReportDTO dto);
    void deleteServiceReport(String id);
    List<ServiceReportDTO> getAllServiceReports();
}
