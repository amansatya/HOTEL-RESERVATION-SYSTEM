# Hotel Reservation System

## Overview
This is a **Java-based Hotel Reservation System** that allows users to manage room reservations efficiently. It includes functionalities such as adding, updating, deleting, and viewing reservations. The system interacts with a **database** for persistent storage.

## Features
- **Database Connectivity**: Uses `DatabaseConnection.java` to manage connections.
- **CRUD Operations**:
   - **Reserve a Room** (`ReserveRoom.java`)
   - **Update a Reservation** (`UpdateReservation.java`)
   - **Delete a Reservation** (`DeleteReservation.java`)
   - **View Reservations** (`ViewReservations.java`)
   - **Exit Option**: Added in the reservation system for better usability.
- **Room Management**:
   - Fetch available rooms (`GetRoomNumber.java`)
- **User Interface**:
   - Main menu (`MainMenu.java`)

## File Structure
```
/HotelReservationSystem
│── .gitignore             # Excludes compiled class files
│── DatabaseConnection.java  # Manages database connection
│── DeleteReservation.java   # Deletes existing reservations
│── GetRoomNumber.java       # Retrieves available room numbers
│── MainMenu.java            # Main menu for user navigation
│── README.md                # Documentation file
│── ReserveRoom.java         # Handles new room reservations
│── UpdateReservation.java   # Updates existing reservations
│── ViewReservations.java    # Displays current reservations
│── .idea/                   # IDE-specific settings (should be ignored)
```

## Tech Stack
- **Java**: Core programming language
- **Swing**: GUI framework for the application
- **MySQL**: Database for storing reservations
- **Git**: Version control system
- **IntelliJ IDEA**: IDE for development

## How to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/yourusername/HotelReservationSystem.git
   cd HotelReservationSystem
   ```
2. **Compile the Java Files**
   ```sh
   javac *.java
   ```
3. **Run the Main Program**
   ```sh
   java MainMenu
   ```

## Contribution
Feel free to fork this repository and submit pull requests with improvements or additional features.

## License
This project is open-source and available under the MIT License.
