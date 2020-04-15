package com.reactiveworks.productwebservice.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.reactiveworks.productwebservice.dao.IProductDao;
import com.reactiveworks.productwebservice.dao.exceptions.DaoOperationFailureException;
//import com.reactiveworks.productwebservice.model.Product;
import com.reactiveworks.productwebservice.webservice.Product;

/**
 * Mysql implementation of ProductDao.
 */
public class ProductDaoMysqlImpl extends JdbcDaoSupport implements IProductDao {

	private static final Logger LOGGER_OBJ = Logger.getLogger("ProductDaoMysqlImpl.class");
	private static final String INSERT_QUERY = "INSERT INTO product VALUES(?,?,?,?);";
	private static final String INSERT_CITIES_QUERY = "INSERT INTO availablecities VALUES(?,?);";

	private static final String UPDATE_QUERY = "UPDATE availablecities SET city=? WHERE productId=?;";
	private static final String DELETE_QUERY = "DELETE FROM product WHERE productId=?;";
	private static final String SELECT_QUERY = "SELECT * FROM product ;";
	private static final String SELECT_BY_ID_QUERY = "SELECT * FROM product where productId=?;";
	private String QUERY ;
	private TransactionTemplate transactionTemplate;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	/**
	 * Gets the records from the product database.
	 * 
	 * @return the list of products into the database.
	 * @throws DaoOperationFailureException when database operation fails.
	 */
	@Override
	public List<Product> getProducts() throws DaoOperationFailureException {
		LOGGER_OBJ.debug("execution of getProducts() started");
		List<Product> productsList = null;

		try {
			productsList = getJdbcTemplate().query(SELECT_QUERY, new ProductMapper());
		} catch (DataAccessException dataAccessExp) {
			LOGGER_OBJ.error("unable to get products from database");
			throw new DaoOperationFailureException("operation failed because  " + dataAccessExp.getMessage(),
					dataAccessExp);
		}

		LOGGER_OBJ.debug("execution of getProducts() completed");
		return productsList;
	}

	/**
	 * Gets the product with given id from the product database.
	 * 
	 * @param productId the id of the product to be fetched from the database.
	 * @return the product with the given id from the database.
	 * @throws DaoOperationFailureException when database operation fails.
	 */
	@Override
	public Product getProduct(String productId) throws DaoOperationFailureException {
		Product product = null;
		try {
			product = getJdbcTemplate().queryForObject(SELECT_BY_ID_QUERY, new Object[] { productId },
					new ProductMapper());
		} catch (IncorrectResultSizeDataAccessException e) {
			return product;
		} catch (DataAccessException dataAccessExp) {
			LOGGER_OBJ.error("unable to get product from database: " + dataAccessExp.getMessage());
			throw new DaoOperationFailureException("unable to fetch products", dataAccessExp);
		}
		return product;
	}

