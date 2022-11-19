package com.cydeo.step_definitions;


import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.Dash_Board_Page;
import com.cydeo.pages.Login_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DriverFilter_stepdef {
Login_Page loginPage=new Login_Page();
Dash_Board_Page dashBoardPage=new Dash_Board_Page();
AllCarsPage allCarsPage=new AllCarsPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),60);

    @Given("User logs in as a Salesmanager")
    public void user_logs_i_as_a_salesmanager() {
        loginPage.goLoginPage();
        loginPage.loginAsSalesManager();
    }
    @Given("User should go to dashboard page")
    public void user_shoul_go_to_dashboard_page() {

        wait.until(ExpectedConditions.titleIs("Dashboard"));
    }
    @Given("User hover over fleet menu")
    public void user_clicks_fleet_menu() throws InterruptedException {
       // Thread.sleep(3000);
       // WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(dashBoardPage.fleetDropdownBtn));
       BrowserUtils.hover(dashBoardPage.fleetDropdownBtn);

    }
    @Given("User clicks vehicles page under fleet menu")
    public void user_clicks_vehicles_page_under_fleet_menu() {

        wait.until(ExpectedConditions.elementToBeClickable(dashBoardPage.vehiclesLink));
        dashBoardPage.vehiclesLink.click();

    }
    @And("User clicks Filter Button")
    public void userClicksFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(allCarsPage.FiltersButton));
        allCarsPage.FiltersButton.click();

    }
    @Given("User select Driver option under ManageFilter dropdown")
    public void user_select_driver_option() {
        wait.until(ExpectedConditions.visibilityOf(allCarsPage.ManageFilterButton));
        allCarsPage.ManageFilterButton.click();
        allCarsPage.Drivercheckbox.click();
    }
    @Given("User clicks Driver All button")
    public void user_clicks_driver_all_button() {
        allCarsPage.DriverAllBtn.click();
    }

    @When("User clicks Contains dropdown")
    public void user_clicks_contains_dropdown() {
        allCarsPage.ContainsBtn.click();

    }
    @Then("User should see all options under Driver Filter Menu")
    public void user_should_see_all_options_under_driver_filter_menu() {
         List<String> ExpectedMethodnames=new ArrayList<>();
        ExpectedMethodnames.addAll(Arrays.asList("contains","does not contain", "is equal to","starts with",
                      "ends with","is any of","is not any of","is empty","is not empty"));
        List<String>ActualMethotnames=new ArrayList<>();
        for (WebElement method : allCarsPage.AllMethods) {
            ActualMethotnames.add(method.getAttribute("innerText"));

        }
        Assert.assertEquals(ExpectedMethodnames,ActualMethotnames);
    }

    @And("User enters {string}")
    public void userEnters(String arg0) {

    }

    @When("User selects contains method")
    public void userSelectsContainsMethod() {
    }

    @And("User clicks update button")
    public void userClicksUpdateButton() {
    }

    @Then("Results should contain keywords")
    public void resultsShouldContainKeywords() {
    }
}
