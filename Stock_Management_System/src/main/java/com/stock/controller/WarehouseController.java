package com.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.entity.Items;
import com.stock.entity.Warehouse;
import com.stock.repository.ItemsRepository;
import com.stock.repository.WarehouseRepository;
import com.stock.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	
	 private static final Logger LOGGER=LoggerFactory.getLogger(WarehouseController.class);
	
	public WarehouseController(WarehouseService warehouseService, WarehouseRepository warehouseRepository,
			ItemsRepository itemRepository) {
		super();
		this.warehouseService = warehouseService;
		this.warehouseRepository = warehouseRepository;
		this.itemRepository = itemRepository;
	}

	private final WarehouseService warehouseService;
	
	private final WarehouseRepository warehouseRepository;
	
	private ItemsRepository itemRepository;

	@GetMapping("/get/{id}")
	public ResponseEntity<Warehouse> findById(@PathVariable("id") int id) {
		return ResponseEntity.ok(warehouseService.getById(id));
	}
	
	@GetMapping("/getall")
	public List<Warehouse> generateWarehousesReport() {
        return warehouseRepository.findAll();
    }
	
	@PostMapping("/add")
	public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
		List<Items> items = new ArrayList<>();
		items = warehouse.getItems();
		warehouse.setItems(null);
		Warehouse warehouse1 = warehouseService.save(warehouse);

		for (Items item : items) {
			item.setWarehouse(warehouse1);
		}
		warehouse1.setItems(items);
		LOGGER.info("Warehouse added");
		return ResponseEntity.ok(warehouseService.save(warehouse1));
	}
		
	@GetMapping("getById/{wid}/{iid}")
	public ResponseEntity<?> getStockDetails(@PathVariable("wid") Warehouse id2, @PathVariable("iid") int id1) {	
	Items items=warehouseService.findByWarehouseIdAndName(id2, id1);
		LOGGER.info("Current stock");
		return ResponseEntity.ok(items.getCurrentStock());
	}
	
//	@GetMapping("order/{wid}/{iid}/{get}")
//	public ResponseEntity<?> getSt()
}
