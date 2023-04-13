package dashboard;

import base.DashboardTestBase;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import pages.dashboard.CompanyProfilePage;
import utils.RandomUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Epic("Regression Tests")
public class CompanyProfileTest extends DashboardTestBase {


    @Test(testName = "Verify the functionality of saving Company Name")
    public void verifyFunctionalitySavingNewCompanyName() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String randomText = RandomUtils.getString();
        companyProfilePage.setRandomCompanyName(randomText);
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String currentCompanyName = companyProfilePage.setRandomCompanyName(randomText);
        String getCurrentCompanyName = companyProfilePage.getCurrentCompanyName();
        assertThat(currentCompanyName).isEqualTo(getCurrentCompanyName);
    }

    @Test(testName = "Verify the functionality of saving Company Address")

    public void verifyFunctionalitySavingNewCompanyAddress() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String randomText = RandomUtils.getString();
        companyProfilePage.setRandomCompanyAddress(randomText);
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String currentCompanyAddress = companyProfilePage.setRandomCompanyAddress(randomText);
        String getCurrentCompanyAddress = companyProfilePage.getCurrentCompanyAddress();
        assertThat(currentCompanyAddress).isEqualTo(getCurrentCompanyAddress);
    }

    @Test(testName = "Verify the functionality of saving City")
    public void verifyFunctionalitySavingNewCityName() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String newCityName = companyProfilePage.setRandomCityName();
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String getCurrentCityName = companyProfilePage.getCurrentCityName();
        assertThat(newCityName).isEqualTo(getCurrentCityName);
    }

    @Test(testName = "Verify the functionality of saving Company Web site url")
    public void verifyFunctionalitySavingNewCompanyWebSite() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String newWebsiteUrl = companyProfilePage.setRandomCompanyWebsite();
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String getCurrentWebSiteUrl = companyProfilePage.getCurrentWebSiteUrl();
        assertThat(newWebsiteUrl).isEqualTo(getCurrentWebSiteUrl);
    }

    @Test(testName = "Verify the functionality of saving Zip Code")
    public void verifyFunctionalitySavingNewZipCode() {
        CompanyProfilePage companyProfilePage = new CompanyProfilePage();
        companyProfilePage.open();
        String newZipCode = companyProfilePage.setRandomZipCode();
        companyProfilePage.zoomPage();
        companyProfilePage.clickSaveButton();
        companyProfilePage.resetZoom();
        String getCurrentZipCode = companyProfilePage.getCurrentZipCode();
        assertThat(newZipCode).isEqualTo(getCurrentZipCode);
    }
}
