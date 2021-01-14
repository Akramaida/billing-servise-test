package ru.habr;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriverChrome\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://habr.com/ru/");

        driver.findElement(By.xpath("//button[@class='btn btn_navbar_search icon-svg_search']")).click();
        driver.findElement(By.xpath("//input[@class='search-form__field']")).sendKeys("Dins", Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='tabs-menu__item tabs-menu__item_link'][2]")).click();
        driver.findElement(By.xpath("//a[@class='list-snippet__title-link']")).click();
        driver.findElement(By.xpath("//a[@class='tabs-menu__item tabs-menu__item_link'][1]")).click();

        WebElement nameCompany = driver.findElement(By.xpath("//h2[@class='profile-section__title'][1]"));
        String compName = nameCompany.getText();
        WebElement nameTechnology = driver.findElement(By.xpath("//b[1]"));
        String techName = nameTechnology.getText();

        System.out.println(compName);
        assertThat(compName).isEqualTo("О компании");
        System.out.println(techName);
        assertThat(techName).isEqualTo("Ключевые технологии:");

        WebElement dateCompany = driver.findElement(By.xpath("//span[@class='defination-list__value'][1]"));
        String dateCompanyName = dateCompany.getText();
        System.out.println(dateCompanyName);
        assertThat(dateCompanyName).isEqualTo("1998 год");

        WebElement language = driver.findElement(By.xpath("//a[@class='footer__link js-show_lang_settings']"));
        language.click();
        language.findElement(By.xpath("//label[text() = 'English']")).click();
        language.findElement(By.xpath("//button[@class='btn btn_blue btn_huge btn_full-width js-popup_save_btn']")).click();

        WebElement ProfileEng = driver.findElement(By.xpath("//h3[contains(text(), 'Profile')]"));
        String nameProfileEng = ProfileEng.getText();
        System.out.println(nameProfileEng);
        assertThat(nameProfileEng).isEqualTo("PROFILE");

        WebElement BlogEng = driver.findElement(By.xpath("//h3[contains(text(), 'Blog')]"));
        String nameBlogEng = BlogEng.getText();
        System.out.println(nameBlogEng);
        assertThat(nameBlogEng).isEqualTo("BLOG");

        WebElement NewsEng = driver.findElement(By.xpath("//h3[contains(text(), 'News')]"));
        String nameNewsEng = NewsEng.getText();
        System.out.println(nameNewsEng);
        assertThat(nameNewsEng).isEqualTo("NEWS");

        WebElement VacanciesEng = driver.findElement(By.xpath("//h3[contains(text(), 'Vacancies')]"));
        String nameVacanciesEng = VacanciesEng.getText();
        System.out.println(nameVacanciesEng);
        assertThat(nameVacanciesEng).isEqualTo("VACANCIES");

        WebElement SubscribersEng = driver.findElement(By.xpath("//h3[contains(text(), 'Subscribers')]"));
        String nameSubscribersEng = SubscribersEng.getText();
        System.out.println(nameSubscribersEng);
        assertThat(nameSubscribersEng).isEqualTo("SUBSCRIBERS 111");

        WebElement EmployeesEng = driver.findElement(By.xpath("//h3[contains(text(), 'Employees')]"));
        String nameEmployeesEng = EmployeesEng.getText();
        System.out.println(nameEmployeesEng);
        assertThat(nameEmployeesEng).isEqualTo("EMPLOYEES 14");

        WebElement DateEng = driver.findElement(By.xpath("//span[@class='defination-list__value']"));
        String nameDateEng = DateEng.getText();
        System.out.println(nameDateEng);
        assertThat(nameDateEng).isEqualTo("Since 1998");


        driver.quit();
    }
}
