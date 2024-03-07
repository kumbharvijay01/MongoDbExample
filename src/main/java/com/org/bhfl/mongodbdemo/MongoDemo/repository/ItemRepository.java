/**
 * 
 */
package com.org.bhfl.mongodbdemo.MongoDemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.bhfl.mongodbdemo.MongoDemo.entity.GroceryItem;

/**
 * @author vijaykumbhar
 *
 */
@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, Integer> {

	@Query("{name:'?0',quantity:?1}")
	GroceryItem findItemByName(String name, Long qty);

//	List<GroceryItem> findAll(String category);
	List<GroceryItem> findByName(String name);

	List<GroceryItem> findByCategory(String category);

	List<GroceryItem> findByNameAndCategory(String name, String category);

	List<GroceryItem> findByNameOrCategory(String name, String category);
	

}
