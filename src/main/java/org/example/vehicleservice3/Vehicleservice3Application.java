package org.example.vehicleservice3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Vehicleservice3Application {

    public static void main(String[] args) {
        SpringApplication.run(Vehicleservice3Application.class, args);
    }


    @Bean

    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
