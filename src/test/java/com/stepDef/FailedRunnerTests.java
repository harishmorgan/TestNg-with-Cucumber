package com.stepDef;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "", features = {"@target/failedrerun.txt"}, glue = {"com.stepDef"},plugin = {})
    
public class FailedRunnerTests extends AbstractTestNGCucumberTests {
    
}