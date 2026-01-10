package com.zaza.service;

import com.zaza.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    private List<Order> orders;
    private List<DeliveryPerson> deliveryPeople;
    private int nextOrderId = 1;

    public OrderService() {
        this.orders = new ArrayList<>();
        this.deliveryPeople = new ArrayList<>();
    }

    public Order placeOrder(Customer customer, String address) {
        Cart cart = customer.getCart();
        if (cart.getItems().isEmpty()) {
            return null;
        }

        Order order = new Order(nextOrderId++, customer, address);
        for (Map.Entry<FoodItem, Integer> entry : cart.getItems().entrySet()) {
            order.addItem(entry.getKey(), entry.getValue());
        }

        orders.add(order);
        cart.clear(); // Clear cart after placing order
        return order;
    }

    public void addDeliveryPerson(DeliveryPerson person) {
        deliveryPeople.add(person);
    }

    public List<DeliveryPerson> getAllDeliveryPeople() {
        return deliveryPeople;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order findOrderById(int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id)
                return o;
        }
        return null;
    }

    public DeliveryPerson findDeliveryPersonById(int id) {
        for (DeliveryPerson p : deliveryPeople) {
            if (p.getDeliveryPersonId() == id)
                return p;
        }
        return null;
    }

    public void assignDeliveryPerson(int orderId, int deliveryPersonId) {
        Order order = findOrderById(orderId);
        DeliveryPerson person = findDeliveryPersonById(deliveryPersonId);

        if (order != null && person != null) {
            order.setDeliveryPerson(person);
            order.setStatus("Assigned");
        }
    }

    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order o : orders) {
            if (o.getCustomer().getUserId() == customerId) {
                customerOrders.add(o);
            }
        }
        return customerOrders;
    }
}
