
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import com.galenframework.testng.GalenTestNgTestBase;
import Utils.ExcelUtils;


public class ChromeTC extends GalenTestNgTestBase  {
	@Override
	 public WebDriver createDriver(Object[] args) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/resources/chromedriver.exe");
	        return new ChromeDriver();
    }
	
	@Test(dataProvider="UrlAndResolution")
	    public void welcomePage_shouldLookGood_onDesktopDevice(String url,String width,String height,String specFile) throws IOException {
	        load(url, Integer.parseInt(width), Integer.parseInt(height));
	        checkLayout(System.getProperty("user.dir")+"/specs/"+specFile, null); }


	@DataProvider(name="UrlAndResolution")
	public  Object[][] loginData() throws IOException {
		Object[][] arrayObject = ExcelUtils.getExcelData(System.getProperty("user.dir")+"/resources/dataprovider.xlsx","Sheet1");
		return arrayObject;
	}
	

}

