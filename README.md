# ZaZa ONLINE FOOD DELIVERY SYSTEM

A console-based food delivery system implemented in Core Java following OOP principles.

# FEATURES:
 ## ADMIN MODULE:
  - Manage Restaurants and Food Items.
  
  - View all orders.
  
  - Manage Delivery Persons and assign them to orders.
    
  ## CUSTOMER MODULE:
  
  - Register/Select customers.
  
  - Browse restaurant menus.
  
  - Manage Cart (add/remove items).
    
  - Place orders and track status.

# HOW TO RUN:
1. Open your terminal.

2. Navigate to the project root directory.

3. Compile the code:
   ```bash
   javac -d bin src/com/zaza/model/*.java src/com/zaza/service/*.java src/com/zaza/main/*.java
   ```
   
4. Run the application:
   ```bash
   java -cp bin com.zaza.main.ZaZaApp
   ```

# PROJECT STRUCTURE:
- `com.zaza.model`: Contains entity classes like `FoodItem`, `User`, `Customer`, `Restaurant`, etc.

- `com.zaza.service`: Contains business logic for handling operations.

- `com.zaza.main`: Main entry point with the menu-driven driver.
