package org.example.foodorderingservice.controllers;

import org.example.foodorderingservice.DTOs.MenuItemDTO;
import org.example.foodorderingservice.models.MenuItem;
import org.example.foodorderingservice.models.Restaurant;
import org.example.foodorderingservice.services.MenuItemService;
import org.example.foodorderingservice.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.management.MemoryNotificationInfo;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/restaurants")
public class MenuItemController {

    private MenuItemService menuItemService;
    private RestaurantService restaurantService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService,RestaurantService restaurantService) {
        this.menuItemService = menuItemService;
        this.restaurantService   = restaurantService;
    }

    @GetMapping("/menu-items")
    public ResponseEntity<List<MenuItem>> getMenuItems(){

        List<MenuItem> menuItems = menuItemService.getAllMenuItems();

        if(!menuItems.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(menuItems);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(menuItems);

    }

    @PostMapping("/menu-items")

    public  ResponseEntity<?> createMenuItem(@RequestBody MenuItem menuItem){

        Long restaurant_id = menuItem.getRestaurant().getId();
        Optional<Restaurant> restaurant =  restaurantService.findRestuarantById(restaurant_id);

        // Check if the corresponding restaurant is already registered or not

        if(!restaurant.isPresent()){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Restaurant with "+restaurant_id+" not found");
        }

        MenuItem newMenuItem = menuItemService.registerMenu(menuItem);
        if(newMenuItem!=null)
        {
            MenuItemDTO menuItemDTO = new MenuItemDTO(newMenuItem,restaurant.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(menuItemDTO);

        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);


    }

}
