package models.domain;
import java.util.Date;

import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/

@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "partners", referencedColumnName = "id")
	protected Integer id_partner;
	
	@Column(nullable = false,unique= true)
	protected String identifier_customer; // DNI o Cedula
	
	@Column(nullable = false)
	protected String name_customer;
	
	@Column(nullable = false)
	protected String lastName_customer;
	
	@Column(nullable = false,unique= true)
	protected String phoneNumber_customer;
	
	@Column(nullable = false)
	protected String adress_customer;
	
	@Column(nullable = false)
	protected Date dateAdmission_customer; /// comienzo del plan
	
	@Column(nullable = false)
	protected Date dateExperiation_customer;/// fecha que se debe realizar el cobro
	
	@Column(nullable = false)
	protected Date birthDate_customer;
	
	@Column(nullable = false)
	protected Date dateUpdated_customer; // actualizacion de datos
	
	@Column(nullable = false)
	protected Boolean notify_customer; // Evento de cobro 
	
	@Column(nullable = false)
	protected Integer status_customer;
	
	@Column(nullable = false,unique= true)
	protected String numContrac_customer;
	
	@Column(nullable = false)
	protected Double balance_customer;/// monto que adeuda el afiliado
	
	@Column(nullable = false)
	protected Integer 	idCurrent_invoice ; // factura actual
	
	@Column(nullable = false)
	protected Date lastOkBillingDate; // ultimo intento de cobro exitoso
	
	@Column(nullable = false,unique= true)
	protected String email_customer;

	/**
	 * @return the id_partner
	 */
	public Integer getId_partner() {
		return id_partner;
	}

	/**
	 * @param id_partner the id_partner to set
	 */
	public void setId_partner(Integer id_partner) {
		this.id_partner = id_partner;
	}

	/**
	 * @return the idenfier_customer
	 */
	public String getIdenfier_customer() {
		return identifier_customer;
	}

	/**
	 * @param idenfier_customer the idenfier_customer to set
	 */
	public void setIdenfier_customer(String idenfier_customer) {
		this.identifier_customer = idenfier_customer;
	}

	/**
	 * @return the name_customer
	 */
	public String getName_customer() {
		return name_customer;
	}

	/**
	 * @param name_customer the name_customer to set
	 */
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}

	/**
	 * @return the lastName_customer
	 */
	public String getLastName_customer() {
		return lastName_customer;
	}

	/**
	 * @param lastName_customer the lastName_customer to set
	 */
	public void setLastName_customer(String lastName_customer) {
		this.lastName_customer = lastName_customer;
	}

	/**
	 * @return the phoneNumber_customer
	 */
	public String getPhoneNumber_customer() {
		return phoneNumber_customer;
	}

	/**
	 * @param phoneNumber_customer the phoneNumber_customer to set
	 */
	public void setPhoneNumber_customer(String phoneNumber_customer) {
		this.phoneNumber_customer = phoneNumber_customer;
	}

	/**
	 * @return the adress_customer
	 */
	public String getAdress_customer() {
		return adress_customer;
	}

	/**
	 * @param adress_customer the adress_customer to set
	 */
	public void setAdress_customer(String adress_customer) {
		this.adress_customer = adress_customer;
	}

	/**
	 * @return the dateAdmission_customer
	 */
	public Date getDateAdmission_customer() {
		return dateAdmission_customer;
	}

	/**
	 * @param dateAdmission_customer the dateAdmission_customer to set
	 */
	public void setDateAdmission_customer(Date dateAdmission_customer) {
		this.dateAdmission_customer = dateAdmission_customer;
	}

	/**
	 * @return the dateExperiation_customer
	 */
	public Date getDateExperiation_customer() {
		return dateExperiation_customer;
	}

	/**
	 * @param dateExperiation_customer the dateExperiation_customer to set
	 */
	public void setDateExperiation_customer(Date dateExperiation_customer) {
		this.dateExperiation_customer = dateExperiation_customer;
	}

	/**
	 * @return the birthDate_customer
	 */
	public Date getBirthDate_customer() {
		return birthDate_customer;
	}

	/**
	 * @param birthDate_customer the birthDate_customer to set
	 */
	public void setBirthDate_customer(Date birthDate_customer) {
		this.birthDate_customer = birthDate_customer;
	}

	/**
	 * @return the dateUpdated_customer
	 */
	public Date getDateUpdated_customer() {
		return dateUpdated_customer;
	}

	/**
	 * @param dateUpdated_customer the dateUpdated_customer to set
	 */
	public void setDateUpdated_customer(Date dateUpdated_customer) {
		this.dateUpdated_customer = dateUpdated_customer;
	}

	/**
	 * @return the notify_customer
	 */
	public Boolean getNotify_customer() {
		return notify_customer;
	}

	/**
	 * @param notify_customer the notify_customer to set
	 */
	public void setNotify_customer(Boolean notify_customer) {
		this.notify_customer = notify_customer;
	}

	/**
	 * @return the status_customer
	 */
	public Integer getStatus_customer() {
		return status_customer;
	}

	/**
	 * @param status_customer the status_customer to set
	 */
	public void setStatus_customer(Integer status_customer) {
		this.status_customer = status_customer;
	}

	/**
	 * @return the numContrac_customer
	 */
	public String getNumContrac_customer() {
		return numContrac_customer;
	}

	/**
	 * @param numContrac_customer the numContrac_customer to set
	 */
	public void setNumContrac_customer(String numContrac_customer) {
		this.numContrac_customer = numContrac_customer;
	}

	/**
	 * @return the balance_customer
	 */
	public Double getBalance_customer() {
		return balance_customer;
	}

	/**
	 * @param balance_customer the balance_customer to set
	 */
	public void setBalance_customer(Double balance_customer) {
		this.balance_customer = balance_customer;
	}

	/**
	 * @return the idCurrent_invoice
	 */
	public Integer getIdCurrent_invoice() {
		return idCurrent_invoice;
	}

	/**
	 * @param idCurrent_invoice the idCurrent_invoice to set
	 */
	public void setIdCurrent_invoice(Integer idCurrent_invoice) {
		this.idCurrent_invoice = idCurrent_invoice;
	}

	/**
	 * @return the lastOkBillingDate
	 */
	public Date getLastOkBillingDate() {
		return lastOkBillingDate;
	}

	/**
	 * @param lastOkBillingDate the lastOkBillingDate to set
	 */
	public void setLastOkBillingDate(Date lastOkBillingDate) {
		this.lastOkBillingDate = lastOkBillingDate;
	}

	/**
	 * @return the email_customer
	 */
	public String getEmail_customer() {
		return email_customer;
	}

	/**
	 * @param email_customer the email_customer to set
	 */
	public void setEmail_customer(String email_customer) {
		this.email_customer = email_customer;
	}
	
	
	
}
