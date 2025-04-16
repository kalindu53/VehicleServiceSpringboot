package org.example.vehicleservice3.Service;


import org.example.vehicleservice3.DTO.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO dto);
    List<VehicleDTO> getVehiclesByCustomerId(Long customerId);
    void deleteVehicle(Long id);
}
