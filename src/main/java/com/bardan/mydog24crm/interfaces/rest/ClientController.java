package com.bardan.mydog24crm.interfaces.rest;

import com.bardan.mydog24crm.application.DogService;
import com.bardan.mydog24crm.domain.Dog;
import com.bardan.mydog24crm.interfaces.rest.dto.DogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final DogService dogService;

    @GetMapping
    public List<DogDto> findClients(@RequestParam("q") String q) {
        Iterable<Dog> dogs = dogService.findDogByNameOrTelephone(q);
        return StreamSupport.stream(dogs.spliterator(), false)
                .map(DogDto::from) // Using the new factory method
                .collect(Collectors.toList());
    }
}
