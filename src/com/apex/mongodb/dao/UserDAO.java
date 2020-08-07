package com.apex.mongodb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;
import com.apex.mongodb.vo.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@Repository
public class UserDAO {

	static String db_name = "mydb", db_collection = "user";

	MongoClient mongoClient = new MongoClient("localhost", 27017);
	DB database = mongoClient.getDB(db_name);
	DBCollection collection = database.getCollection(db_collection);

	// Add a new user to the mongo database.
	public void addUser(User user) {
		Random ran_number = new Random();

		System.out.println("Adding a new user to the mongo database; Entered user_name is= " + user.getFirstName());
		try {

			// Create a new object and add the new user details to this object.
			BasicDBObject document = new BasicDBObject();
			document.put("id", String.valueOf(ran_number.nextInt(100)));
			document.put("firstname", user.getFirstName());
			document.put("lastname", user.getLastName());
			document.put("middlename", user.getMiddleName());

			// Save a new user to the mongo collection.
			collection.insert(document);
		} catch (Exception ex) {
			System.out.println("An error occurred while saving a new user to the mongo database" + ex);
		}

	}

	// Fetching a single user details from the mongo database.(using first name)
	public User getUser(String firstname) {
		User user = new User();
		// Fetching the record object from the mongo database.
		DBObject where_query = new BasicDBObject();
		where_query.put("firstname", firstname);
		
		DBObject dbo = collection.findOne(where_query);
		user.setId(dbo.get("id").toString());
		user.setFirstName(dbo.get("firstname").toString());
		user.setLastName(dbo.get("lastname").toString());
		user.setMiddleName(dbo.get("middlename").toString());
		System.out.println(user.getFirstName());
		return user;

	}

	// Fetching a single user details from the mongo database.(using id)
	public User findUserId(String id) {
		
		User user = new User();

		// Fetching the record object from the mongo database.
		DBObject where_query = new BasicDBObject();
		where_query.put("id", id);
		
		DBObject dbo = collection.findOne(where_query);
		user.setId(dbo.get("id").toString());
		user.setFirstName(dbo.get("firstname").toString());
		user.setLastName(dbo.get("lastname").toString());
		user.setMiddleName(dbo.get("middlename").toString());
		System.out.println(user.getFirstName());
		// Return user object.
		return user;
	}

	private DBObject getDBObject(String id) {
		// Fetching the record object from the mongo database.
		DBObject where_query = new BasicDBObject();

		// Put the selected user_id to search.
		where_query.put("id", id);
		return collection.findOne(where_query);
	}

	// Update the selected user in the mongo database.
	public void updateUser(User user) {

		try {
			// Fetching the user details.
			BasicDBObject existing = (BasicDBObject) getDBObject(user.getId());
			System.out.println("Data to update" + existing.toString());

			// Create a new object and assign the updated details.
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("id", user.getId());
			newDocument.put("firstname", user.getFirstName());
			newDocument.put("lastname", user.getLastName());
			newDocument.put("middlename", user.getMiddleName());

			// Update the existing user to the mongo database.
			collection.update(existing, newDocument);

		} catch (Exception e) {
			System.out.println("An error has occurred while updating an existing user to the mongo database" + e);

		}

	}

	public void deleteUser(String firstname) {

		try {
			// Fetching the required user from the mongo database.
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("firstname", firstname);

			// Deleting the selected user from the mongo database.
			collection.remove(searchQuery);
		} catch (Exception e) {
			System.out.println("An error occurred while deleting an existing user from the mongo database");
			e.printStackTrace();
		}

	}

	public List getAll() {
		List user_list = new ArrayList();

		// Fetching cursor object for iterating on the database records.
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
			User user = new User();
			user.setId(dbObject.get("id").toString());
			user.setFirstName(dbObject.get("firstname").toString());
			user.setLastName(dbObject.get("lastname").toString());
			user.setMiddleName(dbObject.get("middlename").toString());

			// Adding the user details to the list.
			user_list.add(user);

		}
		System.out.println("Total records fetched from the mongo database are=" + user_list.size());
		return user_list;

	}
}
