package ua.com.controller;

import javax.servlet.http.HttpSession;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.bean.CoefficientBean;
import ua.com.exception.NegativeException;
import ua.com.service.IEquationService;

@Controller
public class EquationController {

	@Autowired//(required=false)
	private IEquationService equationFacade;

	@RequestMapping(value = "/resolve", method = RequestMethod.GET)
	public String resolveQuadraticEquation(ModelMap map, HttpSession session) {
		CoefficientBean coefficientBean = new CoefficientBean();
		map.addAttribute("coefficientBean", coefficientBean);
		return "resolveQuadraticEquation";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String resultQuadraticEquation(@ModelAttribute("coefficientBean") CoefficientBean coefficientBean,
			HttpSession session) {
		String resultPage = "redirect:/show.html";
		
			equationFacade.create(coefficientBean);
			session.setAttribute("coefficientBean", coefficientBean);
		
			session.setAttribute("error", "Wrong Number Format: " );
			resultPage = "redirect:/error.html";
	
			session.setAttribute("error","Actual Answer: First Variable - > "+coefficientBean.getFirstVariable()+" Second Variable - > "+coefficientBean.getSecondVariable() );
			resultPage = "redirect:/error.html";
		
		return resultPage;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(ModelMap map, HttpSession session) {
		return "errorPage";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showResult(ModelMap model, HttpSession session) {
		CoefficientBean coefficientBean = (CoefficientBean) session.getAttribute("coefficientBean");
		model.addAttribute(coefficientBean);
		return "resultPage";
	}
}