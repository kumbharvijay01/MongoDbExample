/**
 * 
 */
package com.org.bhfl.mongodbdemo.MongoDemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vijaykumbhar
 *
 */
@Document("groceryitems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroceryItem {
	@Id
	private Integer id;
	private String name;
	private int quantity;
	private String category;
	private Long rate;
}
