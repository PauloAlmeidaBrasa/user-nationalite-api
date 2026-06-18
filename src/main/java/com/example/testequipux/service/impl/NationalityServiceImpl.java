package com.example.testequipux.service.impl;

import com.example.testequipux.dto.response.NationalityResponse;
import com.example.testequipux.service.NationalityService;
import com.example.testequipux.service.helper.NationalityApiHelper;
import org.springframework.stereotype.Service;

@Service
public class NationalityServiceImpl implements NationalityService {

    private final NationalityApiHelper nationalityApiHelper;

    public NationalityServiceImpl(NationalityApiHelper nationalityApiHelper) {
        this.nationalityApiHelper = nationalityApiHelper;
    }

    @Override
    public NationalityResponse findNationalityByName(String name) {
        return nationalityApiHelper.getNationalityByName(name);
    }
}
