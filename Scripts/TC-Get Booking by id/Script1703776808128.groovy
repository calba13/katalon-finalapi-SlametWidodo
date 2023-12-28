import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


//'STEP : Create Booking '
//WebUI.callTestCase(findTestCase('TC-Create Booking'), [('firstname') : firstname, ('lastname') : lastname, ('totalprice') : totalprice
//	, ('depositpaid') : depositpaid, ('checkin') : checkin, ('checkout') : checkout, ('additionalneeds') : additionalneeds],
//FailureHandling.STOP_ON_FAILURE)

'STEP : Get Data by ID'
CustomKeywords.'bookingFeature.bisnisLogic.getBookingById'(findTestObject('REST-API/GET- Get Booking Ids', [('baseurl') : GlobalVariable.BASEURL, ('id') : GlobalVariable.BOOKING_ID]))

// WS.sendRequest(findTestObject('REST-API/GET- Get Booking Ids', [('baseurl') : GlobalVariable.BASEURL, ('id') : id]))


