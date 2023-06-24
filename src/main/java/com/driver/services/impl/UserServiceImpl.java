package com.driver.services.impl;

import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.model.User;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception{
    	Country country = countryRepository3.findByName(CountryName.valueOf(countryName));
        if (country == null) {
            throw new Exception("Country not found with name: " + countryName);
        }

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setCountry(country);
        return userRepository3.save(user);
    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) throws Exception {
    	 Optional<User> optionalUser = userRepository3.findById(userId);
         if (optionalUser.isPresent()) {
             User user = optionalUser.get();
             ServiceProvider serviceProvider = serviceProviderRepository3.findById(serviceProviderId)
                     .orElseThrow(() -> new Exception("Service Provider not found with ID: " + serviceProviderId));
             user.setServiceProviderList(new ArrayList<>());
             return userRepository3.save(user);
         } else {
             throw new Exception("User not found with ID: " + userId);
         }
     }
    
}
