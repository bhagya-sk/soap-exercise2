
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
    private final static QName _AddProductsResponse_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "addProductsResponse");
    private final static QName _DeleteProduct_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "deleteProduct");
    private final static QName _DeleteProductResponse_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "deleteProductResponse");
    private final static QName _GetProducts_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "getProducts");
    private final static QName _GetProductsResponse_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "getProductsResponse");
    private final static QName _ProductWebServiceFailureException_QNAME = new QName("http://webservice.productwebservice.reactiveworks.com/", "ProductWebServiceFailureException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.reactiveworks.productwebservice.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddProducts }
     * 
     */
    public AddProducts createAddProducts() {
        return new AddProducts();
    }

    /**
     * Create an instance of {@link AddProductsResponse }
     * 
     */
    public AddProductsResponse createAddProductsResponse() {
        return new AddProductsResponse();
    }

    /**
     * Create an instance of {@link DeleteProduct }
     * 
     */
    public DeleteProduct createDeleteProduct() {
        return new DeleteProduct();
    }

    /**
     * Create an instance of {@link DeleteProductResponse }
     * 
     */
    public DeleteProductResponse createDeleteProductResponse() {
        return new DeleteProductResponse();
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
     * Create an instance of {@link ProductWebServiceFailureException }
     * 
     */
    public ProductWebServiceFailureException createProductWebServiceFailureException() {
        return new ProductWebServiceFailureException();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "addProducts")
    public JAXBElement<AddProducts> createAddProducts(AddProducts value) {
        return new JAXBElement<AddProducts>(_AddProducts_QNAME, AddProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "addProductsResponse")
    public JAXBElement<AddProductsResponse> createAddProductsResponse(AddProductsResponse value) {
        return new JAXBElement<AddProductsResponse>(_AddProductsResponse_QNAME, AddProductsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.productwebservice.reactiveworks.com/", name = "deleteProductResponse")
    public JAXBElement<DeleteProductResponse> createDeleteProductResponse(DeleteProductResponse value) {
        return new JAXBElement<DeleteProductResponse>(_DeleteProductResponse_QNAME, DeleteProductResponse.class, null, value);
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

}
