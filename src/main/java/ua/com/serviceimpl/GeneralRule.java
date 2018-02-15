package ua.com.serviceimpl;



import ua.com.bean.CoefficientBean;
import ua.com.exception.NegativeException;
import ua.com.service.Rule;
public class GeneralRule implements Rule {
	
	
	private double leadingCoefficient, secondCoefficient, freeMember;

	public CoefficientBean getResult(CoefficientBean coefficientBean) {
		parseStringToDouble(coefficientBean);
		coefficientBean.setDiscriminant(findDiscriminant());
		findResult(coefficientBean);
		return coefficientBean;
	}

	private void parseStringToDouble(CoefficientBean coefficientBean) {
		leadingCoefficient = Double.parseDouble(coefficientBean.getLeadingCoefficien());
		secondCoefficient = Double.parseDouble(coefficientBean.getSecondCoefficien());
		freeMember = Double.parseDouble(coefficientBean.getFreeMember());
	}

	private Double findDiscriminant() {
		return secondCoefficient * secondCoefficient - 4 * leadingCoefficient * freeMember;
	}

	private void findResult(CoefficientBean coefficientBean) {
		if (coefficientBean.getDiscriminant() > 0)
			isPositive(coefficientBean);
		else if (coefficientBean.getDiscriminant() == 0)
			isZero(coefficientBean);
		//else
	//		throw new NegativeException();
	}

	private void isPositive(CoefficientBean coefficientBean) {
		double firstVariable = (-secondCoefficient + Math.sqrt(coefficientBean.getDiscriminant())) / 2
				* leadingCoefficient;
		double secondVariable = (-secondCoefficient - Math.sqrt(coefficientBean.getDiscriminant())) / 2
				* leadingCoefficient;
		coefficientBean.setFirstVariable(firstVariable);
		coefficientBean.setSecondVariable(secondVariable);
	}

	private void isZero(CoefficientBean coefficientBean) {
		double variable = -secondCoefficient / 2 * leadingCoefficient;
		coefficientBean.setFirstVariable(variable);
		coefficientBean.setSecondVariable(variable);
	}

}