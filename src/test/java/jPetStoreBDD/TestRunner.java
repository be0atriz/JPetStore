package jPetStoreBDD;

import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

/**
 * TestRunner Class - it configures and executes the tests and test suite
 * Cucumber with TestNG.
 */
@CucumberOptions(
    tags = "@PetStore", // To select each scenarios will be executed;
    features = "src/test/resources", // The path to the features folder;
    glue = "jPetStoreBDD.steps", // Package where the Cucumber steps are implemented;
    plugin = {
        "pretty", // Used to specify different formatting options for the output reports;
        "html:target/cucumber/report.html", // Generate a HTML report at the location mentioned;
        "junit:target/reports/cucumber.xml", // Generate a JUnit XML report at the location mentioned;
        "json:target/reports/cucumber.json", // Generate a JSON report at the location mentioned;
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Adapter to Integration with ExtentReports
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
	/**
	 * Configures the DataProvider to execute the test scenarios in parallel. It
	 * allows to run cucumber every detected feature as separated test
	 * 
	 * @return An array of object containing the tests scenarios.
	 */
	    @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	 }
 