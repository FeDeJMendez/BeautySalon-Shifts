package com.CodingDesign.BeautySalonShifts.config;

import com.CodingDesign.BeautySalonShifts.interfaces.URIinterface;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Configuration
public class Conf {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static <T extends URIinterface> URI getLocation (T Obj){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(Obj.getId())
                .toUri();
    }
}
