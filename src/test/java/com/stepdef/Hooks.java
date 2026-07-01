package com.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.utils.DriverUtils;

public class Hooks {
    @Before
    public void setup() {
        DriverUtils.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Logic to take a screenshot if the test fails
            System.out.println("Failed: " + scenario.getName());
        }
        DriverUtils.quitDriver();
    }
}