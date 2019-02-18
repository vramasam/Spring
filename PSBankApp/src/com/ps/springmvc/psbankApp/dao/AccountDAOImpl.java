package com.ps.springmvc.psbankApp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ps.springmvc.psbankApp.entity.AccountEntity;
import com.ps.springmvc.psbankApp.model.Account;

/**
 * Class that gives the implementation for DAO(Database intration class)
 * @author vivekramasamy
 *
 */
@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean saveAccount(Account account) {
		boolean saveFlag = true;
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccNo(account.getAccountNumber());
		accountEntity.setAccHolderName(account.getAccountName());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setAccountType(account.getAccountType());
		accountEntity.setDateOfBirth(account.getDateOfBirth());
		accountEntity.setPsCode(account.getPsCode());
		try {
			Session currentSession =  sessionFactory.getCurrentSession();
//			currentSession.save(accountEntity);
			currentSession.saveOrUpdate(accountEntity);
		} catch(Exception ex) {
			ex.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

	@Override
	public List<Account> getAccounts() {
		List<Account> list = new ArrayList<Account>();
		try {
			Session currentSession =  sessionFactory.getCurrentSession();
			Query<AccountEntity> query = currentSession.createQuery("From AccountEntity", AccountEntity.class);
			List<AccountEntity> accounts = query.getResultList();
			for(AccountEntity accountEntity:accounts) {
				Account accountData = new Account();
				accountData.setAccountNumber(accountEntity.getAccNo());
				accountData.setAccountName(accountEntity.getAccHolderName());
				accountData.setBalance(accountEntity.getBalance());
				accountData.setAccountType(accountEntity.getAccountType());
				accountData.setDateOfBirth(accountEntity.getDateOfBirth());
				accountData.setPsCode(accountEntity.getPsCode());
				list.add(accountData);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public Account getAccount(Integer accountNo) {
		Account accountData = new Account();
		try {
			Session currentSession =  sessionFactory.getCurrentSession();
			// load method return the proxy without hitting the database, where in 
			// hibernate proxy is an object with the given identifier value, its like a temporary object
			// if there is no value exist for the query, it will give exception
			// if we not sure about the data, instead of using load we can use get()
			// but it will hit the database to retrieve the data
//			AccountEntity accountEntity = (AccountEntity) currentSession.load(AccountEntity.class, accountNo);
			AccountEntity accountEntity = (AccountEntity) currentSession.get(AccountEntity.class, accountNo);
			if(accountEntity == null) {
				return null;
			}
			accountData.setAccountNumber(accountEntity.getAccNo());
			accountData.setAccountName(accountEntity.getAccHolderName());
			accountData.setBalance(accountEntity.getBalance());
			accountData.setAccountType(accountEntity.getAccountType());
			accountData.setDateOfBirth(accountEntity.getDateOfBirth());
			accountData.setPsCode(accountEntity.getPsCode());
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return accountData;
	}

	@Override
	public boolean deleteAccount(Integer accountNo) {
		boolean deleteFlag = true;
		try {
			Session currentSession =  sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity) currentSession.load(AccountEntity.class, accountNo);
			currentSession.delete(accountEntity);
		} catch(Exception ex) {
			deleteFlag = false;
			ex.printStackTrace();
		}
		return deleteFlag;
	}
}
