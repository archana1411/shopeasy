package com.tri.shopping.shopeasy.bm;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

import org.junit.Test;

import com.tri.shopping.shopeasy.model.Product;
import com.tri.shopping.shopeasy.model.ProductInfo;
import com.tri.shopping.shopeasy.model.Visitor;

import junit.framework.TestCase;

public class ProductBMTest extends TestCase {

	private final ProductBM productBM = ProductBM.getInstance();
	
	@Test
	public void testGetInstance() {
		assertNotNull(ProductBM.getInstance());
	}

	@Test
	public void testGetProductEnquiry() {
		Visitor visitor = productBM.getProductEnquiry();
		assertNotNull(visitor);
		assertNotNull(visitor.getProducts());
		assertEquals(2, visitor.getProducts().size());
	}

	@Test
	public void testGetProductInfo() {
		ProductInfo productInfo = productBM.getProductInfo();
		assertNotNull(productInfo);
		assertNotNull(productInfo.getProducts());
		assertEquals(6, productInfo.getProducts().size());
	}

	@Test
	public void testGetProduct() {
		ProductInfo productInfo = productBM.getProductInfo();
		Optional<Product> product = productBM.getProduct(productInfo, new Product("P101", null, new BigDecimal(0.7, new MathContext(1))));
		assertTrue(product.isPresent());
		Optional<Product> product2 = productBM.getProduct(productInfo, new Product("P300", null, new BigDecimal(0.7, new MathContext(1))));
		assertTrue(product2.isEmpty());
	}

	@Test
	public void testUpdateProducts() {
		Visitor visitor = productBM.getProductEnquiry();
		ProductInfo productInfo = productBM.getProductInfo();
		productBM.updateProducts(visitor, productInfo);
		
		Optional<Product> product = visitor.getProducts().stream().filter(productToSearch -> productToSearch.getName()!=null).findAny();
		assertTrue(product.isPresent());
	}

}
