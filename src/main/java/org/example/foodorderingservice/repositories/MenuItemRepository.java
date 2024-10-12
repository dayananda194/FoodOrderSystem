package org.example.foodorderingservice.repositories;

import org.example.foodorderingservice.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {



}
