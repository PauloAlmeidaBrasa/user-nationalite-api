package com.example.testequipux.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryPrediction {

    @JsonProperty("country_id")
    private String countryId;

    private Double probability;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}