	/**
	 * Inserts the record into the product database.
	 * 
	 * @param product object of the product.
	 * @throws DaoOperationFailureException when database operation fails.
	 */
	@Override
	public void insertProduct(Product product) throws DaoOperationFailureException {
		LOGGER_OBJ.debug("execution of insertProduct() started");
		try {
			getJdbcTemplate().update(INSERT_QUERY, new Object[] { product.getProductId(), product.getProductName(),
					product.getProductCategory(), product.getPrice() });
			getJdbcTemplate().batchUpdate(INSERT_CITIES_QUERY, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
					preparedStatement.setString(1, product.getProductId());
					preparedStatement.setString(2, product.getAvailableCities().get(i));
				}

				@Override
				public int getBatchSize() {
					int size = 0;
					if (product.getAvailableCities() != null)
						size = product.getAvailableCities().size();
					return size;
				}

			});
		} catch (DataAccessException dataAccessExp) {
			LOGGER_OBJ.error("unable to add product");
			throw new DaoOperationFailureException("unable to add product", dataAccessExp);
		}
		LOGGER_OBJ.debug("execution of insertProduct() completed");
	}

	/**
	 * inserts records into the database.
	 * 
	 * @param products list of products to be inserted into the database.
	 * @throws DaoOperationFailureException when dao operation fails.
	 */
	public void insertProducts(List<Product> products) throws DaoOperationFailureException {
		LOGGER_OBJ.debug("execution of insertProducts() started");

		try {

			transactionTemplate.execute(new TransactionCallback<Void>() {

				@Override
				public Void doInTransaction(TransactionStatus status) {

					getJdbcTemplate().batchUpdate(INSERT_QUERY, new BatchPreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
							preparedStatement.setString(1, products.get(i).getProductId());
							preparedStatement.setString(2, products.get(i).getProductName());
							preparedStatement.setString(3, products.get(i).getProductCategory());
							preparedStatement.setDouble(4, products.get(i).getPrice());

						}

						@Override
						public int getBatchSize() {

							return products.size();
						}

					});

					for (int index = 0; index < products.size(); index++) {
						int i[] = { index };
						getJdbcTemplate().batchUpdate(INSERT_CITIES_QUERY, new BatchPreparedStatementSetter() {

							@Override
							public void setValues(PreparedStatement preparedStatement, int j) throws SQLException {

								preparedStatement.setString(1, products.get(i[0]).getProductId());
								preparedStatement.setString(2, products.get(i[0]).getAvailableCities().get(j));
							}

							@Override
							public int getBatchSize() {

								return products.get(i[0]).getAvailableCities().size();
							}

						});
					}

					return null;
				}
			});

		} catch (DataAccessException dataAccessExp) {
			LOGGER_OBJ.error("unable to insert products ");
			throw new DaoOperationFailureException("unable to insert products ", dataAccessExp);
		}

		LOGGER_OBJ.debug("execution of insertRecords() completed");
	}

	/**
	 * deletes the given record from the product database.
	 * 
	 * @param productId id of the product to be deleted.
	 * @return the integer value.
	 * @throws DaoOperationFailureException when operation on the database fails.
	 */
	@Override
	public int deleteProduct(String productId) throws DaoOperationFailureException {
		LOGGER_OBJ.debug("execution of deleteProduct() started");
		int num;
		try {
			num = getJdbcTemplate().update(DELETE_QUERY, new Object[] { productId });
		} catch (DataAccessException dataAccessExp) {
			LOGGER_OBJ.error("unable to delete product ");
			throw new DaoOperationFailureException("unable to delete product ", dataAccessExp);
		}
		LOGGER_OBJ.debug("execution of deleteProduct() completed");
		return num;
	}

	/**
	 * updates the record in the product database.
	 * 
	 * @param product product to be updated.
	 * @param price   updated value of the product price.
	 * @return the integer value.
	 * @throws DaoOperationFailureException when operation on the database fails.
	 */

	@Override
	public int updateProduct(String productId, String productName, String productCategory, double price,
			List<String> cities) throws DaoOperationFailureException {

		LOGGER_OBJ.debug("execution of updateProduct() started");
        QUERY="update product set ";
		int num[] = { 0 };
		boolean flag = false;
		if (productName != null && productCategory != null && price != 0) {
			QUERY += "productName='" + productName + "', productCategory='" + productCategory + "',price=" + price;
			flag = true;
		} else if (productName != null && productCategory != null && price == 0) {
			QUERY += "productName='" + productName + "', productCategory='" + productCategory + "'";
			flag = true;
		} else if (productName == null && productCategory != null && price != 0) {
			QUERY += "productCategory='" + productCategory + "',price=" + price;
			flag = true;
		} else if (productName != null && productCategory == null && price != 0) {
			QUERY += "productName='" + productName + "',price=" + price;
			flag = true;
		} else if (productName != null && productCategory == null && price == 0) {
			QUERY += "productName='" + productName + "'";
			flag = true;
		} else if (productName == null && productCategory != null && price == 0) {
			QUERY += "productCategory='" + productCategory + "'";
			flag = true;
		} else if (productName == null && productCategory == null && price != 0) {
			QUERY += "price=" + price;
			flag = true;
		}

		final boolean flag1 = flag;
		try {
			transactionTemplate.execute(new TransactionCallback<Void>() {

				@Override
				public Void doInTransaction(TransactionStatus status) {

					if (flag1) {
						QUERY += " where productId='" + productId + "';";
						num[0] = getJdbcTemplate().update(QUERY);
					}
					
					if (cities != null) {
						num[0] = 1;
						int[] updateStatus = getJdbcTemplate().batchUpdate(UPDATE_QUERY, new BatchPreparedStatementSetter() {

							@Override
							public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
								preparedStatement.setString(2, productId);
								preparedStatement.setString(1, cities.get(i));
							}

							@Override
							public int getBatchSize() {

								return cities.size();
							}
						});
						
						if(updateStatus.length ==0 || updateStatus[0]==0) {
							status.setRollbackOnly();
							num[0]=2;
						}
					}

					return null;

				}
			});
		} catch (DataAccessException dbAccessExp) {
			LOGGER_OBJ.error("unable to update data of the product with id " + productId);
			throw new DaoOperationFailureException("unable to update product with id " + productId,
					dbAccessExp);
		}

		LOGGER_OBJ.debug("execution of updateProduct() completed");
		return num[0];
	}

	/**
	 * maps database row fields to the product object parameters.
	 */
	private class ProductMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(resultSet.getString(1));
			product.setProductName(resultSet.getString(2));
			product.setProductCategory(resultSet.getString(3));
			product.setPrice(resultSet.getDouble(4));
			List<String> cities = getJdbcTemplate().query("select * from availablecities where productId=?;",
					new Object[] { resultSet.getString(1) }, new RowMapper<String>() {

						@Override
						public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {

							return resultSet.getString(2);
						}
					});
			product.setAvailableCities(cities);
			return product;
		}

	}

}
