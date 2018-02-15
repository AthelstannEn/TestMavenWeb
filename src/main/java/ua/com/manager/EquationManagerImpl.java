package ua.com.manager;

import java.util.Date;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.bean.CoefficientBean;
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
	public void create(CoefficientBean coefficientBean) {
		 Equst equations = parseCoefficientBeanToEquation(findResult(coefficientBean));
		 euqationDao.create(equations);
	}

	@Override
	public Equst read(Long id) {
		return euqationDao.read(id);
	}
	private CoefficientBean findResult(CoefficientBean coefficientBean){
		Rule rule = new GeneralRule();
		return rule.getResult(coefficientBean);
	}
	private Equst parseCoefficientBeanToEquation(CoefficientBean coefficientBean){
		Equst equations = new Equst();
		equations.setLeadinCoefficient(Double.parseDouble(coefficientBean.getLeadingCoefficien()));
		equations.setSecondCoefficient(Double.parseDouble(coefficientBean.getSecondCoefficien()));
		equations.setFreeMember(Double.parseDouble(coefficientBean.getFreeMember()));
		equations.setFirstVariable(coefficientBean.getFirstVariable());
		equations.setSecondVariable(coefficientBean.getSecondVariable());
		equations.setCreatedDate(new Date());
		return equations;
	}
}