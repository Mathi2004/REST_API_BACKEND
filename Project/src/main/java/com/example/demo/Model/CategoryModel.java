package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="maincategory")
public class CategoryModel {
  @Id
  private int categoryID;
	private String name1;
	private String description1;
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getDescription1() {
		return description1;
	}
	public void setDescription1(String description1) {
		this.description1 = description1;
	}
	public CategoryModel(int categoryID, String name1, String description1) {
		super();
		this.categoryID = categoryID;
		this.name1 = name1;
		this.description1 = description1;
	}
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
