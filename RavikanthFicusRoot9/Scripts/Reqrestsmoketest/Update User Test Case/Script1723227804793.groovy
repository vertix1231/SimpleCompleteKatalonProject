import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper
import internal.GlobalVariable as GlobalVariable

def jsonSlurper = new JsonSlurper()

responalluser = WS.sendRequest(findTestObject('Resreqservice/Listuser'))

getfixvalue = WS.getElementPropertyValue(responalluser, 'data[2].first_name', FailureHandling.STOP_ON_FAILURE)

println(getfixvalue)

GlobalVariable.username = getfixvalue

println('GET FIRST NAME VALUE USERS =========> ' + GlobalVariable.username)

responseupdateuser = WS.sendRequest(findTestObject('Resreqservice/UpdateUser', [('usernameaaa') : GlobalVariable.username]))

println('GET response update user VALUE USERS =========> ' + jsonSlurper.parseText(responseupdateuser.getResponseText()))

WS.verifyResponseStatusCode(responseupdateuser, 200)

WS.verifyElementPropertyValue(responseupdateuser, 'name', 'Tobias')

