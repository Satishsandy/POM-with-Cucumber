
package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFile/login.feature",
                          glue="stepDefination",dryRun=false,
                          monochrome=true,
                          plugin= {"pretty",
                                     "html:target/cucumber-reports"}
                                 
		                        )
public class Runner {

}
//features=".//Features/"= to run the all the feature files