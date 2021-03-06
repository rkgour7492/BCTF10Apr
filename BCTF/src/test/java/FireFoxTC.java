
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import com.galenframework.api.Galen;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.testng.GalenTestNgTestBase;
import Utils.ExcelUtils;
import Utils.ReportGenerator;


public class FireFoxTC extends GalenTestNgTestBase  {
	@Override
	 public WebDriver createDriver(Object[] args) {
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/resources/geckodriver.exe");
	        return new FirefoxDriver();
    }
	
	@Test(dataProvider="UrlAndResolution")
	    public void welcomePage_shouldLookGood_onDesktopDevice(String url,String width,String height,String specFile) throws IOException {
		load(url, Integer.parseInt(width), Integer.parseInt(height));
		 LayoutReport layoutReport =Galen.checkLayout(this.getDriver(), System.getProperty("user.dir")+"/specs/"+specFile, Arrays.asList("desktop"));
		 ReportGenerator.generateHTMLReport(layoutReport, "Firefox"+" "+specFile);
	        } 		



	@DataProvider(name="UrlAndResolution")
	public  Object[][] loginData() throws IOException {
		Object[][] arrayObject = ExcelUtils.getExcelData(System.getProperty("user.dir")+"/resources/dataprovider.xlsx","Sheet1");
		return arrayObject;
	}
	

}


