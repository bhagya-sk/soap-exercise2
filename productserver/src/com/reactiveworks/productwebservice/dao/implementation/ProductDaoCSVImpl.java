package com.reactiveworks.productwebservice.dao.implementation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.reactiveworks.productwebservice.dao.IProductDao;
import com.reactiveworks.productwebservice.dao.exceptions.DaoOperationNotSupportedException;
import com.reactiveworks.productwebservice.dao.exceptions.InvalidProductDetailFormatDaoException;
import com.reactiveworks.productwebservice.dao.exceptions.ProductDataAccessFailureDaoException;
//import com.reactiveworks.productwebservice.model.Product;
import com.reactiveworks.productwebservice.webservice.Product;

/**
 * CSV implementation of product dao.
 */
public class ProductDaoCSVImpl implements IProductDao {

	//private static final String FILE_NAME = "Product.csv";
	private static final Logger LOGGER_OBJ = Logger.getLogger("ProductDaoCSVImpl.class");

	/**
	 * Gets the records from the product database.
	 * 
	 * @return the list of products into the database.
	 * @throws DataBaseAccessException when unable to access the database.
	 */
	public List<Product> getProducts() throws ProductDataAccessFailureDaoException {
		LOGGER_OBJ.debug("execution of getDBRecords() started");
		File file = new File("Product.csv");
		List<Product> products;

		try (Stream<String> line = Files.lines(Paths.get(file.toURI()))) {

			products = line.skip(1).map(str -> {
				try {
					return parseCSVLine(str);
				} catch (InvalidProductDetailFormatDaoException exp) {
					LOGGER_OBJ.error(exp.getMessage());
				}
				return null;
			}).collect(Collectors.toList());
		} catch (IOException ioExp) {
			LOGGER_OBJ.error("unable to access the product with id= ");
			throw new ProductDataAccessFailureDaoException("unable to access the product database", ioExp);

		}
		LOGGER_OBJ.debug("execution of getDBRecords() completed");
		return products;
	}

	/**
	 * converts one line in csv file to the product object.
	 * 
	 * @param str the string which has to be parsed.
	 * @return the object of the product.
	 * @throws InvalidDBRecordFormatException when the operation is not supported by
	 *                                        the database.
	 */
	private Product parseCSVLine(String str) throws InvalidProductDetailFormatDaoException {
		LOGGER_OBJ.debug("execution of parseLine() started");
		Product productObj = new Product();
		String[] prodDetails = str.split(",");

		productObj.setProductId(prodDetails[0]);
		productObj.setProductName(prodDetails[1]);
		productObj.setProductCategory(prodDetails[2]);
		String cities[] = prodDetails[4].split("/");
		List<String> citiesList = new ArrayList<>();
		for (String strObj : cities) {
			citiesList.add(strObj);
		}
		productObj.setAvailableCities(citiesList);

		try {
			double price = Double.parseDouble(prodDetails[3]);
			productObj.setPrice(price);
		} catch (NumberFormatException numFormatExp) {
			LOGGER_OBJ.error("format of the database record price is invalid in " + str);
			throw new InvalidProductDetailFormatDaoException(
					"format of the database record price is invalid" + numFormatExp);
		}
		LOGGER_OBJ.debug("execution of parseLine() completed");
		return productObj;
	}

	public String generateCSV(Product product) {
		String str = "";
		str = product.getProductId() + "," + product.getProductName() + "," + product.getProductCategory() + ","+product.getPrice().intValue()+",";
		List<String> cities=product.getAvailableCities();
		for(int index=0;index<cities.size();index++) {
			
			str+=cities.get(index);
			if(index!=cities.size()-1) {
				str+="/";
			}
		}
		System.out.println(str);
		return str;
	}

	/**
	 * Inserts the record into the product database.
	 * 
	 * @param product object of the product.
	 * @throws DaoOperationNotSupportedException when operation is not supported by
	 *                                           the database.
	 */
	public void insertProduct(Product product) throws DaoOperationNotSupportedException {
		//File file = new File(FILE_NAME);
		BufferedWriter output;
		try {
			output = new BufferedWriter(new FileWriter("D:\\Product.csv", true));
			output.newLine();
			output.append(generateCSV(product));
			output.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * deletes the given record from the product database.
	 * 
	 * @param product object of the product.
	 * @throws OperationNotSupportedException when operation is not supported by the
	 *                                        database.
	 */
	public void deleteProduct(Product product) throws DaoOperationNotSupportedException {
		throw new DaoOperationNotSupportedException("delete Operation is not supported by product database");

	}

	/**
	 * Inserts the record into the product database.
	 * 
	 * @param product object of the product.
	 * @throws DaoOperationNotSupportedException when operation is not supported by
	 *                                           the database.
	 */
	@Override
	public void insertProducts(List<Product> products) throws DaoOperationNotSupportedException {
		throw new DaoOperationNotSupportedException("update Operation is not supported by product database");

	}

	/**
	 * deletes the record from the product database.
	 * 
	 * @param productId id of the product to be deleted from the database.
	 * @throws DaoOperationNotSupportedException when operation is not supported by
	 *                                           the database.
	 */
	@Override
	public int deleteProduct(String productId) throws DaoOperationNotSupportedException {
		throw new DaoOperationNotSupportedException("delete Operation is not supported by product database");

	}

	/**
	 * updates the record in the product database.
	 * 
	 * @throws OperationNotSupportedException when operation is not supported by the
	 *                                        database.
	 */
	@Override
	public int updateProduct(String productId, String productName, String productCategory, double price,
			List<String> cities) throws DaoOperationNotSupportedException {
		throw new DaoOperationNotSupportedException("update Operation is not supported by product database");

	}

	public Product getProduct(String productId) {

		return null;
	}
}