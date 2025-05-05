package HomeWork.steps;

import HomeWork.context.TestContext;
import HomeWork.utils.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static HomeWork.context.TestContext.closeDriver;
import static HomeWork.context.TestContext.getDriver;

public class BaseSteps {
    @Before
    public void beforeMethod(Scenario scenario){
        getDriver().get(ConfigurationReader.get("base_url"));
        TestContext.scenario=scenario;
    }

    @After
    public void afterMethod(){
       if(getDriver() !=null){
           closeDriver();
       }

    }

}
