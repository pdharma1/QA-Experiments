package com.et.beans;
import java.util.Date;

/**
 * Name: Pradeep Dharmavarapu
 * Class section: 605-782: Web Application Development with JSP and Servlets.
 * Thu 0430pm.
 * Team: Pradeep Dharmavarapu
 * Date: Apr 6, 2014 - 11:46:15 AM
 * Description: 605.782.
 */

public class PaymentSource
{
	private String paymentSourceId = "";
	private Double totalCredit = 0.0;
	private Double availableCredit = 0.0;
	private Date expDate;
	private String description = "";

	public PaymentSource()
	{
		super();
	}

	/**
	 * @return the paymentSourceId
	 */
	public String getPaymentSourceId()
	{
		return paymentSourceId;
	}

	/**
	 * @param paymentSourceId
	 *            the paymentSourceId to set
	 */
	public void setPaymentSourceId(String paymentSourceId)
	{
		this.paymentSourceId = paymentSourceId;
	}

	/**
	 * @return the totalCredit
	 */
	public double getTotalCredit()
	{
		return totalCredit;
	}

	/**
	 * @param totalCredit
	 *            the totalCredit to set
	 */
	public void setTotalCredit(double totalCredit)
	{
		this.totalCredit = totalCredit;
	}

	/**
	 * @return the availableCredit
	 */
	public double getAvailableCredit()
	{
		return availableCredit;
	}

	/**
	 * @param availableCredit
	 *            the availableCredit to set
	 */
	public void setAvailableCredit(double availableCredit)
	{
		this.availableCredit = availableCredit;
	}

	/**
	 * @return the expDate
	 */
	public Date getExpDate()
	{
		return expDate;
	}

	/**
	 * @param expDate
	 *            the expDate to set
	 */
	public void setExpDate(Date expDate)
	{
		this.expDate = expDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

}
