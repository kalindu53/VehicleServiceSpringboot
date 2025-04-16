package org.example.vehicleservice3.DTO;


import lombok.*;


@Data
@Getter
@Setter

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;

    // Constructors
    public CustomerDTO() {}

    public CustomerDTO(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters & Setters
    // ...
}
