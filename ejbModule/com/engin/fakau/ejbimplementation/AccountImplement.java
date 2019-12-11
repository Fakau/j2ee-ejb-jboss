package com.engin.fakau.ejbimplementation;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.engin.fakau.domaine.Account;
import com.engin.fakau.local.IAccountLocal;
import com.engin.fakau.remote.IAccountRemote;

@Stateless(name="FTM")
public class AccountImplement implements IAccountLocal, IAccountRemote {

	@PersistenceContext(unitName = "banc-management")
	private EntityManager entityManager;
	@Override
	public Account createAccount(Account account) {
		entityManager.persist(account);
		return account;
	}

	@Override
	public Account UpdateAccount(Account account) {
		entityManager.merge(account);
		return account;
	}

	@Override
	public Account getAccountBySecurityCode(Long securityCode) {
		return entityManager.find(Account.class, securityCode);
	}

	@Override
	public Account deposit(Long securityCode, BigDecimal amount) {
		Account a = getAccountBySecurityCode(securityCode);
		if(a==null) {
			throw new RuntimeException("account does not exist");
		}
		a.setAmount(a.getAmount().add(amount));
		return UpdateAccount(a);
	}

	@Override
	public Account withdrawal(Long securityCode, BigDecimal amount) {
		Account a = getAccountBySecurityCode(securityCode);
		if(a==null) {
			throw new RuntimeException("account does not exist");
		}
		a.setAmount(a.getAmount().subtract(amount));
		/*
		 * if() {
		 * amount<0
		 * }
		 */
		return UpdateAccount(a);
	}

	@Override
	public void transfer(Long fromSecurityCode, BigDecimal amount, Long toSecurityCode) {
		withdrawal(fromSecurityCode, amount);
		deposit(toSecurityCode, amount);
	}

	@Override
	public List<Account> getAll() {
		Query q=entityManager.createQuery("select c from Account c");
		return q.getResultList();
	}

}
