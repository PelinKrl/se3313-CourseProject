# se3313-CourseProject

## Coffee Brewing Station

### Key Features

- **State Machine Simulation**:
  - The application follows a state machine model with states like `EMPTY`, `IDLE`, `BREWING`, and `DONE`.
  - Transitions between states occur based on user actions, such as pressing buttons to start brewing or reset the machine.

- **Graphical User Interface (GUI)**:
  - The interface is designed with buttons and panels representing different states of the coffee maker.
  - The GUI provides real-time feedback and warnings to users based on their inputs.

- **Database Integration**:
  - MySQL database stores information about the number of cups brewed and the dates of operations.
  - The "Total Cups" feature displays the total number of cups brewed in the current month.

- **Design Patterns Used**:
  - **MVC (Model-View-Controller)**: Separates the application logic, user interface, and input handling for better maintainability.
  - **State Pattern**: Manages the state transitions within the coffee maker.
  - **Observer Pattern**: Notifies the GUI of state changes to update the interface.
  - **Strategy Pattern**: Implements different algorithms for brewing coffee.
  - **Composite Pattern**: Manages complex UI components in a hierarchical structure.
