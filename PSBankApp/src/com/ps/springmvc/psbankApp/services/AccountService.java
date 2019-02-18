package com.ps.springmvc.psbankApp.services;

import java.util.List;

import com.ps.springmvc.psbankApp.model.Account;

/**
 * Class the acts(defines) as intermediate between DAO and the controller, 
 * if requires need additional calls and make the own model
 * @author vivekramasamy
 *
 */
public interface AccountService {
	public boolean saveAccount(Account account);
	public List<Account> getAccounts();
	public Account getAccount(Integer accountNo);
	public boolean deleteAccount(Integer accountNo);
}
