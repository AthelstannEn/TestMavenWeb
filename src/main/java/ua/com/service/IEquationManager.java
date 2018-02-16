package ua.com.service;

import ua.com.controlleri.user.CoefValid;
import ua.com.entity.Equst;



public interface IEquationManager {

	void create(CoefValid coefValid);
	Equst read(Long id);
	 
}