package com.reactiveworks.productwebservice.dao;

import org.apache.log4j.Logger;

import com.reactiveworks.productwebservice.dao.implementation.ProductDaoCSVImpl;
import com.reactiveworks.productwebservice.dao.implementation.ProductDaoMysqlImpl;

/**
 * Factory class for ProductDao.
 */
public class ProductDaoFactory {

	private static final Logger LOGGER_OBJ = Logger.getLogger("UserDaoFactory.class");
	private static final String CSV = "csv";
	private static final String MYSQL = "mysql";
	private String implType;
	private ProductDaoMysqlImpl productDaoMysqlImpl;
	private ProductDaoCSVImpl productDaoCSVImpl;

	public String getImplType() {
		return implType;
	}

	public void setImplType(String implType) {
		this.implType = implType;
	}

	public ProductDaoMysqlImpl getProductDaoMysqlImpl() {
		return productDaoMysqlImpl;
	}

	public void setProductDaoMysqlImpl(ProductDaoMysqlImpl productDaoMysqlImpl) {
		this.productDaoMysqlImpl = productDaoMysqlImpl;
	}

	public ProductDaoCSVImpl getProductDaoCSVImpl() {
		return productDaoCSVImpl;
	}

	public void setProductDaoCSVImpl(ProductDaoCSVImpl productDaoCSVImpl) {
		this.productDaoCSVImpl = productDaoCSVImpl;
	}

	/**
	 * Creates the object of UserDao implementation class.
	 * 
	 * @return the ProductDao implementation class object.
	 */
	public IProductDao getInstance() {
		LOGGER_OBJ.debug("execution of getInstance() started");
		IProductDao productDaoObj;
		switch (implType) {

		case CSV:
			productDaoObj = productDaoCSVImpl;
			break;
		case MYSQL:
			productDaoObj = productDaoMysqlImpl;
			break;
		default:
			productDaoObj = productDaoMysqlImpl;

		}
		LOGGER_OBJ.debug("execution of getInstance() completed");
		return productDaoObj;
	}

}
