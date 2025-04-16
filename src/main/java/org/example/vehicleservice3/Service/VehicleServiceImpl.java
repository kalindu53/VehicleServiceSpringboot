package org.example.vehicleservice3.Service;

import org.example.vehicleservice3.DTO.VehicleDTO;
import org.example.vehicleservice3.Entity.VehicleEntity;
import org.example.vehicleservice3.Entity.CustomerEntity; // Import the CustomerEntity
import org.example.vehicleservice3.Repo.VehicleRepository;
import org.example.vehicleservice3.Repo.CustomerRepository; // Add the CustomerRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CustomerRepository customerRepository; // Inject the CustomerRepository

    @Override
    public VehicleDTO saveVehicle(VehicleDTO dto) {
        // Fetch the customer from the database using customerId
        CustomerEntity customerEntity = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Create a new VehicleEntity and set the customer entity
        VehicleEntity entity = new VehicleEntity();
        entity.setCustomer(customerEntity); // Set the customer as an object
        entity.setPlateNumber(dto.getPlateNumber());
        entity.setModel(dto.getModel());

        // Save the vehicle entity
        VehicleEntity saved = vehicleRepository.save(entity);

        // Return the saved vehicle data in DTO form
        return new VehicleDTO(saved.getId(), saved.getCustomer().getId(), saved.getPlateNumber(), saved.getModel());
    }

    @Override
    public List<VehicleDTO> getVehiclesByCustomerId(Long customerId) {
        return vehicleRepository.findByCustomerId(customerId).stream().map(v ->
                new VehicleDTO(v.getId(), v.getCustomer().getId(), v.getPlateNumber(), v.getModel())
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
