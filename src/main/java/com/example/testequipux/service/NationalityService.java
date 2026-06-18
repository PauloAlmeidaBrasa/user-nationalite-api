package com.example.testequipux.service;

import com.example.testequipux.dto.response.NationalityResponse;

public interface NationalityService {

    NationalityResponse findNationalityByName(String name);
}
