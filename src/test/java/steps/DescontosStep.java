package steps;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import runner.RunCucumberTest;

public class DescontosStep extends RunCucumberTest {

    @Dado("^que estou no site da QAzando$")
    public void acessar_site_QAzando(){
        driver.get("https://www.qazando.com.br/curso.html");
    }

    @Quando("^eu preencho meu email$")
    public void eu_preencho_meu_email() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("teste123@hotmail.com");
    }

    @E("^clico no botao Ganhar cupom$")
    public void clico_no_botao_Ganhar_cupom() throws Throwable {
        driver.findElement(By.id("form")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("button")).click();
    }

    @Entao("^eu vejo o codigo de desconto$")
    public void eu_vejo_o_codigo_de_desconto() throws Throwable {
        Thread.sleep(2000);
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        System.out.println("texto do cupon é : " + texto_cupom);
    }

}
