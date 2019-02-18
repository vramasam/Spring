package com.ps.springmvc.psbankApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ps.springmvc.psbankApp.dao.AccountDAO;
import com.ps.springmvc.psbankApp.model.Account;

/**
 * Class that helps in logging exception before the method executes, and throw the corresponding exception through messgae
 * @author vivekramasamy
 *
 */
@Aspect
@Component
public class AccountAspect {
	
	// This advice will be executed before the save account of AccountDAOImpl
	@Before("execution(* com.ps.springmvc.psbankApp.dao.AccountDAOImpl.saveAccount(..))")
	private void validateAccount(JoinPoint joinPoint) {
		Object []args = joinPoint.getArgs();
		Account account =  (Account)args[0];
		AccountDAO accountDAO = (AccountDAO) joinPoint.getTarget();
		int accountNo = account.getAccountNumber();	
		if(accountDAO.getAccount(accountNo) != null) {
			throw new RuntimeException("Account with Account Number " + accountNo + " is already exist");
		}
	}

}
