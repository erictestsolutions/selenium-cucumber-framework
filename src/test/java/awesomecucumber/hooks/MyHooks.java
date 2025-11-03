package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
    private final TestContext context;

    public MyHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void before(Scenario scenario) {
        context.scenarioName = scenario.getName();
        System.out.println("DI: SCENARIO NAME: " + context.scenarioName);
        System.out.println("THREAD ID: " + Thread.currentThread().getId() + " Scenario Name: " + scenario.getName());
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.initDriver(browser);
    }

    @After
    public void after() {
        DriverFactory.quitDriver();
    }
}
