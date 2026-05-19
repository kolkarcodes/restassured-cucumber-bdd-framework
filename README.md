# restassured-cucumber-bdd-framework
Restassured cucumber bdd framework for testing API

## Overview
A comprehensive REST Assured and Cucumber BDD framework for automated API testing. This framework combines the power of REST Assured for API testing with Cucumber's BDD approach for readable and maintainable test scenarios.

## Language Composition
- **Java**: 77.2%
- **Gherkin**: 22.8%

## Features
- ✅ BDD approach using Cucumber and Gherkin
- ✅ REST API testing with REST Assured
- ✅ Tag-based test execution
- ✅ Easy test organization and maintenance
- ✅ Comprehensive API validation

## Prerequisites
- Java 8 or higher
- Maven 3.6 or higher
- Git

## Installation

1. Clone the repository:
```bash
git clone https://github.com/kolkarcodes/restassured-cucumber-bdd-framework.git
cd restassured-cucumber-bdd-framework
```

2. Install dependencies:
```bash
mvn clean install
```

## Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Tests by Tags

#### Run Negative Tests
```bash
mvn clean test "-Dcucumber.filter.tags=@negative"
```

#### Run Login Tests
```bash
mvn clean test "-Dcucumber.filter.tags=@login"
```

#### Run Smoke Tests
```bash
mvn clean test "-Dcucumber.filter.tags=@smoke"
```

#### Run Multiple Tags (OR operation)
```bash
mvn clean test "-Dcucumber.filter.tags=@smoke or @login"
```

#### Run Multiple Tags (AND operation)
```bash
mvn clean test "-Dcucumber.filter.tags=@smoke and @login"
```

#### Run Tests Excluding a Tag
```bash
mvn clean test "-Dcucumber.filter.tags=not @negative"
```

## Project Structure
```
restassured-cucumber-bdd-framework/
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── stepDefinitions/
│   │   │   ├── runners/
│   │   │   └── utils/
│   │   └── resources/
│   │       └── features/
│   └── main/
├── pom.xml
└── README.md
```

## Technologies Used
- **REST Assured**: REST API testing library
- **Cucumber**: BDD testing framework
- **JUnit**: Test execution framework
- **Maven**: Build automation tool

## Contributing
Feel free to submit issues and enhancement requests!

## License
This project is open source and available under the MIT License.

## Contact
For any queries, please reach out to [kolkarcodes](https://github.com/kolkarcodes)
