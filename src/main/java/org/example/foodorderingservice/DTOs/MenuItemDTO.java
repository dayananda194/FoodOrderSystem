package org.example.foodorderingservice.DTOs;

import lombok.*;
import org.example.foodorderingservice.models.MenuItem;
import org.example.foodorderingservice.models.Restaurant;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItemDTO {

    private Long id;
    private String name;
    private int availableQuantity;
    private double price;
    private Date createdAt;
    private Date updatedAt;

    private String restaurantName;
    private String restaurantEmail;
    private Long restaurantId;

    public MenuItemDTO(MenuItem menuItem, Restaurant restaurant) {

        this.id = menuItem.getId();
        this.name = menuItem.getName();
        this.restaurantName = restaurant.getName();
        this.restaurantId = restaurant.getId();
        this.restaurantEmail = restaurant.getEmail();
        this.availableQuantity = menuItem.getAvailableQuantity();
        this.price = menuItem.getPrice();
        this.createdAt = menuItem.getCreatedAt();
        this.updatedAt = menuItem.getUpdatedAt();

    }


}
