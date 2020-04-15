package com.reactiveworks.productwebservice.dao;

import java.util.List;

import com.reactiveworks.productwebservice.dao.exceptions.DaoOperationFailureException;
import com.reactiveworks.productwebservice.dao.exceptions.DaoOperationNotSupportedException;
import com.reactiveworks.productwebservice.dao.exceptions.ProductDataAccessFailureDaoException;
//import com.reactiveworks.productwebservice.model.Product;
import com.reactiveworks.productwebservice.webservice.Product;

/**
 * interface for productDao.
 */
public interface IProductDao {

	/**
	 * Gets the records from the product database.
	 * 
	 * @throws ProductDataAccessFailureDaoException when unable to fetch data from
	 *                                              the data source.
	 * @throws DaoOperationFailureException         when dao operation fails.
	 * @return the list of products into the database.
	 */
	public List<Product> getProducts() throws ProductDataAccessFailureDaoException, DaoOperationFailureException;

	/**
	 * Gets the records from the product database.
	 * 
	 * @param productId id of the product to be deleted.
	 * @throws DaoOperationFailureException when dao operation fails.
	 * @return the product with given id from the database.
	 */

	public Product getProduct(String productId) throws DaoOperationFailureException;

	/**
	 * Inserts the record into the product database.
	 * 
	 * @param product object of the product.
	 * @throws DaoOperationFailureException      when dao operation fails.
	 * @throws DaoOperationNotSupportedException when operation is not supported by
	 *                                           the database.
	 */
	public void insertProduct(Product product) throws DaoOperationNotSupportedException, DaoOperationFailureException;

	/**
	 * Inserts the products into the product database.
	 * 
	 * @param products list of products to be inserted into the database.
	 * @throws DaoOperationNotSupportedException when operation is not supported by
	 *                                           the database.
	 */
	public void insertProducts(List<Product> products) throws DaoOperationNotSupportedException,DaoOperationFailureException;

	/**
	 * Deletes the given record from the product database.
	 * 
	 * @param product product to be deleted from the database.
	 * @throws DaoOperationNotSupportedException when operation is not supported by
	 *                                           the database.
	 */
	public int deleteProduct(String productId) throws DaoOperationNotSupportedException,DaoOperationFailureException;

	/**
	 * Updates the record in the product database.
	 * 
	 * @param product product to be updated.
	 * @param price   updated value of the product price.
	 * @throws DaoOperationNotSupportedException when operation is not supported by
	 *                                           the database.
	 */
	public int updateProduct(String productId, String productName,String productCategory,double price,List<String> cities) throws DaoOperationNotSupportedException,DaoOperationFailureException;

}