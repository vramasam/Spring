package com.ps.springmvc.psbankApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps.springmvc.psbankApp.model.Account;
import com.ps.springmvc.psbankApp.services.AccountService;


/**
 * Class that controls to show the view jsp, Controller is the subclass of component
 * @author vivekramasamy
 *
 */
@Controller
public class AccountController {
	
//	@Autowired
//	AccountDAO accountService;
	
	@Autowired
	AccountService accountService;
	
	/**
	 * This method will bind the data in the JSP file, 
	 * Example in this method, it wont allow the empty space in the JSP
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/")
	public String showHomePage() {
		return "index_check";
	}
	
	/*@RequestMapping("/new") 
	public String newAccount() {
		return "newAccount";
	}*/
	
	// Since the newAccount.jsp changed with Spring tag and it expects model attribute,
	// create it form here
	@RequestMapping("/new") 
	public String newAccount(Model model) {
		model.addAttribute("account_data", new Account());
		return "account-form";
//		return "newAccount";
	}
	
	@RequestMapping("/showAccount") 
	public String showAccount() {
		return "showAccount";
	}
	
	/**
	 * Getting data from Form using HttpServletRequest
	 */
	/*@RequestMapping(value="/saveAccount", method= RequestMethod.POST) 
	public String saveAccount(Model model, HttpServletRequest httpRequest) {
		String accountNo = httpRequest.getParameter("accountNumber");
		String accountName = httpRequest.getParameter("accountName");
		String accountBalance = httpRequest.getParameter("balance");
		
		// setting the data separately, getting through model attribute
		model.addAttribute("accountNo", accountNo);
		model.addAttribute("accountName", accountName);
		model.addAttribute("balance", accountBalance);
		
		// setting the data in the object
//		Account account = new Account();
//		account.setAccountName(accountName);
//		account.setAccountNumber(Integer.parseInt(accountNo));
//		account.setBalance(Integer.parseInt(accountBalance));
//		
//		model.addAttribute("account", account);
		return "showAccount";
	}*/
	
	/**
	 * Getting data from Form using RequestParam work
	 */
	/*@RequestMapping(value="/saveAccount", method= RequestMethod.POST) 
	public String saveAccount(Model model, @RequestParam("accountNumber") String accountNo,
			@RequestParam("accountName") String accountName, @RequestParam("balance") String accountBalance) {
		
		Account account = new Account();
		account.setAccountName(accountName);
		account.setAccountNumber(Integer.parseInt(accountNo));
		account.setBalance(Integer.parseInt(accountBalance));
		model.addAttribute("account", account);
		return "showAccount";
	}*/
	
	/**
	 * Getting data(Object) from Form because spring tag fills the data object directly
	 * @param model
	 * @param account - given by spring tag
	 * @return
	 */
	/*@RequestMapping(value="/saveAccount", method= RequestMethod.POST) 
	public String saveAccount(Model model, Account account) {
//		model.addAttribute(account);
		model.addAttribute("account_data", account);
		return "showAccount";
	}*/
	
	/**
	 * To handle validation request parameter should start with Valid, 
	 * it is mandatory to have result immediate after Model Attribute
	 * @param account
	 * @param result
	 * @return
	 */
	/*@RequestMapping(value="/saveAccount", method= RequestMethod.POST) 
	public String saveAccount(@Valid @ModelAttribute("account_data") Account accountInfo, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "newAccount";
		}	else {
			
			return "showAccount";
		}
	}*/
	
	/**
	 * To handle DAO
	 * it is mandatory to have result immediate after Model Attribute
	 * @param account
	 * @param result
	 * @return
	 */
	/*@RequestMapping(value="/saveAccount", method= RequestMethod.POST) 
	public String saveAccount(@Valid @ModelAttribute("account_data") Account accountInfo, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "account-form";
		}	else {
			accountService.saveAccount(accountInfo);
			return "redirect:/list";
		}
	}*/
	
	
	/**
	 * Method to check with AOP exception (Check the AccountAspect file)
	 * @param accountInfo
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/saveAccount", method= RequestMethod.POST) 
	public String saveAccount(@Valid @ModelAttribute("account_data") Account accountInfo, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "account-form";
		}	else {
			String message = "";
			boolean flag = true;
			try {
				 flag = accountService.saveAccount(accountInfo);
			} catch(Exception ex) {
				message = ex.getMessage();
				flag = false;
			}
			
			if(!flag) {
				model.addAttribute("message", message);
				return "account-form";
			}
//			model.addAttribute("account", accountInfo);
			return "redirect:/list";
		}
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String findAccount() {
		return "findAccount";
	}
	
	@GetMapping("/list")
	public String listAccounts(Model model) {
		List<Account> accounts = accountService.getAccounts();
		model.addAttribute("accounts", accounts);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name= auth.getName();
		model.addAttribute("username", name);
		return "listAccount";
	}
	
	@GetMapping("/edit")
	public String updateAccount(@RequestParam("accountNumber") int accountNo, Model model) {
		Account account = accountService.getAccount(new Integer(accountNo));
		model.addAttribute("account_data", account);
		return "account-form";
	}
	
	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("accountNumber") int accountNo, Model model) {
		accountService.deleteAccount(new Integer(accountNo));
		return "redirect:/list";
	}
	
	
}
