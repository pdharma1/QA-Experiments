package deema.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/*")
public class HelloController {

	private Logger logger = Logger.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printHello(ModelAndView mv, HttpServletRequest request) {

		String uri = request.getServletPath();
		switch (uri) {
			case "/hello": {
				logger.info("Servlet Context Path: " + uri);
				mv.addObject("message", "Hello");
				mv.setViewName("hello");
				break;
			}
			case "/polo": {
				logger.info("Servlet Context Path: " + uri);
				mv.addObject("message", "Polo");
				mv.setViewName("polo");
				break;
			}
			case "/sample": {
				logger.info("Servlet Context Path: " + uri);
				mv.addObject("message", "Sample");
				mv.setViewName("sample");
				break;
			}
			case "/header": {
				logger.info("Servlet Context Path: " + uri);
				mv.addObject("message", "Header");
				mv.setViewName("header");
				break;
			}
			default: {
				logger.info("Servlet Context Path: " + uri);
				mv.addObject("message", "Default Hello");
				mv.setViewName("hello");
				break;
			}
		}

		return mv;
	}
}
