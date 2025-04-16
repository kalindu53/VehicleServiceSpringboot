package org.example.vehicleservice3.Repo;



import org.example.vehicleservice3.Entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    List<AppointmentEntity> findByCustomerId(Long customerId);
}
