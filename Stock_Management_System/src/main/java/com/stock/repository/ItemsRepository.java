package com.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.entity.Items;
import com.stock.entity.Warehouse;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {
	
	public Warehouse findByWarehouse(int id);
	
	public Items findByWarehouseAndItemId(Warehouse wid,int iid);

	


}
	