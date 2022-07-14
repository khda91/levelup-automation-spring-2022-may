package ru.levelp.at.lesson13.bdd.userbugred;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:/ru/levelp/at/lesson13/bdd/feature"
)
public class RunAcceptanceIT extends AbstractTestNGCucumberTests {
}
