package ua.com.manager;

import java.util.Date;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.controlleri.user.CoefValid;
import ua.com.dao.IEquationDao;
import ua.com.entity.Equst;
import ua.com.service.IEquationManager;
import ua.com.service.Rule;
import ua.com.serviceimpl.GeneralRule;



@Service
@Transactional
public class EquationManagerImpl implements IEquationManager {
	
	@Autowired
	private IEquationDao euqationDao;
	@Override
	public void create(CoefValid coefValid) {
		 Equst equations = parseCoefficientBeanToEquation(findResult(coefValid));
		 euqationDao.create(equations);
	}

	@Override
	public Equst read(Long id) {
		return euqationDao.read(id);
	}
	private CoefValid findResult(CoefValid coefValid){
		Rule rule = new GeneralRule();
		return rule.getResult(coefValid);
	}
	private Equst parseCoefficientBeanToEquation(CoefValid coefValid){
		Equst equations = new Equst();
		equations.setLeadinCoefficient(Double.parseDouble(coefValid.getLeadingCoefficien()));
		equations.setSecondCoefficient(Double.parseDouble(coefValid.getSecondCoefficien()));
		equations.setFreeMember(Double.parseDouble(coefValid.getFreeMember()));
		equations.setFirstVariable(coefValid.getFirstVariable());
		equations.setSecondVariable(coefValid.getSecondVariable());
		equations.setCreatedDate(new Date());
		return equations;
	}
}