package org.example.vehicleservice3.Service;


import org.example.vehicleservice3.DTO.CustomerDTO;
import org.example.vehicleservice3.Entity.CustomerEntity;
import org.example.vehicleservice3.Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        CustomerEntity saved = repository.save(entity);
        return new CustomerDTO(saved.getId(), saved.getName(), saved.getEmail(), saved.getPhone());
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return repository.findAll().stream().map(c ->
                new CustomerDTO(c.getId(), c.getName(), c.getEmail(), c.getPhone())
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
