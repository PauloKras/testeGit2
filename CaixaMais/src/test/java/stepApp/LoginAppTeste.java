package stepApp;


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
public class LoginAppTeste  extends Base {

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
			driver.quit();
		} catch (Exception ign) {
		}
	}

	@Dado("que um usuário abra o app$")
	public void queUmUsuárioEstejaNaTelaDeLoginDoApp() throws InterruptedException, IOException {

		app = "appTeste";
//		app = super.propriedadeTeste("AppCaixa.properties", "app");
		
		driver = (AndroidDriver) super.openApp(driver, app);
//		super.pularTelasPermissões(driver);
//		scroll = new Scroll(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		String teste = Atalhos.botao;
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


