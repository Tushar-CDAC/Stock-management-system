package com.stock.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.entity.Items;
import com.stock.entity.Warehouse;
import com.stock.repository.ItemsRepository;
import com.stock.repository.WarehouseRepository;

@Service
@Transactional
public class WarehouseService {

	public WarehouseService(WarehouseRepository warehouseRepository, ItemsRepository itemsRepository) {
		super();
		this.warehouseRepository = warehouseRepository;
		this.itemsRepository = itemsRepository;
	}

	private final WarehouseRepository warehouseRepository;
	
	private final ItemsRepository itemsRepository;

	public Warehouse getById(int id) {
		return warehouseRepository.findByWarehouseId(id);
	}

	public Warehouse save(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}

	public List<Warehouse> findAll() {
		return warehouseRepository.findAll();
	}

	public Warehouse findByWarehouse(int id) {
		return itemsRepository.findByWarehouse(id);
	}
	
	public Items findByWarehouseIdAndName(Warehouse wid, int iid) {
		return itemsRepository.findByWarehouseAndItemId(wid, iid);	
	}


	
	
}
