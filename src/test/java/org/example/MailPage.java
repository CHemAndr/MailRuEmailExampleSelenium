package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class MailPage {

    public WebDriver driver;

    //Конструктор обращается к классу PageFactory, чтобы заработала аннотация @FindBy
    //Он инициализирует поля класса
    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Описание элементов страницы

    //Поле логина
    @FindBy(id = "PH_user-email")
    private WebElement loginText;

    // Кнопка написать письмо
    @FindBy(xpath = "//span[text()='Написать письмо']")
    private WebElement writeBtn;

    //Поле ввода "Кому"
    @FindBy(xpath = "//textarea[contains(@class,'js-input compose__labels__input')]")
    private WebElement fieldTo;

    //Поле ввода "Тема"
    @FindBy(xpath = "//input[contains(@class,'b-input')]")
    private WebElement fieldTema;

    // Кнопка "Отправить"
    @FindBy(xpath = "//span[text()='Отправить']")
    private WebElement sendBtn;

    // Тело письма
    //@FindBy(xpath = "//body[id = 'tinymce']/br[0]")
    //@FindBy(xpath = "//br")
    @FindBy(id = "tinymce")
    private WebElement bodyLetter;

    //Кнопка "Выход"
    @FindBy(id="PH_logoutLink")
    private WebElement outBtn;

    //Кнопка "Продолжить" (если письмо пустое)
    @FindBy(xpath = "//span[text()='Продолжить']")
    private WebElement nextBtn;


    // Методы работы с элементами

    // Прочитать поле логина
    public String getLogin() {
        return loginText.getText();
    }

    //Нажать кнопку "Написать письмо
    public void writeBtnClk(){
        writeBtn.click();
    }

    // Ввод адреса получателя
    public void inTextTo(String Address){
        fieldTo.sendKeys(Address);
    }

    //Ввод темы письма
    public  void inTextTema(String Tema){
        fieldTema.sendKeys(Tema);
    }

    //ВВод текста в тело письма
    public  void inTextBody(String Text) {
        bodyLetter.click();
        bodyLetter.sendKeys(Text);
    }

    public void  clTextBody(){
        bodyLetter.clear();
    }


    // Нажать кнопку "Отправить"
    public void sendBtnClk() {
        sendBtn.click();
    }

    // Нажать кнопку продолжить (если письмо пустое)
    public  void nextBtnClk(){
        nextBtn.click();
    }

    // Нажатие кнопки "Выход"
    public void outMail() { outBtn.click(); }
}
