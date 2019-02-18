package com.ps.springmvc.psbankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ps.springmvc.psbankApp.model.Account;
import com.ps.springmvc.psbankApp.services.AccountService;

@RestController
@RequestMapping(value="/account")
public class AccountRestContoller {
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * Method that give json response body @ResponseBody not required because class having @RestController
	 * @param accountNo
	 * @return
	 */
//	@ResponseBody
	/*@RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Account getAccount(@PathVariable("id") Integer accountNo) {
		Account account = accountService.getAccount(accountNo);
		return account;
	}*/
	
	/*@RequestMapping(value="/{id}", method= RequestMethod.POST)
    public Account getAccount(Integer accountNo) {
		Account account = accountService.getAccount(accountNo);
		return account;
	}*/
	
	// http://localhost:8080/PSBankApp/account?accountNo=1234
	/*@RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Account> postAccount(Integer accountNoValue) {
		Account account = accountService.getAccount(accountNoValue);
		if(accountNoValue == null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}*/
	
	@RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Account> postAccountAccount(@RequestBody Account accountNumber) {
		Account account = accountService.getAccount(accountNumber.getAccountNumber());
		if(account == null)
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

}
