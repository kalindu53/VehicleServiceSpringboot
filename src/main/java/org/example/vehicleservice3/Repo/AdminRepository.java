package org.example.vehicleservice3.Repo;

import org.example.vehicleservice3.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, String> {

    Optional<Admin> findByEmailAndPassword(String email, String password);
}
