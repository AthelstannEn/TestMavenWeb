package ua.com.service;

import ua.com.bean.CoefficientBean;
import ua.com.entity.Equst;



public interface IEquationManager {

	void create(CoefficientBean coefficientBean);
	Equst read(Long id);
	 
}