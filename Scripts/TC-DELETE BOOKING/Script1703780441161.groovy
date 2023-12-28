import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable



//'STEP : Create Booking '
//WebUI.callTestCase(findTestCase('TC-Create Booking'), [('firstname') : firstname, ('lastname') : lastname, ('totalprice') : totalprice
//		, ('depositpaid') : depositpaid, ('checkin') : checkin, ('checkout') : checkout, ('additionalneeds') : additionalneeds],
//	FailureHandling.STOP_ON_FAILURE)

//'STEP : Create TOKEN'
//WebUI.callTestCase(findTestCase('TC-Create Token'), [:], FailureHandling.STOP_ON_FAILURE)

'STEP : DELETE BOOKING'
CustomKeywords.'bookingFeature.bisnisLogic.deleteBooking'(findTestObject('REST-API/PUT - Delete Booking', [('baseurl') : GlobalVariable.BASEURL, ('id') : GlobalVariable.BOOKING_ID, ('token') : GlobalVariable.TOKEN]))

//WS.sendRequest(findTestObject('REST-API/PUT - Delete Booking', [('baseurl') : GlobalVariable.BASEURL, ('id') : 2341, ('token') : 'b5029f111e77f3d']))

