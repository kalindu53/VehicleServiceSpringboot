package org.example.vehicleservice3.Service;


import org.example.vehicleservice3.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO dto);
    List<CustomerDTO> getAllCustomers();
    void deleteCustomer(Long id);
}
