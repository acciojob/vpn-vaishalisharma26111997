package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.Country;
import com.driver.model.CountryName;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	Country findByName(CountryName countryName);
}
