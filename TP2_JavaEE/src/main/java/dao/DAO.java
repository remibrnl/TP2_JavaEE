package dao;

import java.sql.SQLException;

public interface DAO<T> {
	
	/**
	 * Find the object in the database from its id
	 * @param id id of the element in the databse
	 * @return object corresponding to the database, null if not found or error
	 */
	T find(Long id);
	
	/**
	 * Create the element in the database corresponding to the object
	 * @param obj object to create
	 */
	void create(T obj);

	/**
	 * Update the element in the database corresponding to the object
	 * @param obj object to update
	 */
	void update(T obj);
	
	/**
	 * Delete element in the database corresponding to the object
	 * @param obj object to delete
	 */
	void delete(T obj);
}
