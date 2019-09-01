package com.tri.shopping.shopeasy.util;

import java.io.File;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tri.shopping.shopeasy.constant.ShoppingConstant;
import com.tri.shopping.shopeasy.model.Product;
import com.tri.shopping.shopeasy.model.Visitor;

import junit.framework.TestCase;

public class CommonUtilTest extends TestCase {

	private final CommonUtil commonUtil = CommonUtil.getInstance();
	private Visitor expectedVisitor = new Visitor();

	@Test
	public void testGetFile() {
		File file = commonUtil.getFile(ShoppingConstant.PRODUCT_ENQUIRY_FILE);
		assertNotNull(file);
	}

	@Test
	public void testGetInstance() {
		assertNotNull(CommonUtil.getInstance());
	}

	@Test
	public void testUnmarshall() {
		Visitor actualVisitor = (Visitor) CommonUtil.unmarshall(commonUtil.getFile(ShoppingConstant.PRODUCT_ENQUIRY_FILE),
				Visitor.class);
		
		assertNotNull(actualVisitor);
		assertNotNull(actualVisitor.getProducts());

		expectedVisitor.setId("V1");
		expectedVisitor.setProducts(Arrays.asList(new Product("P101", null, new BigDecimal(0.7, new MathContext(1))),
				new Product("P102", null, new BigDecimal(0.5, new MathContext(1)))));
		
		assertEquals(expectedVisitor.getProducts().size(), actualVisitor.getProducts().size());
		assertTrue(expectedVisitor.getProducts().get(0).equals(actualVisitor.getProducts().get(0)));
		assertTrue(expectedVisitor.getProducts().get(1).equals(actualVisitor.getProducts().get(1)));
	}

	@Test
	public void testToStringObject() {
		Visitor actualVisitor = (Visitor) CommonUtil.unmarshall(commonUtil.getFile(ShoppingConstant.PRODUCT_ENQUIRY_FILE),
				Visitor.class);

		String actualJsonStirng = null;
		try {
			actualJsonStirng = CommonUtil.toString(actualVisitor);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		assertEquals("{\r\n" + 
				"  \"id\" : \"V1\",\r\n" + 
				"  \"products\" : [ {\r\n" + 
				"    \"id\" : \"P101\",\r\n" + 
				"    \"name\" : null,\r\n" + 
				"    \"interest\" : 0.7\r\n" + 
				"  }, {\r\n" + 
				"    \"id\" : \"P102\",\r\n" + 
				"    \"name\" : null,\r\n" + 
				"    \"interest\" : 0.5\r\n" + 
				"  } ]\r\n" + 
				"}", actualJsonStirng);
	}

}
