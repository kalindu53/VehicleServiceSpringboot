package org.example.vehicleservice3.Controller;

import org.example.vehicleservice3.DTO.WorkerDTO;
import org.example.vehicleservice3.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin(origins = "*")
public class WorkerController {

    @Autowired
    private WorkerService service;

    @PostMapping
    public WorkerDTO saveWorker(@RequestBody WorkerDTO dto) {
        return service.saveWorker(dto);
    }

    @GetMapping
    public List<WorkerDTO> getAllWorkers() {
        return service.getAllWorkers();
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id) {
        service.deleteWorker(id);
    }
}
