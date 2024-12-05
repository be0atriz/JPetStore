CREFinalACNA - Certification Rumos Expert (CRE): Test Automation Engineer - JPetStore

...

Project Requirements and Goals

E-commerce Functionalities:
-User Registration & Authentication: Create and authenticate accounts.
-Product Search: Search and view products with details.
-Shopping Cart: Add and display items.
-Checkout Process: Complete purchase with payment and delivery info.


Technical Requirements:
-Use Selenium WebDriver with Page Object Model (POM).
-Ensure code maintainability, reusability, and independent test execution.
-Execute tests across multiple browsers.
-Integrate with Allure reports and Jenkins.
-Tools and Preconditions
-Website Used: https://petstore.octoperf.com/actions/Catalog.action

Tools:

IDE: Eclipse
Frameworks: Selenium, Cucumber, TestNG, JUnit, Allure
Language: Java
Build Tool: Maven
CI/CD: Jenkins
Version Control: GitHub
Project Execution and Setup
Prerequisites:
- JDK 21+
- Maven 3.9.9+
- IDE compatible with Selenium
- Testing tools: TestNG, JUnit, Cucumber, Allure 2.32.0
- Jenkins & Git

Running Tests:
- Execute with "mvn clean test".
- Use the "@Petstore" tag for all tests or customize with individual tags.
- Project Design and Logic

Organized Structure:
- POM architecture ensures code reusability and maintainability.
- Independent feature files written in Gherkin language.

Reusability:
- Shared steps through HomepageSteps for common actions.
- Centralized WebDriver initialization with TextContent.
- Browser configurations consolidated in a BrowserConfiguration class.

Data-Driven Tests:
- Scenario outlines allow testing with multiple data sets.

Browser Compatibility:
- Successfully tested on Chrome, Firefox, and Edge

Conclusions
This project validates automation skills using modern tools and methodologies. It highlights the importance of structured test design and the challenges of ensuring cross-environment compatibility. Future efforts will focus on resolving the Edge issue and enhancing Jenkins integration.