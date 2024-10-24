package com.ea.ravikanthficusroot.utilities

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper





public class CommonRavikanthFicusRootOne {

	@Keyword
	def checkDropDownListElementExist(TestObject testObject,String option) {
		boolean flag=false
		WebElement element = WebUiCommonHelper.findWebElement(testObject, 20);

		Select ddl = new Select(element)

		for(WebElement el:ddl.getOptions()) {
			if(el.getText().equals(option)) {
				println("Element found by locator ===> "+el.getText())
				flag=true
				break;
			}else {
				flag=false
				println("Element doesnt exist or not found by locator")
			}
		}
		return flag;
	}
}
