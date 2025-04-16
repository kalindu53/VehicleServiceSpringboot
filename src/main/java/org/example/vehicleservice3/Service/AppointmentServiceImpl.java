package org.example.vehicleservice3.Service;

import org.example.vehicleservice3.DTO.AppointmentDTO;
import org.example.vehicleservice3.Entity.AppointmentEntity;
import org.example.vehicleservice3.Entity.VehicleEntity;
import org.example.vehicleservice3.Repo.AppointmentRepository;
import org.example.vehicleservice3.Repo.VehicleRepository;  // Assuming you have this repository to fetch Vehicle data
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private VehicleRepository vehicleRepository;  // Assuming you have this repository to fetch Vehicle data

    @Override
    public AppointmentDTO saveAppointment(AppointmentDTO dto) {
        // Retrieve the vehicle using the vehicleId (if necessary)
        VehicleEntity vehicle = vehicleRepository.findById(dto.getVehicleId()).orElse(null);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found for id: " + dto.getVehicleId());
        }

        AppointmentEntity entity = new AppointmentEntity();
        entity.setCustomerId(dto.getCustomerId());
        entity.setVehicle(vehicle);  // Set the vehicle object
        entity.setAppointmentDate(dto.getAppointmentDate());
        entity.setStatus("Scheduled");

        AppointmentEntity saved = repository.save(entity);
        return new AppointmentDTO(saved.getId(), saved.getCustomerId(), saved.getVehicle().getId(), saved.getAppointmentDate(), saved.getStatus());
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId).stream().map(a ->
                new AppointmentDTO(a.getId(), a.getCustomerId(), a.getVehicle().getId(), a.getAppointmentDate(), a.getStatus())
        ).collect(Collectors.toList());
    }

    @Override
    public void cancelAppointment(Long id) {
        AppointmentEntity appointment = repository.findById(id).orElse(null);
        if (appointment != null) {
            appointment.setStatus("Cancelled");
            repository.save(appointment);
        }
    }
}
