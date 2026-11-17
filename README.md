# Swag Labs Automation

Automated UI test suite for the [Swag Labs](https://www.saucedemo.com) demo web application, built with Java and Selenium WebDriver using the Page Object Model and data-driven testing.

## Tech Stack
- Language: Java
- Automation: Selenium WebDriver
- Test runner: TestNG
- Build tool: Maven
- Design pattern: Page Object Model (POM)
- Test data: JSON files (data-driven)

## Project Structure
```
Swag-Labs-Automation
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Pages
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── InventoryPage.java
│   │   │   │   └── CartPage.java
│   │   │   └── Utils
│   │   │       └── DataDriven.java
│   │   └── resources
│   │       ├── TestData.json
│   │       └── cartProducts.json
│   └── test
│       └── java
│           ├── Base
│           │   └── BaseTest.java
│           └── Tests
│               ├── LoginTest.java
│               ├── InventoryTest.java
│               └── CartTests.java
├── pom.xml
└── .gitignore
```

## Test Coverage

### Login (LoginTest)
| Scenario | Expected Result |
|----------|-----------------|
| Login with valid credentials | User is redirected to the Inventory page (`/inventory.html`) |
| Login with invalid credentials | Error message "Username and password do not match" is displayed |
| Login with empty password | Error message "Password is required" is displayed |

### Inventory (InventoryTest)
| Scenario | Expected Result |
|----------|-----------------|
| Verify Inventory page after login | Page title contains "Swag Labs", cart icon is displayed, and 6 products are listed |
| Click the X (Twitter) footer icon | Opens a page whose URL contains "x.com" |
| Click the Facebook footer icon | Opens a page whose URL contains "facebook" |
| Click the LinkedIn footer icon | Opens a page whose URL contains "linkedin" |

### Cart (CartTests)
| Scenario | Expected Result |
|----------|-----------------|
| Open the cart without adding products | Cart is empty |
| Add specific products (from JSON test data) and open the cart | Cart shows the same products, in the same order they were added |

## How to Run
1. Clone the repo:
   `git clone https://github.com/engyhenry60-lang/Swag-Labs-Automation.git`
2. Make sure JDK and Maven are installed.
3. Run all tests:
   `mvn clean test`
4. Run a single test class:
   `mvn clean test -Dtest=LoginTest`

## Author
Engy Henry
[LinkedIn](https://www.linkedin.com/in/engyhenry)
