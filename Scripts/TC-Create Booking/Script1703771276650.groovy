import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import internal.GlobalVariable as GlobalVariable

'STEP : Running API create Booking'
CustomKeywords.'bookingFeature.bisnisLogic.createBooking'(findTestObject('REST-API/POST - Create Booking', [('baseurl') : GlobalVariable.BASEURL, ('firstname') : firstname
	, ('lastname') : lastname, ('totalprice') : totalprice, ('depositpaid') : depositpaid, ('checkin') : checkin, ('checkout') : checkout
	, ('additionalneeds') : additionalneeds]), firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds)


//WS.sendRequest(findTestObject('REST-API/POST - Create Booking', [('baseurl') : GlobalVariable.BASEURL, ('firstname') : 'Hactiv8'
//	, ('lastname') : 'MrQC', ('totalprice') : 100, ('depositpaid') : true, ('checkin') : '2023-12-28', ('checkout') : '2024-01-01'
//	, ('additionalneeds') : 'Party'])) 

