package org.example.vehicleservice3.Controller;


import org.example.vehicleservice3.DTO.AppointmentDTO;
import org.example.vehicleservice3.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO saveAppointment(@RequestBody AppointmentDTO dto) {
        return appointmentService.saveAppointment(dto);
    }

    @GetMapping("/customer/{customerId}")
    public List<AppointmentDTO> getAppointmentsByCustomerId(@PathVariable Long customerId) {
        return appointmentService.getAppointmentsByCustomerId(customerId);
    }

    @PutMapping("/cancel/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
    }
}
