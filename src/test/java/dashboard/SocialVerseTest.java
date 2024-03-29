package dashboard;

import base.DashboardTestBase;
import com.codeborne.selenide.Condition;
import helper.WaitHelper;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.dashboard.SocialVersePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static pages.BasePage.isElementDisplayed;
import static pages.dashboard.SocialVersePage.*;

@Epic("Regression Tests")
public class SocialVerseTest extends DashboardTestBase {


    @BeforeMethod
    public void deleteSocialVerseCard() throws InterruptedException {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.open();
        Thread.sleep(2000);
        if (isElementDisplayed(createSocialVerseButton)) {
            socialVersePage.deleteTheSocialVerseCard();
            socialVersePage.deleteSocialVerseModalYesButton();
        }
    }


    @Test(testName = "Verify the functionality of creating and removing SocialVerse card type")

    public void verifyFunctionalityOfCreatingSocialVerseCardAndRemove() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.setRandomSocialVerseName();
        socialVersePage.clickCreateSocialVerseButton();
        socialVersePage.clickArrowBackButton();
        socialVersePage.editCardButton();
        String newCreatedSocialVerseCardName = socialVersePage.getSocialVerseName();
        String getCurrentSocialVerseName = socialVersePage.getSocialVerseName();
        Assert.assertEquals(newCreatedSocialVerseCardName,getCurrentSocialVerseName);
    }

    @Test(testName = "Verify the functionality of creating and removing SocialVerse Sphere type")
    public void verifyFunctionalityOfCreatingSocialVerseSpheresAndRemove() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickSpheresSocialVerseButton();
        socialVersePage.setRandomSocialVerseName();
        socialVersePage.clickCreateSocialVerseButton();
        socialVersePage.clickArrowBackButton();
        socialVersePage.editCardButton();
        String newCreatedSocialVerseCardName = socialVersePage.getSocialVerseName();
        String getCurrentSocialVerseName = socialVersePage.getSocialVerseName();
        Assert.assertEquals(newCreatedSocialVerseCardName,getCurrentSocialVerseName);
    }

    @Test(testName = "Verify the functionality of creating a " +
            "socialVerse with empty text should trigger an error alert")
    public void verifyFunctionalityOfCreateSocialVerseWithoutText() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.writeSocialVerseTextAndDeleteField();
        socialVersePage.errorText.shouldHave(Condition.text("name is a required field"));
    }

    @Test(testName = "Verify the functionality of SocialVerse name with less than 3 letters triggers error alert")
    public void verifyFunctionalityOfCreateSocialVerseUsingShortText() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.writeSocialVerseShortText();
        socialVersePage.errorText.shouldHave(Condition.text("Name must be at least 3 characters long"));
    }


    @Test(testName = "Verify the functionality of Adding video in socialVerse list")
    public void verifyFunctionalityOfAddingVideoInSocialVeuList() {
        SocialVersePage socialVersePage = new SocialVersePage();
        socialVersePage.clickNewSocialVerseButton();
        socialVersePage.clickCardsSocialVerseButton();
        socialVersePage.setRandomSocialVerseName();
        socialVersePage.clickCreateSocialVerseButton();
        socialVersePage.clickAddVideoButton();
        WaitHelper.waitElementToPresent(socialVerseRecordVideos, appear, Duration.ofSeconds(2));
        Assert.assertTrue(isElementDisplayed(socialVerseRecordVideos),
                "The Video is not appear in socialVerse List ");
    }
}
