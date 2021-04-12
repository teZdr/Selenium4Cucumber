package com.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@CucumberOptions(features = "src/test/resources/features/",
        glue = {"com.example.StepDefinitions"},
        plugin = {"json:target/report-json/Runner.json", "html:target/Runner"},
        tags = "@replacemeTag and not @disabled")

public class TestRunner extends AbstractTestNGCucumberTests {
}