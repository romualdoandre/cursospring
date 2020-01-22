package com.educandoweb.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="tb_order_item")
public class OrderItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderItemPK id;
	private Integer quantity;
	private Double price;
	
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		this.id = new OrderItemPK();
		this.id.setProduct(product);
		this.id.setOrder(order);
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItem() {
		this.id = new OrderItemPK();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@JsonIgnore
	public Order getOrder() {
		return this.id.getOrder();
	}
	
	public Product getProduct() {
		return this.id.getProduct();
	}
	
	public void setOrder(Order order) {
		this.id.setOrder(order);
	}
	
	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	public void setId(OrderItemPK id) {
		this.id = id;
	}
	
	public Double getSubTotal() {
		return price*quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
