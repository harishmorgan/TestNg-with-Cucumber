package com.stepDef;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "", features = {"src/test/resources/features/LoginPage.feature"}, glue = {"com.stepDef"},
                 plugin = {"rerun:target/failedrerun.txt"})
    
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    
}