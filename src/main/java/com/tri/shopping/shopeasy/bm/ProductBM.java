package com.tri.shopping.shopeasy.bm;

import java.util.Optional;

import org.apache.log4j.Logger;

import com.tri.shopping.shopeasy.constant.ShoppingConstant;
import com.tri.shopping.shopeasy.model.Product;
import com.tri.shopping.shopeasy.model.ProductInfo;
import com.tri.shopping.shopeasy.model.Visitor;
import com.tri.shopping.shopeasy.util.CommonUtil;

public class ProductBM implements IProductBM {

	private static final ProductBM productBM = new ProductBM();
	private CommonUtil commonUtil = CommonUtil.getInstance();
	private static final Logger LOGGER = Logger.getLogger(ProductBM.class.getName());

	/**
	 * Applied singleton - get single object of ProductBM
	 * 
	 * @return {@ProductBM }
	 */
	public static ProductBM getInstance() {
		return productBM;
	}
	
	/**
	 * applied singleton design pattern for this class
	 */
	private ProductBM() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Visitor getProductEnquiry() {
		LOGGER.info("Fetching product enquiry details");
		return (Visitor) CommonUtil.unmarshall(commonUtil.getFile(ShoppingConstant.PRODUCT_ENQUIRY_FILE),
				Visitor.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductInfo getProductInfo() {
		LOGGER.info("Fetching product Info");
		return (ProductInfo) CommonUtil.unmarshall(commonUtil.getFile(ShoppingConstant.PRODUCT_INFO_FILE),
				ProductInfo.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Product> getProduct(ProductInfo productInfo, Product productToSearch) {
		return productInfo.getProducts().stream().filter(product -> product != null && productToSearch != null
				&& product.getId().equals(productToSearch.getId())).findFirst();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateProducts(Visitor visitor, ProductInfo productInfo) {
		visitor.getProducts().stream().forEach(productToSearch -> {
			Optional<Product> product = getProduct(productInfo, productToSearch);
			if (product.isPresent()) {
				LOGGER.info("Product [" + product.get().getId() + "] found");
				productToSearch.setName(product.get().getName());
				LOGGER.info("Update Product [" + product.get().getId() + "] Complete");
			} else {
				LOGGER.info("Product [" + productToSearch.getId() + "] NOT found");
			}
		});
	}
}
