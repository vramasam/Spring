package com.ps.springmvc.psbankApp.model;


import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.ps.springmvc.psbankApp.validation.PSCode;

/**
 * Class the defines the model, where the contoller fills the data and view gets the data
 * @author vivekramasamy
 *
 */
public class Account {

	// Getting the error message from properties file, it will help in internationalization
	@NotNull
	private Integer accountNumber;
	
	@NotNull
	@Size(min=2, max=50, message="Inavlid length for Account Holder Name")
	@Pattern(regexp="[A-Za-z(\\s]+", message="Invalid Account Holder Name")
	private String accountName;
	
	@NotNull(message="Balance Amount is required")
	@Min(value=5000, message="Minimum balance must not be less than 5000")
	private Integer balance;
	
	@NotNull(message="Account Type cant be null")
	private String accountType;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull(message="Date of birth cant be null")
	@Past(message="Account cant be created for the account not born")
	private Date dateOfBirth = new Date();
	
	@NotNull(message="PS code is required")
	@PSCode(value="PSUSA", message="PS Code should start with PSUSA")
	private String psCode;
	
	public Account() {}
	
	public Account(Integer accountNumber, String accountName, Integer balance) {}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}
	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
