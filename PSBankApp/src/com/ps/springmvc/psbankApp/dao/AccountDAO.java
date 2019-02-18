package com.ps.springmvc.psbankApp.dao;

import java.util.List;

import com.ps.springmvc.psbankApp.model.Account;

/**
 * Class that gives the definition for DAO
 * @author vivekramasamy
 *
 */
public interface AccountDAO {
	public boolean saveAccount(Account account);
	
	public List<Account> getAccounts();
	
	public Account getAccount(Integer accountNo);
	
	public boolean deleteAccount(Integer accountNo);
}
