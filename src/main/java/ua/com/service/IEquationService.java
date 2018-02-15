package ua.com.service;


import ua.com.bean.CoefficientBean;
import ua.com.entity.Equst;;



public interface IEquationService {


	void create(CoefficientBean coefficientBean);
	Equst read(Long id);

	
	
}
