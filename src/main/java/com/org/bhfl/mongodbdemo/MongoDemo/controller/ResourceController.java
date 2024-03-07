/**
 * 
 */
package com.org.bhfl.mongodbdemo.MongoDemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhfl.mongodbdemo.MongoDemo.entity.GroceryItem;
import com.org.bhfl.mongodbdemo.MongoDemo.repository.ItemRepository;

/**
 * @author vijaykumbhar
 *
 */
@RestController
public class ResourceController {

	@Autowired
	ItemRepository repository;

	@PostMapping("/findbycategory")
	public List<GroceryItem> findbycat() {
		return repository.findByCategory("Pencil");
	}

	@GetMapping("/add")
	public List<GroceryItem> add(@RequestBody GroceryItem groceryItem) {
		System.out.println("Data creation started...");
		repository.save(groceryItem);
		return repository.findAll();
	}

	@PostMapping("/addnew")
	public List<GroceryItem> addnew(@RequestBody GroceryItem groceryItem) {
		long totalRecords = repository.count();
		totalRecords += 1;
		groceryItem.setId((int) totalRecords);
		GroceryItem item = repository.save(groceryItem);
		System.out.println("Grosary Added for " + item.toString());
		return repository.findAll();

	}

	@PostMapping("/addnewcollection")
	public List<GroceryItem> addnewcollection(@RequestBody List<GroceryItem> groceryItem) {
		List<GroceryItem> list = new ArrayList<>();
		for (GroceryItem groceryItem2 : groceryItem) {
			long totalRecords = repository.count();
			totalRecords += 1;
			groceryItem2.setId((int) totalRecords);
			list.add(groceryItem2);

		}
		repository.saveAll(list);
		repository.deleteAll();
		repository.count();
		repository.findByName(null);
		if (repository.existsById(1)) {
			System.out.println("ID found in MONGO DB");
		} else {
			System.out.println("ID NOT FOUND for Update");
		}

		return repository.findAll();
	}

	@GetMapping("/find")
	public List<GroceryItem> find(@RequestParam String name) {
		return repository.findByName(name);
	}

	@GetMapping("/alldata")
	public List<GroceryItem> allData() {
		return repository.findAll();
	}

	@DeleteMapping("/delete")
	public List<GroceryItem> delete(@RequestParam Integer id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	@PatchMapping("/update")
	public GroceryItem update(@RequestParam Integer id, @RequestBody GroceryItem groceryItem) {
		Optional<GroceryItem> item = repository.findById(id);
		if (item.isPresent()) {
			GroceryItem obj = item.get();
			obj.setCategory(groceryItem.getCategory());
			obj.setName(groceryItem.getName());
			obj.setQuantity(groceryItem.getQuantity());
			repository.save(obj);
			return obj;
		} else {
			return null;
		}
	}

//	@GetMapping("/findx")
//	public GroceryItem findx(@RequestParam String name) {
////		return repository.findItemByName(name);
//		return repository.
//	repo
//	}
//	
}
