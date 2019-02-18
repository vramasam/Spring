package com.ps.springmvc.psbankApp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ps.springmvc.psbankApp.dao.AccountDAO;
import com.ps.springmvc.psbankApp.model.Account;

/**
 * Class the acts(implementation) as intermediate between DAO and the controller, 
 * if requires need additional calls and make the own model
 * @author vivekramasamy
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDAO accountDAO;

	@Override
	@Transactional
	public boolean saveAccount(Account account) {
		return accountDAO.saveAccount(account);
	}

	@Override
	@Transactional
	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	@Override
	@Transactional
	public Account getAccount(Integer accountNo) {
		// TODO Auto-generated method stub
		return accountDAO.getAccount(accountNo);
	}

	@Override
	@Transactional
	public boolean deleteAccount(Integer accountNo) {
		return accountDAO.deleteAccount(accountNo);
	}

}
