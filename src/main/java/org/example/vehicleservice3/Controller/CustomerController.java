package org.example.vehicleservice3.Controller;


import org.example.vehicleservice3.DTO.CustomerDTO;
import org.example.vehicleservice3.DTO.CustomerLoginDTO;
import org.example.vehicleservice3.Entity.CustomerEntity;
import org.example.vehicleservice3.Repo.CustomerRepository;
import org.example.vehicleservice3.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO dto) {
        return customerService.saveCustomer(dto);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @PostMapping("/customer-login")
    public ResponseEntity<?> loginCustomer(@RequestBody CustomerLoginDTO loginDTO) {
        CustomerEntity customer = customerRepository.findByEmailAndPhone(loginDTO.getEmail(), loginDTO.getPhone());
        if (customer != null) {
            return ResponseEntity.ok().build(); // Login success
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Login failed
        }
    }
}
