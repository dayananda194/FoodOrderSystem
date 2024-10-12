package org.example.foodorderingservice.services;

import org.example.foodorderingservice.models.Restaurant;
import org.example.foodorderingservice.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Optional<Restaurant> isRestuarantAlreadyRegistered(Restaurant restaurant)
    {
        Restaurant alreadyExistedRestaurant = restaurantRepository.findByEmail(restaurant.getEmail());
        if(alreadyExistedRestaurant != null)
            return Optional.of(alreadyExistedRestaurant);
        else
        {
            return Optional.empty();
        }
    }
    public Restaurant registerRestaurant(Restaurant restaurant)
    {
       return  restaurantRepository.save(restaurant);
    }



}
