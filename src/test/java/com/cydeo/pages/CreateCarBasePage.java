package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCarBasePage {

    public CreateCarBasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveAndCloseBtn;

    @FindBy(id = "custom_entity_type_LicensePlate-uid-637f7adfd5efb")
    public WebElement licencePlateField;

    @FindBy(id = "custom_entity_type_Tags_0-uid-637f7adfd602d")
    public WebElement tags_JuniorField;

    @FindBy(id = "custom_entity_type_Tags_2-uid-637f7adfd61ec")
    public WebElement tags_Employee;

    @FindBy(id = "custom_entity_type_Tags_5-uid-637f7adfd6499")
    public WebElement tags_Sedan;

    @FindBy(id = "custom_entity_type_Driver-uid-637f7adfd6740")
    public WebElement driverField;

    @FindBy(id = "custom_entity_type_Location-uid-637f7adfd683b")
    public WebElement locationField;

    @FindBy(id = "custom_entity_type_ChassisNumber-uid-637f7adfd68ea")
    public WebElement chassisNumberField;

    @FindBy(id = "custom_entity_type_ModelYear-uid-637f7adfd69f4")
    public WebElement modelYearField;

    @FindBy(id = "custom_entity_type_LastOdometer-uid-637f7adfd6ae3")
    public WebElement lastOdometerField;

    @FindBy(id = "date_selector_custom_entity_type_ImmatriculationDate-uid-637f7adfd6bcc")
    public WebElement immatriculationDateField;

    @FindBy(xpath = "(//a[@class='ui-state-default'])[24]")
    public WebElement immatriculationDateOption;

    @FindBy(id = "date_selector_custom_entity_type_FirstContractDate-uid-637f7adfd6cbd")
    public WebElement firstContractDateField;

    @FindBy(xpath = "//button[.='Today']")
    public WebElement firstContractDateToday;

    @FindBy(id = "custom_entity_type_CatalogValue-uid-637f7adfd6f27")
    public WebElement catalogValueField;

    @FindBy(id = "custom_entity_type_SeatsNumber-uid-637f7adfd7022")
    public WebElement seatsNumberField;

    @FindBy(id = "custom_entity_type_DoorsNumber-uid-637f7adfd710c")
    public WebElement doorsNumberField;

    @FindBy(id = "custom_entity_type_Color-uid-637f7adfd7207")
    public WebElement colorField;

    @FindBy(id = "s2id_custom_entity_type_Transmission-uid-637f7adfd7347")
    public WebElement transmissionDropdown;

    @FindBy(xpath = "//div[@id='s2id_custom_entity_type_Transmission-uid-637f8a7496901']/a/span[1]")
    public WebElement manuelTransmissonBtn;

    @FindBy(id = "s2id_custom_entity_type_FuelType-uid-637f8a7496a29")
    public WebElement fuelTypeBtn;

    @FindBy(xpath = "//div[@id='s2id_custom_entity_type_FuelType-uid-637f8a7496a29']/a/span[1]")
    public WebElement dieselBtn;

    @FindBy(id = "custom_entity_type_CO2Emissions-uid-637f8a7496b14")
    public WebElement cO2EmissionsField;

    @FindBy(id = "custom_entity_type_Horsepower-uid-637f8a7496c10")
    public WebElement horsepowerField;

    @FindBy(id = "id=\"custom_entity_type_HorsepowerTaxation-uid-637f8a7496d07\"")
    public WebElement horsepowerTaxationField;

    @FindBy(id = "custom_entity_type_Power-uid-637f8a7496df2")
    public WebElement powerField;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement vehicleModelAddBtn;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement vehicleMakeAddBtn;


    public static void clickCreateCarBtn(){

      AllCarsPage allCarsPage=new AllCarsPage();
      allCarsPage.createCarLink.click();

    }

    public static void createCar() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.licencePlateField.sendKeys("45 DR 805");
        createCarBasePage.tags_Employee.click();
        createCarBasePage.tags_JuniorField.click();
        createCarBasePage.tags_Sedan.click();
        createCarBasePage.driverField.sendKeys("Ahmet");
        createCarBasePage.chassisNumberField.sendKeys("1234565897");
        createCarBasePage.modelYearField.sendKeys("2005");
        createCarBasePage.lastOdometerField.sendKeys("20565");
        createCarBasePage.transmissionDropdown.click();
        createCarBasePage.manuelTransmissonBtn.click();
        createCarBasePage.fuelTypeBtn.click();
        createCarBasePage.driverField.click();
        createCarBasePage.saveAndCloseBtn.click();

    }

    public static void createCarNegativeTest() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.licencePlateField.sendKeys("45 DR 805");
        createCarBasePage.driverField.sendKeys("Ahmet");
        createCarBasePage.transmissionDropdown.click();
        createCarBasePage.manuelTransmissonBtn.click();
        createCarBasePage.saveAndCloseBtn.click();
    }

    public static void checkingCompulsoryFieldsConditions() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.licencePlateField.sendKeys("!!45/*DR 805");//(letters and digits)
        String actualTextOflicencePlateField = createCarBasePage.licencePlateField.getText();

        createCarBasePage.tags_Employee.click();//Clickable_multiple choices allowed
        boolean tags_EmployeeClicked = createCarBasePage.tags_Employee.isSelected();

        createCarBasePage.tags_JuniorField.click();//Clickable_multiple choices allowed
        boolean tags_JuniorFieldClicked = createCarBasePage.tags_JuniorField.isSelected();

        createCarBasePage.driverField.sendKeys("Ahmet5684646");//only letters
        String actualTextOfDriverField = createCarBasePage.driverField.getText();

        createCarBasePage.chassisNumberField.sendKeys("1234565897"); //only digits
        String actualTextOfChassisNumberField = createCarBasePage.chassisNumberField.getText();

        createCarBasePage.modelYearField.sendKeys("Hey 123549964"); //only digits, only year
        String actualTextOfModelYearField = createCarBasePage.modelYearField.getText();

        createCarBasePage.lastOdometerField.sendKeys("20565"); //only digits
        String actualTextOfLastOdometerField = createCarBasePage.lastOdometerField.getText();

        createCarBasePage.transmissionDropdown.click();//select from dropdown
        createCarBasePage.manuelTransmissonBtn.click();//select from dropdown
        boolean manuelTransmissonBtnClicked = createCarBasePage.manuelTransmissonBtn.isSelected();

        createCarBasePage.fuelTypeBtn.click();//select from dropdown
        createCarBasePage.driverField.click();//select from dropdown
        boolean driverFieldClicked = createCarBasePage.driverField.isSelected();

    }

    public static void checkingOptionalFieldsConditions() {

        CreateCarBasePage createCarBasePage = new CreateCarBasePage();

        createCarBasePage.locationField.sendKeys("!'^+%&&&ASAS15616");//letters and digits
        String locationFieldActualText = createCarBasePage.locationField.getText();

        createCarBasePage.immatriculationDateField.click();//any date from calendar pop up
        createCarBasePage.immatriculationDateOption.click();
        boolean immatriculationDateIsSelected = createCarBasePage.immatriculationDateOption.isSelected();

        createCarBasePage.firstContractDateField.click();//any date from calendar pop up
        createCarBasePage.firstContractDateToday.click();
        boolean firstContractDateTodayIsSelected = createCarBasePage.firstContractDateToday.isSelected();

        createCarBasePage.catalogValueField.sendKeys("1322ndsladnl'!^+%&/(");//only digits
        String catalogValueFieldActualText = createCarBasePage.catalogValueField.getText();

        createCarBasePage.seatsNumberField.sendKeys("ASDFGH!'^+%45164");//only digits
        String seatsNumberFieldActualText = createCarBasePage.seatsNumberField.getText();

        createCarBasePage.doorsNumberField.sendKeys("146846ASDFGHJK!'^+%&/");//only digits
        String doorsNumberFieldActualText = createCarBasePage.doorsNumberField.getText();

        createCarBasePage.colorField.sendKeys("ASDFG!'^+464");//only letters
        String colorFieldActualText = createCarBasePage.colorField.getText();

        createCarBasePage.cO2EmissionsField.sendKeys();//only digits
        String cO2EmissionsFieldActualText = createCarBasePage.cO2EmissionsField.getText();

        createCarBasePage.horsepowerField.sendKeys("ADggy!'^+%&/75414");//only digits
        String horsepowerFieldActualText = createCarBasePage.horsepowerField.getText();

        createCarBasePage.horsepowerTaxationField.sendKeys();//only digits
        String horsepowerTaxationFieldActualText=createCarBasePage.horsepowerTaxationField.getText();

        createCarBasePage.powerField.sendKeys("ASDFGHJ!'^+%&/146462");//only digits
        String powerFieldActualText = createCarBasePage.powerField.getText();

    }


}