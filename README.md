# Calculator Project

This is a basic Maven project for a simple calculator application.

## Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher

## Getting Started

1. Clone the repository:
    ```sh
    git clone --recursive https://github.com/Jonatan-Perret/POO_Labo6.git
    cd calculator
    ```

2. Build the stack
    ```sh
    cd simple-stack
    mvn clean install
    cd ..
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn exec:java -Dexec.mainClass="ch.heigvd.poo.App"
    ```

## Project Structure

```
calculator
├── pom.xml
├── simple-stack
└── src
    ├── main
    │   ├── java
    │       └── ch
    │           └── heigvd
    │               └── poo
    │                   ├── App.java
    └── test
        ├── java
            └── ch
                └── heigvd
                    └── poo
                        └── AppTest.java
```

## Contributing

1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Make your changes and test them
4. Add your changes (`git add .`)
5. Commit your changes (`git commit -m 'Add new feature'`)
6. Push to the branch (`git push origin feature-branch`)
7. Create a new Pull Request

## License

This project is licensed under the MIT License.