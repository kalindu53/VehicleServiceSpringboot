package org.example.vehicleservice3.Controller;

import org.example.vehicleservice3.DTO.VhServiceDTO;

import org.example.vehicleservice3.Service.VhServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vhservices")
@CrossOrigin(origins = "*")
public class VhServiceController {

    @Autowired
    private VhServiceService service;

    @PostMapping
    public void save(@RequestBody VhServiceDTO dto) {
        service.save(dto);
    }

    @PutMapping
    public void update(@RequestBody VhServiceDTO dto) {
        service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public VhServiceDTO getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<VhServiceDTO> getAll() {
        return service.getAll();
    }
}
