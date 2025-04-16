package org.example.vehicleservice3.Controller;

import org.example.vehicleservice3.Entity.Admin;
import org.example.vehicleservice3.Repo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Optional<Admin> adminOpt = adminRepository.findByEmailAndPassword(email, password);

        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();

            // Example: return role as part of response
            String role = "admin"; // You can customize this by role field if available
            return ResponseEntity.ok(Map.of(
                    "adminId", admin.getAdminId(),
                    "name", admin.getName(),
                    "email", admin.getEmail(),
                    "role", role
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
