package ua.com.dao;

import java.util.List;

import ua.com.entity.Equst;

public interface IEquationDao {
	
	void create(Equst equations);
	Equst read(Long id);
	List<Equst> read(); 
	void update(Equst equations);
	void delete(Equst equations);

}