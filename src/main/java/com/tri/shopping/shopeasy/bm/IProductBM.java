package com.tri.shopping.shopeasy.bm;

import java.util.Optional;

import com.tri.shopping.shopeasy.model.Product;
import com.tri.shopping.shopeasy.model.ProductInfo;
import com.tri.shopping.shopeasy.model.Visitor;

/**
 * This class consists of all product related methods
 * 
 * @author Archana Trimukhe
 */
public interface IProductBM {

	/**
	 * Fetch the information of visitor for product enquiry from
	 * (product-enquiry.json) file
	 * 
	 * @return {@ProductInfo}
	 */
	Visitor getProductEnquiry();

	/**
	 * Fetch the information of product (id, name) details from product-info.json
	 * input file
	 * 
	 * @return
	 */
	ProductInfo getProductInfo();

	/**
	 * Search the product based on id
	 * 
	 * @param productInfo     collection information of all products
	 * @param productToSearch product to search
	 * @return
	 */
	Optional<Product> getProduct(ProductInfo productInfo, Product productToSearch);

	/**
	 * Update product names
	 * 
	 * @param visitor     visitor details consists products to update
	 * @param productInfo product info which has name details
	 */
	void updateProducts(Visitor visitor, ProductInfo productInfo);
}
