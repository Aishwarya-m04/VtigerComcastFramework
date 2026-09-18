package practise;

import static org.testng.Assert.assertEquals;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClassTest;

public class ListnerPrgm extends BaseClassTest {
	
	@Test(retryAnalyzer = retryUtility.RetryImpClass.class)
	public void createinvoiceTest() {
		System.out.println("execute create invoice test");
		@Nullable
		String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, "Login");
        System.out.println("step 1");
        System.out.println("step 2");
		
	}
	@Test
	public void  createInvoicewithContactTest() {
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("step1");
	}

}
