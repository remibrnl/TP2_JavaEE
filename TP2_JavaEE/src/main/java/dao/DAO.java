package dao;

import java.sql.SQLException;

public interface DAO<T> {
	
	T find(Long id) throws SQLException;
	
	void create(T obj) throws SQLException;

	void update(T obj) throws SQLException;
	
	void delete(T obj) throws SQLException;
}
