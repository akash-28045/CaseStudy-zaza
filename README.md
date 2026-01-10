# ZaZa Online Food Delivery System

A console-based food delivery system implemented in Core Java following OOP principles.

## Features
- **Admin Module**:
  - Manage Restaurants and Food Items.
  - View all orders.
  - Manage Delivery Persons and assign them to orders.
- **Customer Module**:
  - Register/Select customers.
  - Browse restaurant menus.
  - Manage Cart (add/remove items).
  - Place orders and track status.

## How to Run
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

## Project Structure
- `com.zaza.model`: Contains entity classes like `FoodItem`, `User`, `Customer`, `Restaurant`, etc.
- `com.zaza.service`: Contains business logic for handling operations.
- `com.zaza.main`: Main entry point with the menu-driven driver.
