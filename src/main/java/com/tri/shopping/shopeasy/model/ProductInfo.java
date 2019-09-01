package com.tri.shopping.shopeasy.model;

import java.util.ArrayList;
import java.util.List;

public class ProductInfo {
	private List<Product> products = new ArrayList<>();

	public ProductInfo() {
		super();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
