package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

// Класс содержит локацию элементов страницы и методы взаимодействия с ними
public class LoginPage {

    public WebDriver driver;

    //Конструктор обращается к классу PageFactory, чтобы заработала аннотация @FindBy
    //Он инициализирует элементы страницы
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    //Поле ввода логина
    @FindBy(name = "username")
    private WebElement loginField;

    // Галочка "Запомнить"
    @FindBy(xpath = "//span[text()='запомнить']")
    private WebElement checkBox;

    // Кнопка "Ввести пароль"
    @FindBy(xpath = "//span[text()='Ввести пароль']")
    private WebElement buttonPsw;

    // Поле ввода пароля
    @FindBy(name = "password")
    private WebElement pswField;

    // Кнопка вход
    @FindBy(xpath = "//span[text()='Войти']")
    private  WebElement buttonIn;

    // Кнопка Х на "Загрузка фотографии и создание подписи"
    @FindBy(xpath = "//div[contains(@class,'icon icon_popup-close')]")
    private WebElement btnX;

    // Методы работы с элементами

    // Ввод логина
    public void inputLogin(String login){
        loginField.click();
        loginField.sendKeys(login);
    }

    //Снять галочку "Запомнить"
    public  void notRemember() {
        checkBox.click();
    }

    // Переход на ввод пароля
    public void goPswInput(){
        buttonPsw.click();
    }

    //Ввод пароля
    public void inputPsw(String psw) {
        pswField.click();
        pswField.sendKeys(psw);
    }

    //нажать кнопку вход
    public void goToMail(){
        buttonIn.click();
    }

    // Нажать кнопку Х
    public void downWinFoto() { btnX.click();}
}
