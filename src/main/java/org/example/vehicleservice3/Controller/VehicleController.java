package org.example.vehicleservice3.Controller;


import org.example.vehicleservice3.DTO.VehicleDTO;
import org.example.vehicleservice3.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public VehicleDTO saveVehicle(@RequestBody VehicleDTO dto) {
        return vehicleService.saveVehicle(dto);
    }

    @GetMapping("/customer/{customerId}")
    public List<VehicleDTO> getVehiclesByCustomerId(@PathVariable Long customerId) {
        return vehicleService.getVehiclesByCustomerId(customerId);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
}
