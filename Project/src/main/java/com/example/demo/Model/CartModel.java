package com.example.demo.Model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="maincart")
public class CartModel {
    @Id
    private int cartId;
    private int cartItemId;
    private int quantity;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_customerID")
    private CustomerModel cs;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CustomerModel getCs() {
		return cs;
	}
	public void setCs(CustomerModel cs) {
		this.cs = cs;
	}
	public CartModel(int cartId, int cartItemId, int quantity, CustomerModel cs) {
		super();
		this.cartId = cartId;
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.cs = cs;
	}
	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
