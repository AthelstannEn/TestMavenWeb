package ua.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ua.com.entity.Equst;

@Repository
public class EquationDaoImpl implements IEquationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Equst equations) {
		entityManager.persist(equations);
	}

	@SuppressWarnings("unchecked")
	public List<Equst> read() {
		List<Equst> equations = entityManager.createQuery("from Equst")
				.getResultList();
		return equations;
	}

	public void update(Equst equations) {
	

	}

	public void delete(Equst equations) {

	}

	public Equst read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}