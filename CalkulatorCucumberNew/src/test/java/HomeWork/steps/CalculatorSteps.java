package HomeWork.steps;

import HomeWork.page.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorSteps {

    private Calculator calculator;
    private double factResult;

    @Then("the result should be {double}")
    public void theResultShouldBe(double result) {

        assertEquals(result, factResult, 0.0);
    }

//    @Given("I opened a calculator")
//    public void i_opened_a_calculator() {
//        calculator = new Calculator();
//    }

    @When("I add {double} and {double}")
    public void iAddAnd(double num1, double num2) {

        factResult = calculator.add(num1, num2);
    }


    @When("I subtract {double} and {double}")
    public void iSubtractAnd(double num1, double num2) {

        factResult = calculator.subtract(num1,num2);
    }

    @When("I divide {double} and {double}")
    public void iDivideAnd(double num1, double num2) {

        factResult = calculator.divide(num1,num2);

        }

    @When("I multiply {double} and {double}")
    public void i_multiply_and(Double double1, Double double2) {
       factResult = calculator.multiply(double1,double2);
    }


    @Given("I opened a calculator")
    public void iOpenedACalculator() {
        calculator = new Calculator();
    }
}
