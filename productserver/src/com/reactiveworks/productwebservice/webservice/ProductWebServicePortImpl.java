package com.reactiveworks.productwebservice.webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.reactiveworks.productwebservice.dao.IProductDao;
import com.reactiveworks.productwebservice.dao.exceptions.DaoOperationFailureException;
import com.reactiveworks.productwebservice.dao.exceptions.DaoOperationNotSupportedException;
import com.reactiveworks.productwebservice.dao.exceptions.ProductDataAccessFailureDaoException;

/**
 * Provides web service to the clients.
 * 
 */

@javax.jws.WebService(serviceName = "ProductWebServiceService", portName = "ProductWebServicePort", targetNamespace = "http://webservice.productwebservice.reactiveworks.com/", wsdlLocation = "file:/C:/Users/reactiveworks13/soap-webservice/soapn-exercise/productserver/WebContent/wsdl/productwebservice.wsdl", endpointInterface = "com.reactiveworks.productwebservice.webservice.ProductWebService")

public class ProductWebServicePortImpl implements ProductWebService {

	private static final Logger LOG = Logger.getLogger(ProductWebServicePortImpl.class.getName());
	@Autowired
	private IProductDao productDao;

	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * adds products into the database.
	 * 
	 * @param product list of products to be inserted into the database.
	 * @throws ProductWebServiceFailureException_Exception when product webservice
	 *                                                     fails.
	 */
	public java.lang.String addProducts(Products products) throws ProductWebServiceFailureException_Exception {
		LOG.info("Executing operation addProducts");

		try {
			if(products.getProduct().size()==1) {
				productDao.insertProduct(products.getProduct().get(0));
			} else {
				productDao.insertProducts(products.getProduct());	
			}
			
		} catch (DaoOperationNotSupportedException | DaoOperationFailureException e) {
			throw new ProductWebServiceFailureException_Exception("unable to add product(s)", e);
		}

		return "product(s) are successfully added.";
	}

	/**
	 * gets products from the database.
	 * 
	 * @param productId id of the product to be fetched from the database.
	 * @return the product with the given id or the list of products if id is not
	 *         mentioned.
	 * @throws ProductWebServiceFailureException_Exception when product webservice
	 *                                                     fails.
	 */
	public java.util.List<com.reactiveworks.productwebservice.webservice.Product> getProducts(
			java.lang.String productId)
			throws ProductWebServiceFailureException_Exception, ProductNotAvailableException_Exception {
		LOG.info("Executing operation getProducts");
		List<Product> products=null ;

		try {
			if (productId == null) {
				products = productDao.getProducts();
				if(products.size()==0) {
					throw new ProductNotAvailableException_Exception("Products are not available");
				}
			} else {
				Product product=productDao.getProduct(productId);
				if(product==null) {
					throw new ProductNotAvailableException_Exception("Product with the id "+productId+" is not available");
				}
				products=new ArrayList<Product>();
				products.add(product);

			}

		} catch (ProductDataAccessFailureDaoException | DaoOperationFailureException e) {
			throw new ProductWebServiceFailureException_Exception("unable to fetch products data " , 
					e);
		}
		return products;
		
	}

	/**
	 * deletes the product with the given id from the database.
	 * 
	 * @param productId id of the product to be deleted.
	 * @throws ProductWebServiceFailureException_Exception when product webservice
	 *                                                     fails.
	 */
	public java.lang.String deleteProduct(DeleteProduct parameters)
			throws ProductWebServiceFailureException_Exception, ProductIDMissingException_Exception ,ProductNotAvailableException_Exception{
		LOG.info("Executing operation deleteProduct");
		try {
			if(parameters.getProductId()==null) {
				throw new ProductIDMissingException_Exception("product id is required to delete the product");
			}
			if(productDao.deleteProduct(parameters.getProductId().trim())!=1) {
				throw new ProductNotAvailableException_Exception("product with the id "+parameters.getProductId()+" is not available");
			}
		} catch (DaoOperationNotSupportedException | DaoOperationFailureException e) {
			throw new ProductWebServiceFailureException_Exception("ProductWebService failed  " ,
					e);
		}
		
		return "product with id "+parameters.getProductId()+" is deleted.";
	}

	/**
	 * updates the product in the database.
	 * 
	 * @param parameters  id of the product to be updated.
	 * 
	 * @throws ProductWebServiceFailureException_Exception when product webservice
	 *                                                     fails.
	 * @throws ProductNotAvailableException_Exception when the product is not presentn the database.
	 */
	public java.lang.String updateProduct(UpdateProduct parameters)
			throws ProductWebServiceFailureException_Exception, ProductNotAvailableException_Exception,ProductIDMissingException_Exception {
		LOG.info("Executing operation updateProduct");
		int num;
		try {
			if(parameters.getProductId()==null) {
				throw new ProductIDMissingException_Exception("id is required to update the product.");
				
			}
			if(parameters.getPrice()!=null) {
				num=productDao.updateProduct(parameters.getProductId().trim(), parameters.getProductName(), parameters.getProductCategory(), parameters.getPrice(), parameters.getAvailableCities());
			}else {
				num=productDao.updateProduct(parameters.getProductId().trim(), parameters.getProductName(), parameters.getProductCategory(), 0, parameters.getAvailableCities());
			}
			
			if(num==0) {
				throw new ProductNotAvailableException_Exception("Product is not available");
			}
			
			if(num==2) {
				throw new ProductWebServiceFailureException_Exception(
						"updation of product failed ");
			}
			
		} catch (DaoOperationNotSupportedException | DaoOperationFailureException e) {
			throw new ProductWebServiceFailureException_Exception(
					"updation of product failed " , e);
		}
		return "updation of product details is successful";
	}

}
