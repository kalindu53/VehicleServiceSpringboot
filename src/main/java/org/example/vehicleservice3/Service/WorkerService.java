package org.example.vehicleservice3.Service;

import org.example.vehicleservice3.DTO.WorkerDTO;

import java.util.List;

public interface WorkerService {
    WorkerDTO saveWorker(WorkerDTO dto);
    List<WorkerDTO> getAllWorkers();
    void deleteWorker(Long id);
}
