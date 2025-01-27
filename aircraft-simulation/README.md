# Aircraft Simulation Project

This project simulates different types of aircraft and their interactions with a weather tower. It includes various aircraft classes such as helicopters, airplanes, and balloons, each implementing specific flying behaviors. The simulation also incorporates a weather tower that manages the status of these flyable aircraft.

## Project Structure

```
aircraft-simulation
├── src
│   ├── Aircraft
│   │   ├── Aircraft.java
│   │   ├── Helicopter.java
│   │   ├── Airplane.java
│   │   └── Balloon.java
│   ├── Weather
│   │   ├── WeatherTower.java
│   │   └── WeatherProvider.java
│   ├── Flyable
│   │   └── Flyable.java
│   └── Main.java
├── .gitignore
└── README.md
```

## Setup Instructions

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```
   cd aircraft-simulation
   ```

3. Compile the Java files:
   ```
   javac src/**/*.java
   ```

4. Run the simulation:
   ```
   java src/Main
   ```

## Overview

- **Aircraft**: An abstract class representing common properties and methods for all aircraft.
- **Helicopter**: A class that extends `Aircraft` and implements helicopter-specific flying behavior.
- **Airplane**: A class that extends `Aircraft` and implements airplane-specific flying behavior.
- **Balloon**: A class that extends `Aircraft` and implements balloon-specific flying behavior.
- **WeatherTower**: A class that manages the weather conditions and the registered flyable aircraft.
- **WeatherProvider**: A class that provides current weather information.
- **Flyable**: An interface that defines the methods required for any flyable object.
- **Main**: The entry point of the simulation that creates instances and runs the interactions.

## Contributing

Feel free to submit issues or pull requests for improvements or additional features.