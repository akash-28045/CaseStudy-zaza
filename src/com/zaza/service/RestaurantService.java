package com.zaza.service;

import com.zaza.model.FoodItem;
import com.zaza.model.Restaurant;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private List<Restaurant> restaurants;

    public RestaurantService() {
        this.restaurants = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }

    public Restaurant findRestaurantById(int id) {
        for (Restaurant r : restaurants) {
            if (r.getId() == id)
                return r;
        }
        return null;
    }

    public FoodItem findFoodItemInRestaurant(Restaurant r, int foodId) {
        for (FoodItem item : r.getMenu()) {
            if (item.getId() == foodId)
                return item;
        }
        return null;
    }
}
