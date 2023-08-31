package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="mainproduct")
public class ProductModel {
 @Id
 private int productid;
 private String name;
 private String description;
 private int price;
 private int priceQuantity;
 private String imageURL;
 @OneToMany(cascade=CascadeType.ALL)
 @JoinColumn(name="fk_category")
 private List<CategoryModel> aa;
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getPriceQuantity() {
	return priceQuantity;
}
public void setPriceQuantity(int priceQuantity) {
	this.priceQuantity = priceQuantity;
}
public String getImageURL() {
	return imageURL;
}
public void setImageURL(String imageURL) {
	this.imageURL = imageURL;
}
public List<CategoryModel> getAa() {
	return aa;
}
public void setAa(List<CategoryModel> aa) {
	this.aa = aa;
}
public ProductModel(int productid, String name, String description, int price, int priceQuantity, String imageURL,
		List<CategoryModel> aa) {
	super();
	this.productid = productid;
	this.name = name;
	this.description = description;
	this.price = price;
	this.priceQuantity = priceQuantity;
	this.imageURL = imageURL;
	this.aa = aa;
}
public ProductModel() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
}
