import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PierwszeTesty {

    private WebDriver driver;
//@Before - tag mówiący nam o tym że wszytko w metodzie setup musi być wykonane przed
//uruchomienie testu
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }
    //@After - jest połączony z teardown uruchamia się zawsze po zakończeniu testu
    @After
    public void tearDown() {
        //quit - zamknij przegladarke
        driver.quit();
    }
    //@Test-jest to tag który mówi nam że metoda testcase1 jest jest metodą testową
    @Ignore
    @Test
    public void testCase1() {
        //metoda get otwiera nam stone adres internetowy
        driver.get("https://www.google.com/");
        //metoda sendKeys wpisuje tekst to jakiegoś pola
        driver.findElement(By.name("q")).sendKeys("test");
    }
    @Ignore
    @Test
    public void logowaniedofaceboook() throws InterruptedException {
        //Krok 1 - otwieramy strone
        driver.get("http://facebook.com");
        //Krok 2 - w okienko adres email wpisujemy maila
        //1. znajdz okienko 2. wpisz tekst
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("test");
        Thread.sleep(5000);

        //Krok 3 - w okienku hasło wpisujemy hasło
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("test");
        Thread.sleep(5000);
        //Krok 4 - kliknij zaloguj się
        //1.znajdz element 2.kliknij na niego
        WebElement zaloguj = driver.findElement(By.id("u_0_b"));
        zaloguj.click();
        Thread.sleep(5000);
    }
    @Ignore
    @Test
    public void logowanie (){
        //krok 1 - otwieramy strone
            driver.get("http://zadaniadlatestera.pl/textBox.html");
        //krok 2 - wpsiujemy login
            WebElement login = driver.findElement(By.id("login"));
            login.sendKeys("testLogin");
        //krok 3 - wpisujemy hasło
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("testPassword");
        //krok 4 - klikamy przycisk prześlij
            WebElement przeslij = driver.findElement(By.id("sendLogin"));
            przeslij.click();
    }
    @Ignore
    @Test
    public void rejestracja(){
        //otwórz strone
        driver.get("http://zadaniadlatestera.pl/textBox.html");
        //wypełnij imie
        WebElement imie = driver.findElement(By.id("name"));
        imie.sendKeys("testImie");
        // wypelnij nazwisko
        WebElement nazwisko = driver.findElement(By.id("surname"));
        nazwisko.sendKeys("testNazwisko");
        //wypełnij pesel
        WebElement pesel = driver.findElement(By.id("personalId"));
        pesel.sendKeys("testPesel");
        //wypełnij nmer telefonu
        WebElement telefon = driver.findElement(By.name("phoneNumber"));
        telefon.sendKeys("1234567");
        //kliknij wyslij zapytanie
        WebElement wyslij = driver.findElement(By.name("send"));
        wyslij.click();

    }
    @Ignore
    @Test
    public void ankieta(){
        //otwieramy strone
        driver.get("http://zadaniadlatestera.pl/radioButton.html");

        //wybierz płeć
        WebElement kobieta = driver.findElement(By.id("woman"));
        kobieta.click();
        //wybierz wiek
        WebElement wiek = driver.findElement(By.id("age2"));
        wiek.click();
        //wybierz wykształcenie
        WebElement wyksztalcenie = driver.findElement(By.id("level2"));
        wyksztalcenie.click();
        //wybierz miasto
        WebElement miasto = driver.findElement(By.id("city"));
        miasto.click();
        //czy lubisz prace
        WebElement praca = driver.findElement(By.id("yes"));
        praca.click();
        //wyslij
        WebElement zapytanie = driver.findElement(By.name("send"));
        zapytanie.click();

    }
    @Ignore
    @Test
    public void checkboxy(){
        driver.get("http://zadaniadlatestera.pl/checkbox.html");
        WebElement czytanie = driver.findElement(By.id("reading"));
        if(czytanie.isSelected()){
            czytanie.click();
        }
        czytanie.click();
        WebElement puzzle = driver.findElement(By.name("puzzle"));
        puzzle.click();
        WebElement taniec = driver.findElement(By.name("dancing"));
        taniec.click();

    }
    @Ignore
    @Test
    public void select() throws InterruptedException {
        driver.get("http://zadaniadlatestera.pl/select.html");
        Select gatunek = new Select(driver.findElement(By.name("sort")));
        //wybierz z listy "hymn"
        gatunek.selectByValue("Hymn");
        Thread.sleep(3000);

        Select wiek = new Select(driver.findElement(By.name("age")));
        wiek.selectByIndex(1);
        Thread.sleep(3000);

        Select regal = new Select(driver.findElement(By.name("place")));
        regal.selectByVisibleText("VI");
        regal.selectByIndex(0);
        regal.selectByValue("vii");

        //wpisac numer porządkowy
        WebElement porzadkowy = driver.findElement(By.id("index"));
        porzadkowy.sendKeys("testPorzadkowy");
        //zanzaczyc osobe Pawłą Mkiuś
        Select osoba = new Select(driver.findElement(By.name("personName")));
        osoba.selectByValue("osoba4");
        //kliknij wyślij zapytanie
        WebElement zapytanie = driver.findElement(By.id("send"));
        zapytanie.click();
    }

    @Ignore
    @Test
    public void alert(){
        driver.get("http://zadaniadlatestera.pl/alert1.html");
        WebElement decyzja = driver.findElement(By.id("dec"));
        decyzja.click();
        Alert alert = driver.switchTo().alert();
        //klikamy ok
        //alert.accept();
        //klikamy anuluj
        alert.dismiss();
    }

    @Test
    public void alert2(){
        driver.get("http://zadaniadlatestera.pl/alert1.html");
        //wpisz index do textboxa
        WebElement index = driver.findElement(By.id("index"));
        index.sendKeys("1");
        //kliknij Skasuj
        WebElement skasuj = driver.findElement(By.id("delete"));
        skasuj.click();
        //zaakceptuj alert
        WebElement decyzja = driver.findElement(By.id("dec"));
        decyzja.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


}


