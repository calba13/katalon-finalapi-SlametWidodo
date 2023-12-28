import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//'STEP : Create Booking '
//WebUI.callTestCase(findTestCase('TC-Create Booking'), [('firstname') : firstname, ('lastname') : lastname, ('totalprice') : totalprice
//        , ('depositpaid') : depositpaid, ('checkin') : checkin, ('checkout') : checkout, ('additionalneeds') : additionalneeds], 
//    FailureHandling.STOP_ON_FAILURE)

//'STEP : Create TOKEN'
//WebUI.callTestCase(findTestCase('TC-Create Token'), [:], FailureHandling.STOP_ON_FAILURE)

'STEP : UPDATE PARTIAL'
CustomKeywords.'bookingFeature.bisnisLogic.updatePartialById'(findTestObject('REST-API/PUT - Partial Update Booking', [('baseurl') : GlobalVariable.BASEURL, ('id') : GlobalVariable.BOOKING_ID
            , ('token') : GlobalVariable.TOKEN, ('firstname') : "UPDATE PARTIAL dari ID ${GlobalVariable.BOOKING_ID}", ('lastname') : "MrQC dari ID ${GlobalVariable.BOOKING_ID}"]))

//WS.sendRequest(WS.sendRequest(findTestObject('REST-API/PUT - Partial Update Booking', [('baseurl') : GlobalVariable.BASEURL, ('id') : GlobalVariable.BOOKING_ID
//            , ('token') : GlobalVariable.TOKEN, ('firstname') : "UPDATE PARTIAL dari ID ${GlobalVariable.BOOKING_ID}", ('lastname') : "MrQC dari ID ${GlobalVariable.BOOKING_ID}"])))



