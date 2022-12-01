package com.cydeo.step_definitions;

import com.cydeo.pages.AllCarsPage;
import com.cydeo.pages.CreateCarBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class CreateCar_StepDef {

    AllCarsPage allCarsPage = new AllCarsPage();
    CreateCarBasePage createCarBasePage = new CreateCarBasePage();

    @Then("Verify driver cannot see the button")
    public void driver_Cannot_See_Button() {

        int sizeOfBtn = allCarsPage.createCarBtn.size();

        Assert.assertEquals(0, sizeOfBtn);

    }


    @Then("that the sale manager and store manager can click Create Car button")
    public void verifyThatTheSaleManagerAndStoreManagerSeeButton() {

        Assert.assertTrue(allCarsPage.createCarBtn.get(0).isEnabled());

    }


    @And("User goes to Create Car page")
    public void userGoesToCreateCarPage()  {

        createCarBasePage.clickCreateCarBtn();

    }


    @Then("User creates a car by filling compulsory fields")
    public void userCreatesACarByFillingCompulsoryFields() {

        createCarBasePage.createCar();
        String entitySavedMessageText = createCarBasePage.entitySavedMessage.getText();
        Assert.assertEquals("Entity saved",entitySavedMessageText);

    }


    @Then("User cannot create a car without filling compulsory fields")
    public void userCannotCreateACarWithoutFillingCompulsoryFields() {
        CreateCarBasePage.createCarNegativeTest();
        String entitySavedMessageText = createCarBasePage.entitySavedMessage.getText();
        Assert.assertNotEquals("Entity saved",entitySavedMessageText);
    }


    @Then("User enters Compulsory fields without complying with the conditions")
    public void userEntersCompulsoryFieldsWithoutComplyingWithTheConditions() {

        // LicencePlateField Assertion
        List<String> textOfLicencePlateFieldList = createCarBasePage.licencePlateFieldCheck();
        Assert.assertEquals(textOfLicencePlateFieldList.get(0), textOfLicencePlateFieldList.get(1));

        // DriverField Assertion
        List<String> textOfDriverFieldList = CreateCarBasePage.driverFieldCheck();
        Assert.assertEquals(textOfDriverFieldList.get(0), textOfDriverFieldList.get(1));

        // Chassis Number Field Assertion
        List<String> textOfChassisNumberFieldList=CreateCarBasePage.chassisNumberFieldCheck();
        Assert.assertEquals(textOfChassisNumberFieldList.get(0),textOfChassisNumberFieldList.get(1));

        // Model Year Field Assertion
        List<String> textOfModelYearFieldList=CreateCarBasePage.modelYearFieldCheck();
        Assert.assertEquals(textOfModelYearFieldList.get(0),textOfModelYearFieldList.get(1));

        // Last Odometer Field Assertion
        List<String> textOflastOdometerFieldList = CreateCarBasePage.lastOdometerFieldCheck();
        Assert.assertEquals(textOflastOdometerFieldList.get(0),textOflastOdometerFieldList.get(1));

        // Tags_Employee Assertion
        CreateCarBasePage.tags_EmployeeTest();
        boolean tags_EmployeeClicked = createCarBasePage.tags_Employee.isSelected();
        Assert.assertTrue(tags_EmployeeClicked);

        // Tags_JuniorField Assertion
        CreateCarBasePage.tags_JuniorField();
        boolean tags_JuniorFieldClicked = createCarBasePage.tags_JuniorField.isSelected();
        Assert.assertTrue(tags_JuniorFieldClicked);

        // Manuel Transmission Btn Assertion
        CreateCarBasePage.manuelTransmissionBtnTest();
        boolean manuelTransmissonBtnClicked = createCarBasePage.manuelTransmissonBtn.isSelected();
        Assert.assertTrue(manuelTransmissonBtnClicked);

        // Diesel Btn Assertion
        CreateCarBasePage.gasolineBtnTest();
        boolean dieselBtnlicked = createCarBasePage.gasolineBtn.isSelected();
        Assert.assertTrue(dieselBtnlicked);

    }


    @Then("User can select ‘Vehicle Model’ and ‘Vehicle Make’ from the list")
    public void userCanSelectVehicleModelAndVehicleMakeFromTheList() {

        List<Boolean> vehicleModelMakeClikable=CreateCarBasePage.vehicleModel_MakeClickableTest();

       Assert.assertTrue(vehicleModelMakeClikable.get(0));
       Assert.assertTrue(vehicleModelMakeClikable.get(1));


    }
}

