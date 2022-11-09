import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class elenavanesovaTest {

    //   TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(By.xpath(
                "//div[@id = \"weather-widget\"]//input[@placeholder='Search city']")
        );

        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );

         searchButton.click();

        Thread.sleep(1000);

         WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                 By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
         );

        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityNameHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);

        String actualResult = h2CityNameHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);


        driver.quit();
    }



//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой страницы
//    OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testOpenAndClickToGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String buttonGuide = "Guide";
        String expectidResalt1 = "https://openweathermap.org/guide";
        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement ButtonGuide = driver.findElement(By.xpath("//div[@id = 'desktop-menu']//li//a[@href='/guide']")
        );

          ButtonGuide.click();
          Thread.sleep(5000);



        String actualResult = driver.getTitle();
        String actualResult1 = driver.getCurrentUrl();

        Assert.assertEquals(actualResult,expectedResult);
        Assert.assertEquals(actualResult1,expectidResalt1);

        driver.quit();
    }


//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Подтвердить, что температура для города показана в Фарингейтах
//

    @Test
    public void testConfirmTemperatureUnit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "https://openweathermap.org/";
        String expectedResult = "true";
        String expectedResult1 = "F";
//        String tempInF = "F";

        driver.get(url);
        Thread.sleep(5000);

        WebElement ButtonImperialF = driver.findElement(By.xpath("//div[text()='Imperial: °F, mph']"));

        ButtonImperialF.click();
        Thread.sleep(5000);

        WebElement tempF = driver.findElement(By.xpath("//body[@class='body-orange']"));

        Thread.sleep(5000);

        boolean fTemp = tempF.getText().contains("F");

        String actiualResult = String.valueOf((fTemp));

        Assert.assertEquals(actiualResult,expectedResult);
        Assert.assertTrue(Boolean.parseBoolean(actiualResult));

//        String tempInF = tempF.getText();
//        Thread.sleep(5000);
//
//        String actiualResul1 = tempInF.substring(0,tempInF.length()-2);// не получается
//        Assert.assertEquals(actiualResul1,expectedResult1);


        driver.quit();
    }




//    TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
//   We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
//   You can allow all cookies or manage them individually.”
//3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    @Test
    public void testConfirmThatUsedCookies() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);

        //p[@class='stick-footer-panel__description']




//        driver.quit();

    }

//    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testConfirmSupportThreeMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);

//        WebElement bottomSupport = driver.findElement(By.xpath());
//
//        bottomSupport.click();
//        Thread.sleep(5000);
//


        driver.quit();

    }

//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

//    @Test
//    public void testConfirmSupportAskQuestionNotCaptcha() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        String url = "https://openweathermap.org/";
//        String email = "tester@test.com";
//        String subject = "abcd";
//        String massage = "Massage";
//
//
//        driver.manage().window().maximize();
//
//        driver.get(url);
//        Thread.sleep(6000);
//
//        WebElement menuSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']")
//        );
//        menuSupport.click();
//        Thread.sleep(500);
//
//        WebElement menuAskQuestion = driver.findElement(
//                By.xpath("//ul[@id='support-dropdown-menu']/li/a[@href='https://home.openweathermap.org/questions']"));
//
//        menuAskQuestion.click();
//        Thread.sleep(5000);
//
//        WebElement emailField = driver.findElement(By.id("question_form_email"));
//
//        emailField.click();
//        emailField.sendKeys(email);
//
//
//
//
//
//
//
//
//
//        driver.quit();
//
//    }

//    TC_11_06
//1.  Открыть базовую ссылку
//2.  Нажать пункт меню Support → Ask a question
//3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//4. Оставить пустым поле Email
//5. Заполнить поля  Subject, Message
//6. Подтвердить CAPTCHA
//7. Нажать кнопку Submit
//8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”


    @Test
    public void testSupportAskQuestionConfirmCaptcha() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);



        driver.quit();

    }


//    TC_11_07
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//
//3.  Нажать на единицы измерения Metric: °C, m/s
//4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С

    @Test
    public void testClikUnitsMeasurementConfirmChang() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);



        driver.quit();

    }

//    TC_11_08
//1.  Открыть базовую ссылку
//2.  Нажать на лого компании
//
//3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась

    @Test
    public void testClikLogoConfirmNotChang() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);



        driver.quit();

    }

//    TC_11_09
//1.  Открыть базовую ссылку
//2.  В строке поиска в навигационной панели набрать “Rome”
//
//3.  Нажать клавишу Enter
//4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
//5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”
//

    @Test
    public void testSearchRomeEnterConfirmFindAndRome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);



        driver.quit();

    }

//    TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок

    @Test
    public void testClickApiEnterConfirmThirtyButtoms() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\5850\\Хромдрайвер\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);



        driver.quit();

    }









}
