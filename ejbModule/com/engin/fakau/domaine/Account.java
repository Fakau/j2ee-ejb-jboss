package com.engin.fakau.domaine;

import java.io.Serializable;
import java.lang.Long;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity

public class Account implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long securityCode;
	private BigDecimal amount;
	private Date createdDate;
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}   
	public Long getSecurityCode() {
		return this.securityCode;
	}

	public void setSecurityCode(Long securityCode) {
		this.securityCode = securityCode;
	}   
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}   
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Account [securityCode=" + securityCode + ", amount=" + amount + ", createdDate=" + createdDate + "]";
	}
	
   
}
