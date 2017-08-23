package models.domain;
import javax.persistence.*;
import play.data.validation.Constraints;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "plans")
public class Plan extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "partners", referencedColumnName = "id")
	protected Integer id_partner;
	
	@Column(nullable = false)
	protected String idPlan_partner;
	
	@Column(nullable = false)
	protected String name_plan;
	
	@Column(nullable = false)
	protected Double feeCost_plan;
	
	@Column(nullable = false)
	protected Double enrollmentCost_plan;
	
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "frecuencies", referencedColumnName = "id")
	protected Integer id_frecuency;
	
	@Column(nullable = false)
	protected Integer status_plan ; /// 1:Activo - 0:Inactivo
	
	@Column(nullable = false)
	//@ManyToOne
	//@JoinColumn(name = "cities", referencedColumnName = "id")
	protected Double taxRate_plan;

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
	 * @return the idPlan_partner
	 */
	public String getIdPlan_partner() {
		return idPlan_partner;
	}

	/**
	 * @param idPlan_partner the idPlan_partner to set
	 */
	public void setIdPlan_partner(String idPlan_partner) {
		this.idPlan_partner = idPlan_partner;
	}

	/**
	 * @return the name_plan
	 */
	public String getName_plan() {
		return name_plan;
	}

	/**
	 * @param name_plan the name_plan to set
	 */
	public void setName_plan(String name_plan) {
		this.name_plan = name_plan;
	}

	/**
	 * @return the feeCost_plan
	 */
	public Double getFeeCost_plan() {
		return feeCost_plan;
	}

	/**
	 * @param feeCost_plan the feeCost_plan to set
	 */
	public void setFeeCost_plan(Double feeCost_plan) {
		this.feeCost_plan = feeCost_plan;
	}

	/**
	 * @return the enrollmentCost_plan
	 */
	public Double getEnrollmentCost_plan() {
		return enrollmentCost_plan;
	}

	/**
	 * @param enrollmentCost_plan the enrollmentCost_plan to set
	 */
	public void setEnrollmentCost_plan(Double enrollmentCost_plan) {
		this.enrollmentCost_plan = enrollmentCost_plan;
	}

	/**
	 * @return the id_frecuency
	 */
	public Integer getId_frecuency() {
		return id_frecuency;
	}

	/**
	 * @param id_frecuency the id_frecuency to set
	 */
	public void setId_frecuency(Integer id_frecuency) {
		this.id_frecuency = id_frecuency;
	}

	/**
	 * @return the status_plan
	 */
	public Integer getStatus_plan() {
		return status_plan;
	}

	/**
	 * @param status_plan the status_plan to set
	 */
	public void setStatus_plan(Integer status_plan) {
		this.status_plan = status_plan;
	}

	/**
	 * @return the taxRate_plan
	 */
	public Double getTaxRate_plan() {
		return taxRate_plan;
	}

	/**
	 * @param taxRate_plan the taxRate_plan to set
	 */
	public void setTaxRate_plan(Double taxRate_plan) {
		this.taxRate_plan = taxRate_plan;
	}
	
	
	
}
