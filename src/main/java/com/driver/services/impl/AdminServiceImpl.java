package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.*
;@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
    	Admin admin=new Admin();
    	admin.setPassword(password);
    	admin.setUserName(username);
    	admin.setServiceProviders(new ArrayList<>());
    	return adminRepository1.save(admin);
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) throws Exception {
    	Optional<Admin> optionalAdmin = adminRepository1.findById(adminId);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            ServiceProvider serviceProvider = new ServiceProvider();
            serviceProvider.setName(providerName);
            admin.getServiceProviders().add(serviceProvider);
            return adminRepository1.save(admin);
        } else {
            throw new Exception("Admin not found with ID: " + adminId);
        }
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
    	
    	 Optional<ServiceProvider> optionalServiceProvider = serviceProviderRepository1.findById(serviceProviderId);
         if (optionalServiceProvider.isPresent()) {
             ServiceProvider serviceProvider = optionalServiceProvider.get();
             Country country = new Country(); 
             country.setCountryName(CountryName.valueOf(countryName));
             country.setServiceProvider(serviceProvider);
             countryRepository1.save(country);
             return serviceProvider;
         } else {
             throw new Exception("Service Provider not found with ID: " + serviceProviderId);
         }
     }
    }

