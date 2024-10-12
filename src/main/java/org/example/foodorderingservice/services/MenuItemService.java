package org.example.foodorderingservice.services;

import org.example.foodorderingservice.models.MenuItem;
import org.example.foodorderingservice.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;

@Service
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getAllMenuItems()
    {

            return menuItemRepository.findAll();
    }

    public MenuItem registerMenu(MenuItem menuItem)
    {

        return menuItemRepository.save(menuItem);

    }

}
