package ua.com.serviceimpl;



import ua.com.controlleri.user.CoefValid;
import ua.com.exception.Nrgrxcrption;
import ua.com.service.Rule;
public class GeneralRule implements Rule {
	
	
	private double leadingCoefficient, secondCoefficient, freeMember;

	public CoefValid getResult(CoefValid coefValid) {
		parseStringToDouble(coefValid);
		coefValid.setDiscriminant(findDiscriminant());
		findResult(coefValid);
		return coefValid;
	}

	private void parseStringToDouble(CoefValid coefValid) {
		leadingCoefficient = Double.parseDouble(coefValid.getLeadingCoefficien());
		secondCoefficient = Double.parseDouble(coefValid.getSecondCoefficien());
		freeMember = Double.parseDouble(coefValid.getFreeMember());
	}

	private Double findDiscriminant() {
		return secondCoefficient * secondCoefficient - 4 * leadingCoefficient * freeMember;
	}

	private void findResult(CoefValid coefValid) {
		if (coefValid.getDiscriminant() > 0)
			isPositive(coefValid);
		else if (coefValid.getDiscriminant() == 0)
			isZero(coefValid);
		//else
	//		throw new NegativeException();
	}

	private void isPositive(CoefValid coefValid) {
		double firstVariable = (-secondCoefficient + Math.sqrt(coefValid.getDiscriminant())) / 2
				* leadingCoefficient;
		double secondVariable = (-secondCoefficient - Math.sqrt(coefValid.getDiscriminant())) / 2
				* leadingCoefficient;
		coefValid.setFirstVariable(firstVariable);
		coefValid.setSecondVariable(secondVariable);
	}

	private void isZero(CoefValid coefValid) {
		double variable = -secondCoefficient / 2 * leadingCoefficient;
		coefValid.setFirstVariable(variable);
		coefValid.setSecondVariable(variable);
	}

}