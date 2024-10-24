package step.Login;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import step.Base;
import app.core.Atalhos;
import utils.Scroll;
import utils.ConectarBanco;

/**
 * @author Paulo.Kras
 * 
 * 
 */

//@SuppressWarnings("deprecation")
public class Login extends Base {

	private static WebDriverWait wait;
	private static AppiumDriver driver;
	private static Scroll scroll;
	private static ConectarBanco conexao;
	private static Statement stmt = null;
	private static ResultSet res;
	
//	private static AndroidDriver driver;
	String app = null;
	int time = 1000;

	@Before
	public void setUp() throws MalformedURLException {

		conexao = new ConectarBanco();
	}

	@After(" @CenarioPrincipalLogin or @SmokeTestLogin")
	public void endSession() {
		try {
//			print.PrintPasso("Home");
			driver.quit();
		} catch (Exception ign) {
		}
	}

	@Dado("que um usuário esteja na tela de login do app$")
	public void queUmUsuárioEstejaNaTelaDeLoginDoApp() throws InterruptedException, IOException {

		app = "Caixa.apk";
		app = super.propriedadeTeste("AppCaixa.properties", "app");
		
		driver = (AndroidDriver) super.openApp(driver, app);
		super.pularTelasPermissões(driver);
		scroll = new Scroll(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String teste = Atalhos.botao;
	}


	@Dado("o cliente pessoa (.*) informa o (.*) e a (.*) para o login$")
	public void oClientePessoaFisicaInformaDadosDeLogin(String pessoa, String usuário, String senha) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//android.widget.Button[@resource-id='br.com.gabba.Caixa:id/accessBtn' and @text='Acessar minha conta']")));
		// Validar elementos da tela
		assertTrue(driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id='br.com.gabba.Caixa:id/textLembrar' and @text='Lembrar meu usuário']"))
				.isDisplayed());
		assertTrue(driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id='br.com.gabba.Caixa:id/userTxt' and @text='Usuário']"))
				.isDisplayed());
		assertTrue(driver.findElement(AppiumBy.xpath(
				"//android.widget.EditText[@resource-id='br.com.gabba.Caixa:id/passwordTxt' and @text='Senha']"))
				.isDisplayed());
		assertTrue(driver.findElement(AppiumBy.xpath(
				"//android.widget.RadioButton[@resource-id='br.com.gabba.Caixa:id/pessoaFisicaChk' and @text='Pessoa Física']"))
				.isDisplayed());
		assertTrue(driver.findElement(AppiumBy.xpath(
				"//android.widget.RadioButton[@resource-id='br.com.gabba.Caixa:id/pessoaJuridicaChk' and @text='Pessoa Jurídica']"))
				.isDisplayed());
		assertTrue(driver.findElement(AppiumBy.xpath(
				"//android.widget.Button[@resource-id='br.com.gabba.Caixa:id/firstAccessBtn' and @text='Não tenho usuário']"))
				.isDisplayed());
		assertTrue(driver.findElement(AppiumBy.xpath(
				"//android.widget.Button[@resource-id='br.com.gabba.Caixa:id/accessBtn' and @text='Acessar minha conta']"))
				.isDisplayed());			
		// Usuário
		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id='br.com.gabba.Caixa:id/userTxt' and @text='Usuário']"))
				.click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id='br.com.gabba.Caixa:id/userTxt' and @text='Usuário']"))
				.sendKeys("usuário");
		// Senha
		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id='br.com.gabba.Caixa:id/passwordTxt' and @text='Senha']"))
				.click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.EditText[@resource-id='br.com.gabba.Caixa:id/passwordTxt' and @text='Senha']"))
				.sendKeys("senha");
		// Pessoa
		driver.findElement(AppiumBy
				.xpath("//android.widget.RadioButton[@resource-id='br.com.gabba.Caixa:id/pessoa" + pessoa + "Chk']"))
				.click();
		((HidesKeyboard)driver).hideKeyboard(); 		
//		driver.hideKeyboard();	// somente AndroidDriver

		// Botão de acesso
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[(@resource-id,'br.com.gabba.Caixa:id/accessBtn') and (@text,'Acessar minha conta')]"))
				.click();
		
		System.out.println();
	}

	@Então("exibirá a tela inicial do app$")
	public void exibiráATelaInicialDoApp() throws InterruptedException {
		
		// teste scroll
		driver.findElement(AppiumBy
				.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"))
				.click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.TextView[@resource-id='br.com.gabba.Caixa:id/title' and @text='LOTERIAS CAIXA']"))
				.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//android.widget.FrameLayout[@resource-id='br.com.gabba.Caixa:id/frameLayout']")));	
		
		scroll.scrollVertical(80,60);

		System.out.println();
		sleep(1000);
		scroll.scrollVertical(40,90);

		System.out.println();
	}

	
	@Dado("^busca veiculo (.*)$")
	public void buscaVeiculo(String veiculo) throws Throwable {			
		
		conexao = new ConectarBanco();
		try {
			String sql =  "SELECT *\r\n"
						+ "FROM  bdpaulo.veiculos\r\n"
						+ "WHERE tipo = 'suv' "
						+ "AND categoria = 'estrada'";
			stmt = conexao.ObterConexao().createStatement();
			res = stmt.executeQuery(sql);
		
			if (res.next()) {
				System.out.println("Nome = " 		+ res.getString("Nome"));
				System.out.println("Tipo = " 		+ res.getString("Tipo"));
				System.out.println("Categoria = " 	+ res.getString("Categoria"));
			    }
			
		} catch (SQLException e) {
            e.printStackTrace();
        } finally{
        	stmt.close();
        	res.close();
        	conexao.ObterConexao().close();
        }		    
	}
	
	

}
