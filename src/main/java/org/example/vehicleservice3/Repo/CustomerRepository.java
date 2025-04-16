package org.example.vehicleservice3.Repo;


import org.example.vehicleservice3.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmailAndPhone(String email, String phone);

}
