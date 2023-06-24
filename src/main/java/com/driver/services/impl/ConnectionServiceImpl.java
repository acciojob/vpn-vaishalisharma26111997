package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.ConnectionRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*
;@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Autowired
    UserRepository userRepository2;
    @Autowired
    ServiceProviderRepository serviceProviderRepository2;
    @Autowired
    ConnectionRepository connectionRepository2;

    @Override
    public User connect(int userId, String countryName) throws Exception{
    	User user = userRepository2.findById(userId)
                .orElseThrow(() -> new Exception("User not found with ID: " + userId));
        ServiceProvider serviceProvider = serviceProviderRepository2.findByCountryName(countryName);
        if (serviceProvider == null) {
            throw new Exception("Service Provider not found for country: " + countryName);
        }
        user.setServiceProviderList(new ArrayList<>());
        return userRepository2.save(user);
    }
    @Override
    public User disconnect(int userId) throws Exception {
    	 User user = userRepository2.findById(userId)
                 .orElseThrow(() -> new Exception("User not found with ID: " + userId));
         user.setServiceProviderList(new ArrayList<>());
         return userRepository2.save(user);
    }
    @Override
    public User communicate(int senderId, int receiverId) throws Exception {
    	User sender = userRepository2.findById(senderId)
                .orElseThrow(() -> new Exception("Sender not found with ID: " + senderId));
        User receiver = userRepository2.findById(receiverId)
                .orElseThrow(() -> new Exception("Receiver not found with ID: " + receiverId));

        if (sender.getServiceProviderList() != null && receiver.getServiceProviderList() != null) {
            if (sender.getCountry().equals(receiver.getCountry())) {
                // Communication is possible, perform the necessary actions
                // For example, send a message or establish a connection
            } else {
                throw new Exception("Sender and receiver are not connected to the same country VPN");
            }
        } else {
            throw new Exception("Sender or receiver is not connected to a VPN service");
        }

        return sender;
    }
    }

