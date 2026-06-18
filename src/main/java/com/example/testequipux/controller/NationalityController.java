package com.example.testequipux.controller;

import com.example.testequipux.dto.response.NationalityResponse;
import com.example.testequipux.service.NationalityService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nationality")
@Validated
public class NationalityController {

    private final NationalityService nationalityService;

    public NationalityController(NationalityService nationalityService) {
        this.nationalityService = nationalityService;
    }

    @GetMapping("/findNacionalityByPerson/{Param}")
    public NationalityResponse findNationalityByPerson(
            @PathVariable("Param")
            @NotBlank(message = "Name is required")
            @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
            @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only letters")
            String name) {
        return nationalityService.findNationalityByName(name);
    }
}
