package org.example.vehicleservice3.Repo;


import org.example.vehicleservice3.Entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findByCustomerId(Long customerId);
}
