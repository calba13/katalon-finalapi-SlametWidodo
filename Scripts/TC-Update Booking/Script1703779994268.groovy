import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


//'STEP : Create Booking '
//WebUI.callTestCase(findTestCase('TC-Create Booking'), [('firstname') : firstname, ('lastname') : lastname, ('totalprice') : totalprice
//		, ('depositpaid') : depositpaid, ('checkin') : checkin, ('checkout') : checkout, ('additionalneeds') : additionalneeds],
//	FailureHandling.STOP_ON_FAILURE)

'STEP : Create TOKEN'
WebUI.callTestCase(findTestCase('TC-Create Token'), [:], FailureHandling.STOP_ON_FAILURE)

'STEP : UPDATE BOOKING'
CustomKeywords.'bookingFeature.bisnisLogic.updateBookingById'(findTestObject('REST-API/PUT - Update Booking', [('baseurl') : GlobalVariable.BASEURL, ('id') : GlobalVariable.BOOKING_ID
            , ('token') : GlobalVariable.TOKEN, ('firstname') : "Hactiv8 UPDATE form ID ${GlobalVariable.BOOKING_ID}", ('lastname') : "MrQC UPDATE form ID ${GlobalVariable.BOOKING_ID}", ('totalprice') : 500, ('depositpaid') : false
            , ('checkin') : '2023-12-28', ('checkout') : '2024-01-01', ('additionalneeds') : "Party UPDATE form ID ${GlobalVariable.BOOKING_ID}"]))


//WS.sendRequest(findTestObject('REST-API/PUT - Update Booking', [('baseurl') : GlobalVariable.BASEURL, ('id') : GlobalVariable.BOOKING_ID
//            , ('token') : GlobalVariable.TOKEN, ('firstname') : "Hactiv8 UPDATE form ID ${GlobalVariable.BOOKING_ID}", ('lastname') : "MrQC UPDATE form ID ${GlobalVariable.BOOKING_ID}", ('totalprice') : 500, ('depositpaid') : false
//            , ('checkin') : '2023-12-28', ('checkout') : '2024-01-01', ('additionalneeds') : 'Party']))

