package dao;

import java.util.List;

import com.sun.istack.Nullable;

/*
 * Cette classe est une classe template permettant la création des autres classes DAO
 */
public interface DAO<T> {
	
	/**
	 * Find the object in the database from its id
	 * @param id id of the element in the databse
	 * @return object corresponding to the database, null if not found or error
	 */
	@Nullable T find(int id) throws Exception;
	
	/**
	 * Get all the objects corresponding to all the database
	 * @return List of all the objects in the database, null if error
	 */
	List<T> findAll() throws Exception;
	
	/**
	 * Create the element in the database corresponding to the object
	 * @param obj object to create
	 */
	void create(T obj) throws Exception;

	/**
	 * Update the element in the database corresponding to the object
	 * @param obj object to update
	 */
	void update(T obj) throws Exception;
	
	/**
	 * Delete element in the database corresponding to the object
	 * @param obj object to delete
	 */
	void delete(T obj) throws Exception;
}
