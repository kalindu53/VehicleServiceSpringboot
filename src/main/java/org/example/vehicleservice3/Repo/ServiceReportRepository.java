package org.example.vehicleservice3.Repo;

import org.example.vehicleservice3.Entity.ServiceReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceReportRepository extends JpaRepository<ServiceReport, String> {
}
