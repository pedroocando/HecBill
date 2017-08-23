package models.domain;
import java.util.Date;

import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "creditCard_tokens")
public class CreditCard_token extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "customers", referencedColumnName = "id")
	protected Integer id_customer;
	
	@Column(nullable = false,unique= true)
	protected String token_creditCardToken;
	
	@Column(nullable = false)
	protected Date dateCreated_creditCardtoken;

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
	 * @return the token_creditCardToken
	 */
	public String getToken_creditCardToken() {
		return token_creditCardToken;
	}

	/**
	 * @param token_creditCardToken the token_creditCardToken to set
	 */
	public void setToken_creditCardToken(String token_creditCardToken) {
		this.token_creditCardToken = token_creditCardToken;
	}

	/**
	 * @return the dateCreated_creditCardtoken
	 */
	public Date getDateCreated_creditCardtoken() {
		return dateCreated_creditCardtoken;
	}

	/**
	 * @param dateCreated_creditCardtoken the dateCreated_creditCardtoken to set
	 */
	public void setDateCreated_creditCardtoken(Date dateCreated_creditCardtoken) {
		this.dateCreated_creditCardtoken = dateCreated_creditCardtoken;
	}
	
	

}
