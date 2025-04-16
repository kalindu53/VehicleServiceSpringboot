package org.example.vehicleservice3.Service;


import org.example.vehicleservice3.DTO.VhServiceDTO;
import org.example.vehicleservice3.Entity.VhService;
import org.example.vehicleservice3.Repo.VhServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VhServiceServiceImpl implements VhServiceService {

    @Autowired
    private VhServiceRepository repository;

    @Override
    public void save(VhServiceDTO dto) {
        repository.save(new VhService(
                dto.getServiceId(),
                dto.getServiceName(),
                dto.getPrice(),
                dto.getDescription()
        ));
    }

    @Override
    public void update(VhServiceDTO dto) {
        repository.save(new VhService(
                dto.getServiceId(),
                dto.getServiceName(),
                dto.getPrice(),
                dto.getDescription()
        ));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public VhServiceDTO getById(String id) {
        VhService service = repository.findById(id).orElse(null);
        if (service == null) return null;

        return new VhServiceDTO(
                service.getServiceId(),
                service.getServiceName(),
                service.getPrice(),
                service.getDescription()
        );
    }

    @Override
    public List<VhServiceDTO> getAll() {
        return repository.findAll().stream().map(service ->
                new VhServiceDTO(
                        service.getServiceId(),
                        service.getServiceName(),
                        service.getPrice(),
                        service.getDescription()
                )
        ).collect(Collectors.toList());
    }
}
