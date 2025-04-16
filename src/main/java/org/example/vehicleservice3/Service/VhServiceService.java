package org.example.vehicleservice3.Service;

import org.example.vehicleservice3.DTO.VhServiceDTO;

import java.util.List;

public interface VhServiceService {
    void save(VhServiceDTO dto);
    void update(VhServiceDTO dto);
    void delete(String id);
    VhServiceDTO getById(String id);
    List<VhServiceDTO> getAll();
}
