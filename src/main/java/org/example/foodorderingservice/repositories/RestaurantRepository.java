package org.example.foodorderingservice.repositories;

import org.example.foodorderingservice.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    public Restaurant findByEmail(String email);

}
