package deema.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/404")
public class ErrorController {

	private Logger logger = Logger.getLogger(ErrorController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printError(ModelAndView mv, HttpServletRequest request) {

		logger.info("Servlet Servlet Path: " + request.getServletPath());
		mv.addObject("message", "Aww Snap..!!");
		mv.setViewName("404");
		return mv;
	}
}
