package com.zaza.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderId;
    private Customer customer;
    private Map<FoodItem, Integer> items;
    private String status;
    private DeliveryPerson deliveryPerson;
    private String deliveryAddress;

    public Order(int orderId, Customer customer, String deliveryAddress) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>();
        this.status = "Pending";
        this.deliveryAddress = deliveryAddress;
    }

    public void addItem(FoodItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    public void setItems(Map<FoodItem, Integer> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order ID: %d\n", orderId));
        sb.append(String.format("Customer: %s\n", customer.getUsername()));
        sb.append(String.format("Status: %s\n", status));
        sb.append(String.format("Address: %s\n", deliveryAddress));
        if (deliveryPerson != null) {
            sb.append(String.format("Delivery Person: %s (%d)\n", deliveryPerson.getName(),
                    deliveryPerson.getContactNo()));
        } else {
            sb.append("Delivery Person: Not Assigned\n");
        }
        sb.append("Items:\n");
        double total = 0;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            double cost = entry.getKey().getPrice() * entry.getValue();
            sb.append(String.format("  - %-15s x %d = $%.2f\n", entry.getKey().getName(), entry.getValue(), cost));
            total += cost;
        }
        sb.append(String.format("Total: $%.2f\n", total));
        return sb.toString();
    }
}
