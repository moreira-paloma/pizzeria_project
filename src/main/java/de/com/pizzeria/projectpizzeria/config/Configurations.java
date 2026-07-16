package de.com.pizzeria.projectpizzeria.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
    // Bean é um componente que o Spring Boot consegue controlar
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    // uma classe para apontar quando for chamado o mapper vai ser criado.
}
