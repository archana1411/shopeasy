package com.tri.shopping.shopeasy;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tri.shopping.shopeasy.bm.ProductBM;
import com.tri.shopping.shopeasy.model.ProductInfo;
import com.tri.shopping.shopeasy.model.Visitor;
import com.tri.shopping.shopeasy.util.CommonUtil;
import com.tri.shopping.shopeasy.util.Log4jInit;

/**
 * Shopping Application 
 * 
 * @author Archana Trimukhe
 *
 */
public class ShoppingApp {

	private static final Logger LOGGER = Logger.getLogger(ShoppingApp.class.getName());
	private final ProductBM productBM = ProductBM.getInstance();

	static {
		Log4jInit.getInstance().init();
	}

	/**
	 * Shopping application process :
	 * a. fetch product enquiry
	 * b. get product details stored
	 * c. based on product id -> fetch corresponding product -> update name 
	 * 
	 * @throws JsonProcessingException in case error occurrs during printing objects
	 */
	private void process() throws JsonProcessingException {
		// fetch product enquiry from (product-enquiry.json) file
		Visitor visitor = productBM.getProductEnquiry();
		LOGGER.info("Product Enquiry : \n" + CommonUtil.toString(visitor));

		// fetch the product info (id, name) details from product-info.json
		ProductInfo productInfo = productBM.getProductInfo();
		LOGGER.info("Static Product Info : \n" + CommonUtil.toString(productInfo));

		// Update name info for available products
		productBM.updateProducts(visitor, productInfo);

		LOGGER.info("After Product Info Updated : \n" + CommonUtil.toString(visitor));
	}

	/**
	 * Entry point of shopping application 
	 * 
	 * @param args
	 * @throws JsonProcessingException
	 */
	public static void main(String[] args) throws JsonProcessingException {
		new ShoppingApp().process();
	}
}