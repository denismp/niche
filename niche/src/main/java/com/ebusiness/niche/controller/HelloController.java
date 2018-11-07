/**
 * 
 */
package com.ebusiness.niche.controller;

/**
 * @author denisputnam
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

@RestController
public class HelloController extends ParameterizableViewController {
	
	@RequestMapping("/hello")
	public String hello(@RequestParam String name){
		return "Hello "+name;
	}

	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        final ModelAndView modelAndView = super.handleRequestInternal(request, response);

        final String myName = request.getParameter("name");
        		
        modelAndView.addObject("name", myName);

        return modelAndView;		
		
	}

}
