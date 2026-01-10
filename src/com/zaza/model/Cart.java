package com.zaza.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItem(FoodItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(FoodItem item) {
        items.remove(item);
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    public double getTotalCost() {
        double total = 0;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "Cart is empty.";
        }
        StringBuilder sb = new StringBuilder("Cart Details:\n");
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            sb.append(String.format("- %s x %d = $%.2f\n",
                    entry.getKey().getName(), entry.getValue(), entry.getKey().getPrice() * entry.getValue()));
        }
        sb.append(String.format("Total Cost: $%.2f", getTotalCost()));
        return sb.toString();
    }
}
