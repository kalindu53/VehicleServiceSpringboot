package org.example.vehicleservice3.Controller;

import lombok.RequiredArgsConstructor;
import org.example.vehicleservice3.DTO.ServiceReportDTO;
import org.example.vehicleservice3.Service.ServiceReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-reports")
@CrossOrigin
@RequiredArgsConstructor
public class ServiceReportController {

    private final ServiceReportService service;

    @PostMapping
    public void save(@RequestBody ServiceReportDTO dto) {
        service.saveServiceReport(dto);
    }

    @PutMapping
    public void update(@RequestBody ServiceReportDTO dto) {
        service.updateServiceReport(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteServiceReport(id);
    }

    @GetMapping
    public List<ServiceReportDTO> getAll() {
        return service.getAllServiceReports();
    }
}
