package models.domain;
import java.util.Date;

import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "payments")
public class Payment extends AbstractEntity{
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "invoices", referencedColumnName = "id")
	protected Integer id_invoice;
	
	@Column(nullable = false,unique= true)
	@ManyToOne
	//@JoinColumn(name = "creditCard_tokens", referencedColumnName = "id")
	protected Integer id_token;
	
	@Column(nullable = false)
	protected Double amount_payment;
	
	@Column(nullable = false)
	protected Date dateCreated_payment;
	
	@Column(nullable = false)
	protected String type_payment; // S:Sale - R:Refound - BI: Consulta de saldo
	
	protected String resultStatus_payment;
	
	protected String descriptioon_payment;

	/**
	 * @return the id_invoice
	 */
	public Integer getId_invoice() {
		return id_invoice;
	}

	/**
	 * @param id_invoice the id_invoice to set
	 */
	public void setId_invoice(Integer id_invoice) {
		this.id_invoice = id_invoice;
	}

	/**
	 * @return the id_token
	 */
	public Integer getId_token() {
		return id_token;
	}

	/**
	 * @param id_token the id_token to set
	 */
	public void setId_token(Integer id_token) {
		this.id_token = id_token;
	}

	/**
	 * @return the amount_payment
	 */
	public Double getAmount_payment() {
		return amount_payment;
	}

	/**
	 * @param amount_payment the amount_payment to set
	 */
	public void setAmount_payment(Double amount_payment) {
		this.amount_payment = amount_payment;
	}

	/**
	 * @return the dateCreated_payment
	 */
	public Date getDateCreated_payment() {
		return dateCreated_payment;
	}

	/**
	 * @param dateCreated_payment the dateCreated_payment to set
	 */
	public void setDateCreated_payment(Date dateCreated_payment) {
		this.dateCreated_payment = dateCreated_payment;
	}

	/**
	 * @return the type_payment
	 */
	public String getType_payment() {
		return type_payment;
	}

	/**
	 * @param type_payment the type_payment to set
	 */
	public void setType_payment(String type_payment) {
		this.type_payment = type_payment;
	}

	/**
	 * @return the resultStatus_payment
	 */
	public String getResultStatus_payment() {
		return resultStatus_payment;
	}

	/**
	 * @param resultStatus_payment the resultStatus_payment to set
	 */
	public void setResultStatus_payment(String resultStatus_payment) {
		this.resultStatus_payment = resultStatus_payment;
	}

	/**
	 * @return the descriptioon_payment
	 */
	public String getDescriptioon_payment() {
		return descriptioon_payment;
	}

	/**
	 * @param descriptioon_payment the descriptioon_payment to set
	 */
	public void setDescriptioon_payment(String descriptioon_payment) {
		this.descriptioon_payment = descriptioon_payment;
	}
	
	
	

}
