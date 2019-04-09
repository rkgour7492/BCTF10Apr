package Utils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;

import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

public class ReportGenerator {

	public static void generateHTMLReport(LayoutReport layoutreport,String specfile){
		List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

		// Create a GalenTestInfo object
		GalenTestInfo test = GalenTestInfo.fromString(specfile.split(".") + " layout");

		// Get layoutReport and assign to test object
		test.getReport().layout(layoutreport, "check " + specfile.split(".") + " layout");

		// Add test object to the tests list
		tests.add(test);

		// Create a htmlReportBuilder object
		HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

		// Create a report under /target folder based on tests list
		try {
			htmlReportBuilder.build(tests, "target");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// If layoutReport has errors Assert Fail
		if (layoutreport.errors() > 0) {
			Assert.fail("Layout test failed");
		}
	}
}
