package controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloReaderController {

	private Logger logger = Logger.getLogger(HelloReaderController.class);

	@RequestMapping(value = "/")
	public ModelAndView sayHello(ModelAndView mv, HttpServletRequest request) {

		mv.addObject("mesage", "Hello Reader!");
		mv.setViewName("helloReader");

		String uri = request.getContextPath();
		logger.debug("Context: " + uri);
		return mv;
	}
}
