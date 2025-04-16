package org.example.vehicleservice3.service.impl;

import org.example.vehicleservice3.DTO.AdminDTO;
import org.example.vehicleservice3.Entity.Admin;

import org.example.vehicleservice3.Repo.AdminRepository;
import org.example.vehicleservice3.Service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AdminDTO saveAdmin(AdminDTO dto) {
        Admin admin = mapper.map(dto, Admin.class);
        adminRepo.save(admin);
        return dto;
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return adminRepo.findAll().stream()
                .map(admin -> mapper.map(admin, AdminDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdminDTO getAdminById(String id) {
        Admin admin = adminRepo.findById(id).orElse(null);
        return mapper.map(admin, AdminDTO.class);
    }

    @Override
    public void deleteAdmin(String id) {
        adminRepo.deleteById(id);
    }

    @Override
    public AdminDTO updateAdmin(AdminDTO dto) {
        Admin admin = mapper.map(dto, Admin.class);
        adminRepo.save(admin);
        return dto;
    }
}
