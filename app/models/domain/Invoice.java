package models.domain;
import java.util.Date;

import javax.persistence.*;
import play.data.validation.Constraints;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "invoices")
public class Invoice extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "customers", referencedColumnName = "id")
	protected Integer id_customer;
	
	protected Integer id_plan;
	
	@Column(nullable = false)
	protected Double total_invoice;
	
	@Column(nullable = false)
	protected Integer paymentAttempts_invoice;
	
	@Column(nullable = false)
	protected Integer status_invoice; // 0 : Cobrar - 1: Cobrada - 2: procesando
	
	@Column(nullable = false)
	protected Double balance_invoice;
	
	@Column(nullable = false)
	protected Date dateCreated_invoice;
	
	@Column(nullable = false)
	protected Date lastUpdated_invoice;
	
	protected Double feeRate_partner;
	
	protected Double taxtRate_invoice;

	/**
	 * @return the id_customer
	 */
	public Integer getId_customer() {
		return id_customer;
	}

	/**
	 * @param id_customer the id_customer to set
	 */
	public void setId_customer(Integer id_customer) {
		this.id_customer = id_customer;
	}

	/**
	 * @return the id_plan
	 */
	public Integer getId_plan() {
		return id_plan;
	}

	/**
	 * @param id_plan the id_plan to set
	 */
	public void setId_plan(Integer id_plan) {
		this.id_plan = id_plan;
	}

	/**
	 * @return the total_invoice
	 */
	public Double getTotal_invoice() {
		return total_invoice;
	}

	/**
	 * @param total_invoice the total_invoice to set
	 */
	public void setTotal_invoice(Double total_invoice) {
		this.total_invoice = total_invoice;
	}

	/**
	 * @return the paymentAttempts_invoice
	 */
	public Integer getPaymentAttempts_invoice() {
		return paymentAttempts_invoice;
	}

	/**
	 * @param paymentAttempts_invoice the paymentAttempts_invoice to set
	 */
	public void setPaymentAttempts_invoice(Integer paymentAttempts_invoice) {
		this.paymentAttempts_invoice = paymentAttempts_invoice;
	}

	/**
	 * @return the status_invoice
	 */
	public Integer getStatus_invoice() {
		return status_invoice;
	}

	/**
	 * @param status_invoice the status_invoice to set
	 */
	public void setStatus_invoice(Integer status_invoice) {
		this.status_invoice = status_invoice;
	}

	/**
	 * @return the balance_invoice
	 */
	public Double getBalance_invoice() {
		return balance_invoice;
	}

	/**
	 * @param balance_invoice the balance_invoice to set
	 */
	public void setBalance_invoice(Double balance_invoice) {
		this.balance_invoice = balance_invoice;
	}

	/**
	 * @return the dateCreated_invoice
	 */
	public Date getDateCreated_invoice() {
		return dateCreated_invoice;
	}

	/**
	 * @param dateCreated_invoice the dateCreated_invoice to set
	 */
	public void setDateCreated_invoice(Date dateCreated_invoice) {
		this.dateCreated_invoice = dateCreated_invoice;
	}

	/**
	 * @return the lastUpdated_invoice
	 */
	public Date getLastUpdated_invoice() {
		return lastUpdated_invoice;
	}

	/**
	 * @param lastUpdated_invoice the lastUpdated_invoice to set
	 */
	public void setLastUpdated_invoice(Date lastUpdated_invoice) {
		this.lastUpdated_invoice = lastUpdated_invoice;
	}

	/**
	 * @return the feeRate_partner
	 */
	public Double getFeeRate_partner() {
		return feeRate_partner;
	}

	/**
	 * @param feeRate_partner the feeRate_partner to set
	 */
	public void setFeeRate_partner(Double feeRate_partner) {
		this.feeRate_partner = feeRate_partner;
	}

	/**
	 * @return the taxtRate_invoice
	 */
	public Double getTaxtRate_invoice() {
		return taxtRate_invoice;
	}

	/**
	 * @param taxtRate_invoice the taxtRate_invoice to set
	 */
	public void setTaxtRate_invoice(Double taxtRate_invoice) {
		this.taxtRate_invoice = taxtRate_invoice;
	}
	
	
	
}
