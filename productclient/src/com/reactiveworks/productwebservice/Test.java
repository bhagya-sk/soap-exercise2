package com.reactiveworks.productwebservice;

import com.reactiveworks.productwebservice.webservice.ProductWebService;
import com.reactiveworks.productwebservice.webservice.ProductWebServiceFailureException_Exception;
import com.reactiveworks.productwebservice.webservice.ProductWebServiceService;

public class Test {

	public static void main(String[] args) throws ProductWebServiceFailureException_Exception {
		ProductWebServiceService service=new ProductWebServiceService();
		ProductWebService port = service.getProductWebServicePort();
		port.getProducts("Pro010");

	}

}
