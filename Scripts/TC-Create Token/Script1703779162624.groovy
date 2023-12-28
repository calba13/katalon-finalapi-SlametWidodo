import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import internal.GlobalVariable as GlobalVariable


'STEP : CREATE TOKEN'
CustomKeywords.'bookingFeature.bisnisLogic.createToken'(findTestObject('REST-API/POST - Auth - CreateToken', [('baseurl') : GlobalVariable.BASEURL]))

//WS.sendRequest(findTestObject('REST-API/POST - Auth - CreateToken', [('baseurl') : GlobalVariable.BASEURL]))

