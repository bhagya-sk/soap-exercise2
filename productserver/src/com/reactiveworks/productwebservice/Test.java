package com.reactiveworks.productwebservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.reactiveworks.productwebservice.dao.exceptions.DaoOperationNotSupportedException;
import com.reactiveworks.productwebservice.dao.exceptions.ProductDataAccessFailureDaoException;
import com.reactiveworks.productwebservice.dao.implementation.ProductDaoCSVImpl;

public class Test {

	public static void main(String[] args) throws IOException, DaoOperationNotSupportedException, ProductDataAccessFailureDaoException {
//		BufferedWriter output;
//		File file = new File(Test.class.getClassLoader().getResource("log4j.properties").getFile());
//		System.out.println(file);
//		//output = new BufferedWriter(new FileWriter("C:\\Users\\reactiveworks13\\soap-webservice\\soapn-exercise\\productserver\\src\\test.txt",true));  //clears file every time
//		
////		output = new BufferedWriter(new FileWriter("Product.csv",true));
////		
////		output.append("New Line!");
////		output.newLine();
////		output.close();
////		
//		ProductDaoCSVImpl csv=new ProductDaoCSVImpl();
//		csv.insertProduct(csv.getProducts().get(1));
		
	}

}
