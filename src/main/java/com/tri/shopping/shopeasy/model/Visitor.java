/**
 * 
 */
package com.tri.shopping.shopeasy.model;

import java.util.ArrayList;
import java.util.List;

public class Visitor {
	private String id;
	private List<Product> products = new ArrayList<>();

	public Visitor() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", products=" + products + "]";
	}
}
