package com.ps.springmvc.psbankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class that explains about the request mapping, request param and the path variable
 * Request mapping for class defines the path for test
 * @author vivekramasamy
 *
 */
@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping(value= {"", "/index", "index*", "view/*"})
	public String testIndex() {
		return "testIndex";
	}
	
	/**
	 * Method with params
	 * @param userName : url must have userName data
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value="name")
	public String methodWithParams(@RequestParam String userName, Model model) {
		System.out.println(userName);
		model.addAttribute("userName", userName);
		return "testIndex";
	}*/
	
	/**
	 * Method with params
	 * @param userName : url userName data is optional and also given with default value
	 * @param model
	 * @return
	 */
	@RequestMapping(value="name")
	public String methodWithParams(@RequestParam(value="userName", required=false, defaultValue="Guest") String userName, Model model) {
		System.out.println(userName);
		model.addAttribute("userName", userName);
		return "testIndex";
	}
	
	/**
	 * Method to accept dynamic values
	 * @param userName : url userName data is optional and also given with default value
	 * @param model
	 * @return
	 */
	@RequestMapping(value="dynamic/{category:[a-z]+}/{userName}")
	public String dynamicUrl(@PathVariable(value="userName") String userName, Model model) {
		System.out.println(userName);
		model.addAttribute("userName", userName);
		return "testIndex";
	}
	
	/**
	 * fall back page for test requestparams
	 * @return
	 */
	@RequestMapping("*")
	public String fallBackPage() {
		return "fileNotFound";
	}
	
	
}
