package com.zaza.main;

import com.zaza.model.*;
import com.zaza.service.*;

import java.util.List;
import java.util.Scanner;

public class ZaZaApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RestaurantService restaurantService = new RestaurantService();
    private static final CustomerService customerService = new CustomerService();
    private static final OrderService orderService = new OrderService();

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     WELCOME TO ZAZA FOOD DELIVERY      ");
        System.out.println("========================================");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for using ZaZa! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void adminMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Admin Module ---");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View All Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit Admin Module");
            System.out.print("Select an option: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int rId = readInt();
                    System.out.print("Enter Restaurant Name: ");
                    String rName = scanner.nextLine();
                    restaurantService.addRestaurant(new Restaurant(rId, rName));
                    System.out.println("Restaurant added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int resId = readInt();
                    Restaurant res = restaurantService.findRestaurantById(resId);
                    if (res != null) {
                        System.out.print("Enter Food Item ID: ");
                        int fId = readInt();
                        System.out.print("Enter Food Name: ");
                        String fName = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = readDouble();
                        res.addFoodItem(new FoodItem(fId, fName, price));
                        System.out.println("Food item added!");
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    int resId2 = readInt();
                    Restaurant res2 = restaurantService.findRestaurantById(resId2);
                    if (res2 != null) {
                        System.out.print("Enter Food Item ID to remove: ");
                        int fIdRem = readInt();
                        res2.removeFoodItem(fIdRem);
                        System.out.println("Food item removed (if it existed).");
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;
                case 4:
                    List<Restaurant> restaurants = restaurantService.getAllRestaurants();
                    if (restaurants.isEmpty()) {
                        System.out.println("No restaurants available.");
                    } else {
                        for (Restaurant r : restaurants) {
                            System.out.println(r);
                        }
                    }
                    break;
                case 5:
                    List<Order> orders = orderService.getAllOrders();
                    if (orders.isEmpty()) {
                        System.out.println("No orders placed yet.");
                    } else {
                        for (Order o : orders) {
                            System.out.println(o);
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter Delivery Person ID: ");
                    int dpId = readInt();
                    System.out.print("Enter Name: ");
                    String dpName = scanner.nextLine();
                    System.out.print("Enter Contact No: ");
                    long dpContact = readLong();
                    orderService.addDeliveryPerson(new DeliveryPerson(dpId, dpName, dpContact));
                    System.out.println("Delivery person added.");
                    break;
                case 7:
                    System.out.print("Enter Order ID: ");
                    int oId = readInt();
                    System.out.print("Enter Delivery Person ID: ");
                    int dId = readInt();
                    orderService.assignDeliveryPerson(oId, dId);
                    System.out.println("Assignment attempted.");
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void customerMenu() {
        boolean exit = false;
        Customer currentCustomer = null;

        while (!exit) {
            System.out.println("\n--- Customer Module ---");
            if (currentCustomer == null) {
                System.out.println("1. Add/Select Customer");
                System.out.println("7. Exit Customer Module");
            } else {
                System.out.println("Selected Customer: " + currentCustomer.getUsername());
                System.out.println("1. Switch/Add Customer");
                System.out.println("2. View Food Items (by restaurant)");
                System.out.println("3. Add Food Item to Cart");
                System.out.println("4. View Cart with total price");
                System.out.println("5. Place Order");
                System.out.println("6. View Orders with status");
                System.out.println("7. Exit Customer Module");
            }
            System.out.print("Select an option: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int cId = readInt();
                    currentCustomer = customerService.findCustomerById(cId);
                    if (currentCustomer == null) {
                        System.out.print("New Customer! Enter Name: ");
                        String cName = scanner.nextLine();
                        System.out.print("Enter Contact No: ");
                        long cContact = readLong();
                        currentCustomer = new Customer(cId, cName, cContact);
                        customerService.addCustomer(currentCustomer);
                        System.out.println("Customer registered.");
                    } else {
                        System.out.println("Welcome back, " + currentCustomer.getUsername());
                    }
                    break;
                case 2:
                    if (currentCustomer == null) {
                        System.out.println("Please select a customer first.");
                        break;
                    }
                    System.out.print("Enter Restaurant ID to view menu: ");
                    int rId = readInt();
                    Restaurant r = restaurantService.findRestaurantById(rId);
                    if (r != null) {
                        System.out.println(r);
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;
                case 3:
                    if (currentCustomer == null) {
                        System.out.println("Please select a customer first.");
                        break;
                    }
                    System.out.print("Enter Restaurant ID: ");
                    int resId = readInt();
                    Restaurant res = restaurantService.findRestaurantById(resId);
                    if (res != null) {
                        System.out.print("Enter Food Item ID: ");
                        int fId = readInt();
                        FoodItem item = restaurantService.findFoodItemInRestaurant(res, fId);
                        if (item != null) {
                            System.out.print("Enter Quantity: ");
                            int qty = readInt();
                            currentCustomer.getCart().addItem(item, qty);
                            System.out.println("Added to cart!");
                        } else {
                            System.out.println("Food item not found in this restaurant.");
                        }
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;
                case 4:
                    if (currentCustomer == null) {
                        System.out.println("Please select a customer first.");
                        break;
                    }
                    System.out.println(currentCustomer.getCart());
                    break;
                case 5:
                    if (currentCustomer == null) {
                        System.out.println("Please select a customer first.");
                        break;
                    }
                    if (currentCustomer.getCart().getItems().isEmpty()) {
                        System.out.println("Cart is empty. Add items before placing an order.");
                    } else {
                        System.out.print("Enter Delivery Address: ");
                        String address = scanner.nextLine();
                        Order order = orderService.placeOrder(currentCustomer, address);
                        System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
                    }
                    break;
                case 6:
                    if (currentCustomer == null) {
                        System.out.println("Please select a customer first.");
                        break;
                    }
                    List<Order> myOrders = orderService.getOrdersByCustomer(currentCustomer.getUserId());
                    if (myOrders.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        for (Order o : myOrders) {
                            System.out.println(o);
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Helper methods for robust input
    private static int readInt() {
        int val = -1;
        try {
            val = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return val;
    }

    private static double readDouble() {
        double val = -1;
        try {
            val = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid decimal number.");
        }
        return val;
    }

    private static long readLong() {
        long val = -1;
        try {
            val = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid long number.");
        }
        return val;
    }
}
