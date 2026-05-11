package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevisPage extends BasePage {

    private WebDriverWait wait;

    public DevisPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= LOCATORS =================

    private By menuDevis = By.xpath("//span[normalize-space()='Demander un devis']");

    // RADIO
    private By entreprise = By.xpath("//input[@value='Entreprise']");
    private By particulier = By.xpath("//input[@value='Particulier']");

    private By tvaAssujettie = By.xpath("//input[@value='Assujettie à la TVA']");
    private By tvaExoneree = By.xpath("//input[@value='Exonérée de la TVA']");

    private By intra = By.xpath("//input[@value='Intra-Entreprise']");
    private By inter = By.xpath("//input[@value='Inter-Entreprise']");

    // DROPDOWNS
    private By domaine = By.name("thme-formation");
    private By fonction = By.name("your-job");

    // INPUTS
    private By participants = By.name("nombre_personnes");
    private By nom = By.name("your-name");
    private By tel = By.name("your-tel");
    private By email = By.name("your-email");

    private By submit = By.cssSelector("input.wpcf7-submit");

    // ================= SAFE CLICK (FIX OVERLAY ISSUE) =================

    private void safeClick(By locator) {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", el
        );

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }

    private void fill(By locator, String value) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(value);
    }

    // ================= NAV =================

    public void open() {
        safeClick(menuDevis);
    }

    // ================= RADIO =================

    public void selectEntreprise() { safeClick(entreprise); }
    public void selectParticulier() { safeClick(particulier); }

    public void selectTvaAssujettie() { safeClick(tvaAssujettie); }
    public void selectTvaExoneree() { safeClick(tvaExoneree); }

    public void selectIntra() { safeClick(intra); }
    public void selectInter() { safeClick(inter); }

    // ================= DROPDOWNS =================

    public void selectDomaine(String value) {
        new Select(wait.until(ExpectedConditions.elementToBeClickable(domaine)))
            .selectByVisibleText(value);
    }

    public void selectFonction(String value) {
        new Select(wait.until(ExpectedConditions.elementToBeClickable(fonction)))
            .selectByVisibleText(value);
    }

    // ================= INPUTS =================

    public void enterParticipants(String v) { fill(participants, v); }
    public void enterNom(String v) { fill(nom, v); }
    public void enterTel(String v) { fill(tel, v); }
    public void enterEmail(String v) { fill(email, v); }

    // ================= SUBMIT =================

    public void submit() {
        safeClick(submit);
    }

    // ================= SIMPLE FORM =================

    public void fillRequiredForm() {
        selectEntreprise();
        selectTvaAssujettie();
        selectDomaine("Tests de Logiciels");
        enterParticipants("5");
        enterNom("TEST");
        enterTel("12345678");
        enterEmail("test@mail.com");
    }
}