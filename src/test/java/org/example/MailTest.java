package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MailTest {

    public static LoginPage loginPage;
    public static MailPage mailPage;
    public static WebDriver driver;



      @BeforeAll
      static void setup() {
           //определение пути до драйвера и его настройка
         System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
          //создание экземпляра драйвера (открывается браузер)
         driver = new ChromeDriver();
          //создание объекта класса с локаторами и функциями элементов страницы 1
         loginPage = new LoginPage(driver);
         //создание объекта класса с локаторами и функциями элементов страницы 2
         mailPage = new MailPage(driver);
          //окно разворачивается на полный экран
         driver.manage().window().maximize();
          //задержка на выполнение теста = 10 сек при каждом поиске элемента (неявное ожидание)
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          //получение ссылки на страницу (url берем из файла конфигурации)
         driver.get(ConfProperties.getProperty("loginpage"));
         System.out.println("Шаг 1");
      }

      @Test
      public  void loginTest() {

          loginPage.inputLogin(ConfProperties.getProperty("login"));
          System.out.println("Шаг 2");
          // Снять галочку "запомнить"
          loginPage.notRemember();
          System.out.println("Шаг 3");
          //Нажатие кнопки для перехода на ввод пароля
          loginPage.goPswInput();
          System.out.println("Шаг 4");
          // ВВод пароля
          loginPage.inputPsw(ConfProperties.getProperty("psw"));
          System.out.println("Шаг 5");
          // Нажатие кнопки входа
          loginPage.goToMail();
          System.out.println("Шаг 6");
          // Закрытие окна сохранения фотографии (клик по кнопке Х)
          loginPage.downWinFoto();
          System.out.println("Шаг 7");
          //Проверка логина пользователя
          Assertions.assertEquals(ConfProperties.getProperty("login")+"@mail.ru",mailPage.getLogin());
          System.out.println("Шаг 8");
      }

      @Test
      public void SendMail(){
          // Нажать кнопку "Написать письмо"
          mailPage.writeBtnClk();
          System.out.println("Шаг 9");
          //Ввод адреса получателя
          mailPage.inTextTo(ConfProperties.getProperty("login") + "@mail.ru");
          System.out.println("Шаг 10");
          //Ввод темы письма
          mailPage.inTextTema("Автоматическая отправка письма");
          System.out.println("Шаг 11");
          //Ввод текста в тело письма (переключение на iframe  с индексом 0)
          (new WebDriverWait(driver,30))
                  .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
          mailPage.clTextBody();
          mailPage.inTextBody("Привет от автотеста"+System.getProperty("line.separator"));
          mailPage.inTextBody("--"+System.getProperty("line.separator"));
          mailPage.inTextBody("Selenium Webdriver");
          driver.switchTo().defaultContent();
          System.out.println("Шаг 12");
          //Нажать кнопку "Отправить"
          mailPage.sendBtnClk();
          System.out.println("Шаг 13");
          //Нажатие на кнопку "Выход"
          mailPage.outMail();
          System.out.println("Шаг 14");

      }

      @AfterAll
      public static void toClose() {
         driver.quit();
      }



}
