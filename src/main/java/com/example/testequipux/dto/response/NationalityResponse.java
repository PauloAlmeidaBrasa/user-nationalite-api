package com.example.testequipux.dto.response;

import java.util.List;

public class NationalityResponse {

    private Long count;
    private String name;
    private List<CountryPrediction> country;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CountryPrediction> getCountry() {
        return country;
    }

    public void setCountry(List<CountryPrediction> country) {
        this.country = country;
    }
}
