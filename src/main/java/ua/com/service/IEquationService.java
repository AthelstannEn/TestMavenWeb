package ua.com.service;


import ua.com.controlleri.user.CoefValid;
import ua.com.entity.Equst;;



public interface IEquationService {


	void create(CoefValid coefValid);
	Equst read(Long id);

	
	
}
