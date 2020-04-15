
package com.reactiveworks.productwebservice.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.reactiveworks.productwebservice.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddProducts_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "addProducts");
    private final static QName _UpdateProductResponse_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "updateProductResponse");
    private final static QName _AddProductsResponse_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "addProductsResponse");
    private final static QName _DeleteProduct_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "deleteProduct");
    private final static QName _DeleteProductResponse_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "deleteProductResponse");
    private final static QName _GetProducts_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "getProducts");
    private final static QName _GetProductsResponse_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "getProductsResponse");
    private final static QName _ProductWebServiceFailureException_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "ProductWebServiceFailureException");
    private final static QName _ProductNotAvailableException_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "ProductNotAvailableException");
    private final static QName _ProductIDMissingException_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "ProductIDMissingException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.reactiveworks.productwebservice.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Products }
     * 
     */
    public Products createProducts() {
        return new Products();
    }

    /**
     * Create an instance of {@link DeleteProduct }
     * 
     */
    public DeleteProduct createDeleteProduct() {
        return new DeleteProduct();
    }

    /**
     * Create an instance of {@link GetProducts }
     * 
     */
    public GetProducts createGetProducts() {
        return new GetProducts();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     * 
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link UpdateProduct }
     * 
     */
    public UpdateProduct createUpdateProduct() {
        return new UpdateProduct();
    }

    /**
     * Create an instance of {@link ProductWebServiceFailureException }
     * 
     */
    public ProductWebServiceFailureException createProductWebServiceFailureException() {
        return new ProductWebServiceFailureException();
    }

    /**
     * Create an instance of {@link ProductNotAvailableException }
     * 
     */
    public ProductNotAvailableException createProductNotAvailableException() {
        return new ProductNotAvailableException();
    }

    /**
     * Create an instance of {@link ProductIDMissingException }
     * 
     */
    public ProductIDMissingException createProductIDMissingException() {
        return new ProductIDMissingException();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Products }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "addProducts")
    public JAXBElement<Products> createAddProducts(Products value) {
        return new JAXBElement<Products>(_AddProducts_QNAME, Products.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "updateProductResponse")
    public JAXBElement<String> createUpdateProductResponse(String value) {
        return new JAXBElement<String>(_UpdateProductResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "addProductsResponse")
    public JAXBElement<String> createAddProductsResponse(String value) {
        return new JAXBElement<String>(_AddProductsResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "deleteProduct")
    public JAXBElement<DeleteProduct> createDeleteProduct(DeleteProduct value) {
        return new JAXBElement<DeleteProduct>(_DeleteProduct_QNAME, DeleteProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "deleteProductResponse")
    public JAXBElement<String> createDeleteProductResponse(String value) {
        return new JAXBElement<String>(_DeleteProductResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "getProducts")
    public JAXBElement<GetProducts> createGetProducts(GetProducts value) {
        return new JAXBElement<GetProducts>(_GetProducts_QNAME, GetProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "getProductsResponse")
    public JAXBElement<GetProductsResponse> createGetProductsResponse(GetProductsResponse value) {
        return new JAXBElement<GetProductsResponse>(_GetProductsResponse_QNAME, GetProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductWebServiceFailureException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "ProductWebServiceFailureException")
    public JAXBElement<ProductWebServiceFailureException> createProductWebServiceFailureException(ProductWebServiceFailureException value) {
        return new JAXBElement<ProductWebServiceFailureException>(_ProductWebServiceFailureException_QNAME, ProductWebServiceFailureException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductNotAvailableException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "ProductNotAvailableException")
    public JAXBElement<ProductNotAvailableException> createProductNotAvailableException(ProductNotAvailableException value) {
        return new JAXBElement<ProductNotAvailableException>(_ProductNotAvailableException_QNAME, ProductNotAvailableException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductIDMissingException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "ProductIDMissingException")
    public JAXBElement<ProductIDMissingException> createProductIDMissingException(ProductIDMissingException value) {
        return new JAXBElement<ProductIDMissingException>(_ProductIDMissingException_QNAME, ProductIDMissingException.class, null, value);
    }

}
