package bookingFeature

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObjectimport static org.assertj.core.api.Assertions.*
import internal.GlobalVariable

public class bisnisLogic {

	@Keyword
	def extractData(def bagData) {
		// new customKW.common().cetak("bagData : ${bagData}");
		return bagData
	}

	@Keyword
	def createBooking(RequestObject request, firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds) {
		def defaultVar = new customKW.common().defaultVar();
		String tcTitle = "Execute API createBooking & Verify Response Code "
		try {

			def jsonResponse = new customKW.commonAPI().execute_API(request)

			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]

			'VERIFY DATA RESPONSE'
			jsonResponse.each{ key, value ->

				switch (key) {
					case("bookingid"):
						GlobalVariable.BOOKING_ID = value
						break;
					case ("booking"):
						'Fungsi extractData Booking'
						def tmpBooking = extractData(value)
						new customKW.common().cetak("tmpBooking firstname : ${tmpBooking}");
						boolean isSuccess = true

						'Verify firstname - Response vs DataBinding'
						if(!assertThat(tmpBooking.firstname).isEqualTo(firstname)) {
							defaultVar["messageList"] << ["message" : "Verify firstname : ${tmpBooking.firstname} | expectd ${firstname}"]
							defaultVar["messageList"] << ["message" : "QC STATUS : GOOD"]
							isSuccess = false
						}

						'Verify lastname - Response vs DataBinding'
						if(!assertThat(tmpBooking.lastname).isEqualTo(lastname)) {
							defaultVar["messageList"] << ["message" : "Verify lastname : ${tmpBooking.lastname} | expectd ${lastname}"]
							defaultVar["messageList"] << ["message" : "QC STATUS : GOOD"]
							isSuccess = false
						}

						'VERIFY Field lain dilanjut ... disini'

						if(isSuccess) {
							defaultVar["messageList"] << ["message" : "Verify firstname : ${tmpBooking.firstname} | expectd ${firstname}"]
							defaultVar["messageList"] << ["message" : "Verify lastname : ${tmpBooking.lastname} | expectd ${lastname}"]
							defaultVar["messageList"] << ["message" : "Verify totalprice : ${tmpBooking.totalprice} | expectd ${totalprice}"]
							defaultVar["messageList"] << ["message" : "Verify depositpaid : ${tmpBooking.depositpaid} | expectd ${depositpaid}"]
							defaultVar["messageList"] << ["message" : "Verify checkin : ${tmpBooking.bookingdates.checkin} | expectd ${checkin}"]
							defaultVar["messageList"] << ["message" : "Verify checkout : ${tmpBooking.bookingdates.checkout} | expectd ${checkout}"]
							defaultVar["messageList"] << ["message" : "Verify additionalneeds : ${tmpBooking.additionalneeds} | expectd ${additionalneeds}"]


							defaultVar["messageList"] << ["message" : "QC STATUS : GOOD"]
							defaultVar["messageList"] << ["message" : "RESPONSE : ${jsonResponse}"]
							defaultVar["messageList"] << ["message" : ""]
						}
						break;
					default:
						defaultVar["messageList"] << ["message" : "default pos RESPONSE : ${jsonResponse}"]
						defaultVar["messageList"] << ["message" : ""]
						break;
				}
			}
		} catch (Exception e) {

			defaultVar["isSuccess"] = false;
			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]
			defaultVar["messageList"] << ["message" : "Remark : Error Exception_ ${e}"]
			defaultVar["messageList"] << ["message" : "QC STATUS : NOT GOOD"]
			defaultVar["messageList"] << ["message" : ""]
		}



		new customKW.common().cetak("BOOKING_ID : ${GlobalVariable.BOOKING_ID}");
		new customKW.common().cetak("defaultVar : ${defaultVar}");
		new customKW.common().generateStepReport(defaultVar["isSuccess"], defaultVar["messageList"])
	}


	@Keyword
	def createToken(RequestObject request) {

		def defaultVar = new customKW.common().defaultVar();
		String tcTitle = "Execute API createToken & Verify Response Code "
		try {
			def jsonResponse = new customKW.commonAPI().execute_API(request)

			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]

			'VERIFY DATA RESPONSE'
			defaultVar["messageList"] << ["message" : "token : ${jsonResponse.token}"]

			defaultVar["messageList"] << ["message" : "QC STATUS : GOOD"]
			defaultVar["messageList"] << ["message" : "RESPONSE : ${jsonResponse}"]
			defaultVar["messageList"] << ["message" : ""]

			GlobalVariable.TOKEN = jsonResponse.token
		} catch (Exception e) {

			defaultVar["isSuccess"] = false;
			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]
			defaultVar["messageList"] << ["message" : "Remark : Error Exception_ ${e}"]
			defaultVar["messageList"] << ["message" : "QC STATUS : NOT GOOD"]
			defaultVar["messageList"] << ["message" : ""]
		}

		new customKW.common().cetak("defaultVar : ${defaultVar}");
		new customKW.common().generateStepReport(defaultVar["isSuccess"], defaultVar["messageList"])
	}


	@Keyword
	def getBookingById(RequestObject request) {

		def defaultVar = new customKW.common().defaultVar();
		String tcTitle = "Execute API getBookingById & Verify Response Code "
		try {
			new customKW.common().cetak("BOOKING_ID : ${GlobalVariable.BOOKING_ID}");
			def jsonResponse = new customKW.commonAPI().execute_API(request)

			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]

			'VERIFY DATA RESPONSE'
			defaultVar["messageList"] << ["message" : "firstname : ${jsonResponse.firstname}"]
			defaultVar["messageList"] << ["message" : "lastname : ${jsonResponse.lastname}"]
			defaultVar["messageList"] << ["message" : "totalprice : ${jsonResponse.totalprice}"]
			defaultVar["messageList"] << ["message" : "depositpaid : ${jsonResponse.depositpaid}"]
			defaultVar["messageList"] << ["message" : "checkin : ${jsonResponse.bookingdates.checkin}"]
			defaultVar["messageList"] << ["message" : "checkout : ${jsonResponse.bookingdates.checkout}"]
			defaultVar["messageList"] << ["message" : "additionalneeds : ${jsonResponse.additionalneeds}"]


			defaultVar["messageList"] << ["message" : "QC STATUS : GOOD"]
			defaultVar["messageList"] << ["message" : "RESPONSE : ${jsonResponse}"]
			defaultVar["messageList"] << ["message" : ""]
		} catch (Exception e) {

			defaultVar["isSuccess"] = false;
			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]
			defaultVar["messageList"] << ["message" : "Remark : Error Exception_ ${e}"]
			defaultVar["messageList"] << ["message" : "QC STATUS : NOT GOOD"]
			defaultVar["messageList"] << ["message" : ""]
		}

		new customKW.common().cetak("defaultVar : ${defaultVar}");
		new customKW.common().generateStepReport(defaultVar["isSuccess"], defaultVar["messageList"])
	}


	@Keyword
	def updatePartialById(RequestObject request) {

		def defaultVar = new customKW.common().defaultVar();
		String tcTitle = "Execute API updatePartialById & Verify Response Code "
		try {
			new customKW.common().cetak("BOOKING_ID : ${GlobalVariable.BOOKING_ID}");
			def jsonResponse = new customKW.commonAPI().execute_API(request)

			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]

			'VERIFY DATA RESPONSE'
			defaultVar["messageList"] << ["message" : "firstname : ${jsonResponse.firstname}"]
			defaultVar["messageList"] << ["message" : "lastname : ${jsonResponse.lastname}"]
			defaultVar["messageList"] << ["message" : "totalprice : ${jsonResponse.totalprice}"]
			defaultVar["messageList"] << ["message" : "depositpaid : ${jsonResponse.depositpaid}"]
			defaultVar["messageList"] << ["message" : "checkin : ${jsonResponse.bookingdates.checkin}"]
			defaultVar["messageList"] << ["message" : "checkout : ${jsonResponse.bookingdates.checkout}"]
			defaultVar["messageList"] << ["message" : "additionalneeds : ${jsonResponse.additionalneeds}"]


			defaultVar["messageList"] << ["message" : "QC STATUS : GOOD"]
			defaultVar["messageList"] << ["message" : "RESPONSE : ${jsonResponse}"]
			defaultVar["messageList"] << ["message" : ""]
		} catch (Exception e) {

			defaultVar["isSuccess"] = false;
			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]
			defaultVar["messageList"] << ["message" : "Remark : Error Exception_ ${e}"]
			defaultVar["messageList"] << ["message" : "QC STATUS : NOT GOOD"]
			defaultVar["messageList"] << ["message" : ""]
		}

		new customKW.common().cetak("defaultVar : ${defaultVar}");
		new customKW.common().generateStepReport(defaultVar["isSuccess"], defaultVar["messageList"])
	}


	@Keyword
	def updateBookingById(RequestObject request) {

		def defaultVar = new customKW.common().defaultVar();
		String tcTitle = "Execute API updatePartialById & Verify Response Code "
		try {
			new customKW.common().cetak("BOOKING_ID : ${GlobalVariable.BOOKING_ID}");
			def jsonResponse = new customKW.commonAPI().execute_API(request)

			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]

			'VERIFY DATA RESPONSE'
			defaultVar["messageList"] << ["message" : "firstname : ${jsonResponse.firstname}"]
			defaultVar["messageList"] << ["message" : "lastname : ${jsonResponse.lastname}"]
			defaultVar["messageList"] << ["message" : "totalprice : ${jsonResponse.totalprice}"]
			defaultVar["messageList"] << ["message" : "depositpaid : ${jsonResponse.depositpaid}"]
			defaultVar["messageList"] << ["message" : "checkin : ${jsonResponse.bookingdates.checkin}"]
			defaultVar["messageList"] << ["message" : "checkout : ${jsonResponse.bookingdates.checkout}"]
			defaultVar["messageList"] << ["message" : "additionalneeds : ${jsonResponse.additionalneeds}"]


			defaultVar["messageList"] << ["message" : "QC STATUS : GOOD"]
			defaultVar["messageList"] << ["message" : "RESPONSE : ${jsonResponse}"]
			defaultVar["messageList"] << ["message" : ""]
		} catch (Exception e) {

			defaultVar["isSuccess"] = false;
			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]
			defaultVar["messageList"] << ["message" : "Remark : Error Exception_ ${e}"]
			defaultVar["messageList"] << ["message" : "QC STATUS : NOT GOOD"]
			defaultVar["messageList"] << ["message" : ""]
		}

		new customKW.common().cetak("defaultVar : ${defaultVar}");
		new customKW.common().generateStepReport(defaultVar["isSuccess"], defaultVar["messageList"])
	}


	@Keyword
	def deleteBooking(RequestObject request) {

		def defaultVar = new customKW.common().defaultVar();
		String tcTitle = "Execute API updatePartialById & Verify Response Code "
		try {
			new customKW.common().cetak("BOOKING_ID : ${GlobalVariable.BOOKING_ID}");
			def jsonResponse = new customKW.commonAPI().execute_API(request)

			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]

			'VERIFY DATA RESPONSE'
			defaultVar["messageList"] << ["message" : "QC STATUS : GOOD"]
			defaultVar["messageList"] << ["message" : "RESPONSE : ${jsonResponse}"]
			defaultVar["messageList"] << ["message" : ""]
		} catch (Exception e) {

			defaultVar["isSuccess"] = false;
			defaultVar["messageList"] << ["message" : "TestCase : ${tcTitle}"]
			defaultVar["messageList"] << ["message" : "Remark : Error Exception_ ${e}"]
			defaultVar["messageList"] << ["message" : "QC STATUS : NOT GOOD"]
			defaultVar["messageList"] << ["message" : ""]
		}

		new customKW.common().cetak("defaultVar : ${defaultVar}");
		new customKW.common().generateStepReport(defaultVar["isSuccess"], defaultVar["messageList"])
	}
}
