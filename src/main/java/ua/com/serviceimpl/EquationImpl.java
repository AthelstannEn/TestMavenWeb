package ua.com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.bean.CoefficientBean;
import ua.com.entity.*;
import ua.com.manager.*;
import ua.com.service.IEquationManager;
import ua.com.service.IEquationService;

@Component
public class EquationImpl implements IEquationService{

	@Autowired
	private IEquationManager equationManager;
	
	public void create(CoefficientBean coefficientBean) {
		equationManager.create(coefficientBean);
	}

	public Equst read(Long id) {
		return equationManager.read(id);
	}

}
