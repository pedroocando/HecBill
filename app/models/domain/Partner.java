package models.domain;


import play.data.validation.Constraints;

import javax.persistence.*;

/**
 *
 * @author Pedro Ocando
 * 2017
 */
@Entity
@Table(name = "partners")
public class Partner extends AbstractEntity {
	
	protected Integer idParent_partner;
	
	@Column(nullable = false,unique= true)
	protected String name_partner;
	
	@Column(nullable = false)
	protected String adress_partner;
	
	@Column(nullable = false,unique= true)
	protected String phone_partner;
	
	@Column(nullable = false)
	protected Integer status_partner; /// Valores - 1: Activo - 0:Inactivo - 2:Pendiente
	
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "cities", referencedColumnName = "id")
	protected Integer id_city;
	
	@Column(nullable = false)
	protected Double feeRate_partner;
	
	@Column(nullable = false)
	protected Integer idNumPriority_partner;
	
	@Column(nullable = false,unique= true)
	protected String email_partner;
	
	@Column(columnDefinition = "TEXT")
    protected String token;  // Token de validacion para validar operaciones

	/**
	 * @return the idParent_partner
	 */
	public Integer getIdParent_partner() {
		return idParent_partner;
	}

	/**
	 * @param idParent_partner the idParent_partner to set
	 */
	public void setIdParent_partner(Integer idParent_partner) {
		this.idParent_partner = idParent_partner;
	}

	/**
	 * @return the name_partner
	 */
	public String getName_partner() {
		return name_partner;
	}

	/**
	 * @param name_partner the name_partner to set
	 */
	public void setName_partner(String name_partner) {
		this.name_partner = name_partner;
	}

	/**
	 * @return the adress_partner
	 */
	public String getAdress_partner() {
		return adress_partner;
	}

	/**
	 * @param adress_partner the adress_partner to set
	 */
	public void setAdress_partner(String adress_partner) {
		this.adress_partner = adress_partner;
	}

	/**
	 * @return the phone_partner
	 */
	public String getPhone_partner() {
		return phone_partner;
	}

	/**
	 * @param phone_partner the phone_partner to set
	 */
	public void setPhone_partner(String phone_partner) {
		this.phone_partner = phone_partner;
	}

	/**
	 * @return the status_partner
	 */
	public Integer getStatus_partner() {
		return status_partner;
	}

	/**
	 * @param status_partner the status_partner to set
	 */
	public void setStatus_partner(Integer status_partner) {
		this.status_partner = status_partner;
	}

	/**
	 * @return the id_city
	 */
	public Integer getId_city() {
		return id_city;
	}

	/**
	 * @param id_city the id_city to set
	 */
	public void setId_city(Integer id_city) {
		this.id_city = id_city;
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
	 * @return the idNumPriority_partner
	 */
	public Integer getIdNumPriority_partner() {
		return idNumPriority_partner;
	}

	/**
	 * @param idNumPriority_partner the idNumPriority_partner to set
	 */
	public void setIdNumPriority_partner(Integer idNumPriority_partner) {
		this.idNumPriority_partner = idNumPriority_partner;
	}

	/**
	 * @return the email_partner
	 */
	public String getEmail_partner() {
		return email_partner;
	}

	/**
	 * @param email_partner the email_partner to set
	 */
	public void setEmail_partner(String email_partner) {
		this.email_partner = email_partner;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
}
