package com.engin.fakau.ejbimplementation;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.engin.fakau.domaine.Account;
import com.engin.fakau.local.IAccountLocal;
import com.engin.fakau.remote.IAccountRemote;

@Stateless(name="FTM")
public class AccountImplement implements IAccountLocal, IAccountRemote {

	@PersistenceContext(unitName = "banc-management")
	private EntityManager entityManager;
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account UpdateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountBySecurityCode(Long securityCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account deposit(Long securityCode, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account withdrawal(Long securityCode, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account transfer(Long fromSecurityCode, BigDecimal fromAmount, Long toSecurityCode, BigDecimal toAmount) {
		// TODO Auto-generated method stub
		return null;
	}

}
