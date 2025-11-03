package awesomecucumber.runner;

import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("awesomecucumber.features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "awesomecucumber")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, summary, html:target/cucumber-report.html, json:target/cucumber.json")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
// @ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value =
// "true")
// @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value =
// "@authentication")
public class JunitRunnerTest {
}
