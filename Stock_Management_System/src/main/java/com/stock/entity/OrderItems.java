package com.stock.entity;

import javax.persistence.Id;

public class OrderItems {
	
	@Id
	public int quantity;
	public Warehouse warehouseId;
	public Items itemId;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Warehouse getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Warehouse warehouseId) {
		this.warehouseId = warehouseId;
	}
	public Items getItemId() {
		return itemId;
	}
	public void setItemId(Items itemId) {
		this.itemId = itemId;
	}
	public OrderItems(int quantity, Warehouse warehouseId, Items itemId) {
		super();
		this.quantity = quantity;
		this.warehouseId = warehouseId;
		this.itemId = itemId;
	}
	public OrderItems() {
		super();
	}	
	
	
}
