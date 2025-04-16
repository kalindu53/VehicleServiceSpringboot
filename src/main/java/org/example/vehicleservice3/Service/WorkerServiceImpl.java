package org.example.vehicleservice3.Service;

import org.example.vehicleservice3.DTO.WorkerDTO;


import org.example.vehicleservice3.Entity.WorkerEntity;
import org.example.vehicleservice3.Repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository repository;

    @Override
    public WorkerDTO saveWorker(WorkerDTO dto) {
        WorkerEntity entity = new WorkerEntity();
        entity.setWorkerId(dto.getWorkerId());
        entity.setName(dto.getName());
        entity.setRole(dto.getRole());
        entity.setEmail(dto.getEmail());

        WorkerEntity saved = repository.save(entity);
        return new WorkerDTO(saved.getWorkerId(), saved.getName(), saved.getRole(), saved.getEmail());
    }

    @Override
    public List<WorkerDTO> getAllWorkers() {
        return repository.findAll().stream()
                .map(w -> new WorkerDTO(w.getWorkerId(), w.getName(), w.getRole(), w.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteWorker(Long id) {
        repository.deleteById(id);
    }
}
