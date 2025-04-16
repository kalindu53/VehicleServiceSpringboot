package org.example.vehicleservice3.Controller;


import org.example.vehicleservice3.DTO.AdminDTO;
import org.example.vehicleservice3.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDTO> saveAdmin(@RequestBody AdminDTO dto) {
        return ResponseEntity.ok(adminService.saveAdmin(dto));
    }

    @GetMapping
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getAdmin(@PathVariable String id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    @PutMapping
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO dto) {
        return ResponseEntity.ok(adminService.updateAdmin(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable String id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }
}
