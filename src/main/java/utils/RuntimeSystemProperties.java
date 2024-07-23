package utils;

public class RuntimeSystemProperties {

    public static final String ENVIRONMENT = System.getProperty("environment", "localDriver");
    public static final String BROWSER = System.getProperty("browser", "chrome");

    // SELENIUM GRID PROPERTIES
    public static final String LOCAL_SELENIUM_HUB = System.getProperty("hubUrl", "http://localhost:4444/wd/hub");
}