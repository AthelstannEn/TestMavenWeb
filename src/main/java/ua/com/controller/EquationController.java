package ua.com.controller;

import javax.servlet.http.HttpSession;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.controlleri.user.CoefValid;
import ua.com.exception.Nrgrxcrption;
import ua.com.service.IEquationService;

@Controller
public class EquationController {

	@Autowired//(required=false)
	private IEquationService equationFacade;

	@RequestMapping(value = "/resolve", method = RequestMethod.GET)
	public String resolveQuadraticEquation(ModelMap map, HttpSession session) {
		CoefValid coefValid = new CoefValid();
		map.addAttribute("coefficientBean", coefValid);
		return "fullpage";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String resultQuadraticEquation(@ModelAttribute("coefficientBean") CoefValid coefValid,
			HttpSession session) {
		String resultPage = "redirect:/show.html";
		
			equationFacade.create(coefValid);
			session.setAttribute("coefficientBean", coefValid);
		
			session.setAttribute("error", "Wrong Number Format: " );
			resultPage = "redirect:/error.html";
	
			session.setAttribute("error","Actual Answer: First Variable - > "+coefValid.getFirstVariable()+" Second Variable - > "+coefValid.getSecondVariable() );
			resultPage = "redirect:/error.html";
		
		return resultPage;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(ModelMap map, HttpSession session) {
		return "ERrorpage";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showResult(ModelMap model, HttpSession session) {
		CoefValid coefValid = (CoefValid) session.getAttribute("coefficientBean");
		model.addAttribute(coefValid);
		return "REsultpage";
	}
}