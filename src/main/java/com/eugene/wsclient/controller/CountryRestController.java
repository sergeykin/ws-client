package com.eugene.wsclient.controller;

import com.eugene.wsclient.wsClient.CountryClient;
import org.springframework.web.bind.annotation.*;
import wsdl.Country;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryRestController {

    private final CountryClient countryClient;

    public CountryRestController(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryClient.getAllCountries();
    }

    @GetMapping(params = "name")
    public Country getCountryByName(@RequestParam String name) {
        return countryClient.getCountryByName(name);
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryClient.createCountry(country);
    }

    @PutMapping
    public Country updateCountry(@RequestBody Country country) {
        return countryClient.updateCountry(country);
    }

    @DeleteMapping("{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryClient.deleteCountry(id);
    }
}
