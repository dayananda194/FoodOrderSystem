package org.example.foodorderingservice.controllers;

import org.example.foodorderingservice.models.MenuItem;
import org.example.foodorderingservice.models.Restaurant;
import org.example.foodorderingservice.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller


@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @PostMapping("/register")
    public ResponseEntity<Restaurant> registerRestaurant(@RequestBody Restaurant restaurant) {


           Optional<Restaurant> alreadyExistedRestaurant =  restaurantService.isRestuarantAlreadyRegistered(restaurant);
           if (alreadyExistedRestaurant.isPresent())
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(alreadyExistedRestaurant.get());

           Restaurant newRestaurant = restaurantService.registerRestaurant(restaurant);
           return ResponseEntity.status(HttpStatus.CREATED).body(newRestaurant);


    }

    @GetMapping("/")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {

        List<Restaurant> restaurantList = restaurantService.getAllRestuarants();

        if(!restaurantList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(restaurantList);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restaurantList);


    }




}
