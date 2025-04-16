package org.example.vehicleservice3.Service;


import org.example.vehicleservice3.DTO.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO saveAppointment(AppointmentDTO dto);
    List<AppointmentDTO> getAppointmentsByCustomerId(Long customerId);
    void cancelAppointment(Long id);
}
