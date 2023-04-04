package pages.dashboard;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;
import utils.RandomUtils;

public class SocialVersePage extends BasePage<SocialVersePage> {

    public SelenideElement createNewSocialVerseButton = Selenide.element(By.id("create-socialv-button"));
    public SelenideElement createSocialVerseButton = Selenide.element("div>button[id='create-sv-button']");
    private final SelenideElement createCardsSocialVerseButton = Selenide.element(By.id("create-sv-card-btn"));
    private final SelenideElement createSpheresSocialVerseButton = Selenide.element(By.id("create-sv-spheres-btn"));
    public SelenideElement inputSocialVerseName = Selenide.element(("div>input[name='name']"));
    public SelenideElement errorText = Selenide.element(("div>p[id='input-meta-title-helper-text']"));
    private final SelenideElement createSvButtonModal = Selenide.element(By.id("create-sv-btn-modal"));
    private final SelenideElement deleteCardButton = Selenide.element(By.id("delete-card-button-0"));
    private final SelenideElement editCardButton = Selenide.element(By.id("edit-card-button-0"));
    private final SelenideElement socialVerseNameInput = Selenide.element(By.id("socialverse-name-input-0"));
    private final SelenideElement yesDeleteButton = Selenide.element(By.id("confirm-delete-socialverse-button"));
    private final SelenideElement arrowBackButton = Selenide.element("div>button>span>svg[data-testid='ArrowBackIcon']");
    public SelenideElement socialVerseRecordVideos = Selenide.element("div>[data-rbd-droppable-id='droppable']");
    private final SelenideElement addVideoButton = Selenide.element(By.id("add-video-button-0"));

    private final SelenideElement addVideosEditButton = Selenide.element(By.id("add-videos-button-0"));
    public SelenideElement videoSocialVenuList = Selenide.element("div>[aria-describedby='rbd-hidden-text-0-hidden-text-0']");


    public void clickNewSocialVerseButton() throws InterruptedException {
        Thread.sleep(3000);
        if (createNewSocialVerseButton.isDisplayed() && createNewSocialVerseButton.exists()) {
            createNewSocialVerseButton.click(ClickOptions.usingJavaScript());
        } else {
            createSocialVerseButton.click(ClickOptions.usingJavaScript());
        }
    }


    public void clickAddVideoEditButton() {
        addVideosEditButton.click(ClickOptions.usingJavaScript());
    }

    public void clickAddVideoButton() throws InterruptedException {
        scrollToAndClick(addVideoButton);
        Thread.sleep(3000);
//        addVideoButton.click(ClickOptions.usingJavaScript());
    }

    public void deleteSocialVerseModalYesButton() {
        yesDeleteButton.click(ClickOptions.usingJavaScript());
        createNewSocialVerseButton.shouldBe(Condition.visible);

    }

    public void deleteTheSocialVerseCard() {
        deleteCardButton.click(ClickOptions.usingJavaScript());
    }


    public void editCardButton() {
        editCardButton.click(ClickOptions.usingJavaScript());
    }

    public void clickArrowBackButton() {
        arrowBackButton.click(ClickOptions.usingJavaScript());

    }

    public String getCurrentSocialVerseName() {
        return socialVerseNameInput.getValue();
    }

    public void clickCreateSocialVerseButton() {
        createSvButtonModal.shouldBe(Condition.visible);
        createSvButtonModal.click(ClickOptions.usingJavaScript());
    }

    public String setRandomSocialVerseName() {
        String[] socialVerseName = {"game", "football", "iPhone", "Android", "fresh"};
        String randomSocialVerseName = socialVerseName[RandomUtils.getInt(socialVerseName.length)];
        inputSocialVerseName.setValue(randomSocialVerseName);
        return randomSocialVerseName;
    }

    public void writeSocialVerseTextAndDeleteField() throws InterruptedException {
        String text = "Test";
        inputSocialVerseName.setValue(text);
        Thread.sleep(2000);
        eraseAllTextField(inputSocialVerseName);
    }

    public void writeSocialVerseShortText() {
        String text = "Te";
        inputSocialVerseName.setValue(text);
    }


    public void clickCardsSocialVerseButton() {
        createCardsSocialVerseButton.shouldBe(Condition.visible);
        createCardsSocialVerseButton.click(ClickOptions.usingJavaScript());

    }

    public void clickSpheresSocialVerseButton() {
        createSpheresSocialVerseButton.shouldBe(Condition.visible);
        createSpheresSocialVerseButton.click(ClickOptions.usingJavaScript());

    }


    @Override
    public String getUrl() {
        return "socialverse";
    }
}
