package org.example.vehicleservice3.Service;

import org.example.vehicleservice3.DTO.ServiceReportDTO;
import org.example.vehicleservice3.Entity.AppointmentEntity;
import org.example.vehicleservice3.Entity.ServiceReport;
import org.example.vehicleservice3.Entity.WorkerEntity;
import org.example.vehicleservice3.Repo.AppointmentRepository;
import org.example.vehicleservice3.Repo.ServiceReportRepository;
import org.example.vehicleservice3.Repo.WorkerRepository;
import org.example.vehicleservice3.Service.ServiceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceReportServiceImpl implements ServiceReportService {

    @Autowired
    private ServiceReportRepository serviceReportRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private WorkerRepository workerRepo;

    @Override
    public void saveServiceReport(ServiceReportDTO dto) {
        ServiceReport report = new ServiceReport();

        AppointmentEntity appointment = appointmentRepo.findById(Long.valueOf(dto.getReportId()))
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        WorkerEntity worker = workerRepo.findById(Long.valueOf(dto.getWorkerId()))
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        report.setAppointment(appointment);
        report.setDate(dto.getDate());
        report.setDetails(dto.getDetails());
        report.setWorker(worker);

        serviceReportRepo.save(report);
    }

    @Override
    public void updateServiceReport(ServiceReportDTO dto) {

    }

    @Override
    public void deleteServiceReport(String id) {

    }

    @Override
    public List<ServiceReportDTO> getAllServiceReports() {
        return List.of();
    }
}
