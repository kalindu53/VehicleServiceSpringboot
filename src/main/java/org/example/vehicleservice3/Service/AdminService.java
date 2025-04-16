package org.example.vehicleservice3.Service;



import org.example.vehicleservice3.DTO.AdminDTO;

import java.util.List;

public interface AdminService {
    AdminDTO saveAdmin(AdminDTO adminDTO);
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminById(String id);
    void deleteAdmin(String id);
    AdminDTO updateAdmin(AdminDTO adminDTO);
}
