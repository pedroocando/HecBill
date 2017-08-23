package models.domain;
import java.util.Date;

import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "customer_has_plans")
public class Customer_has_plan extends AbstractEntity  {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "plans", referencedColumnName = "id")
	protected Integer id_plan;
	
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "customers", referencedColumnName = "id")
	protected Integer id_customer;
	
	@Column(nullable = false)
	protected Date startdate_customerPlan;
	
	@Column(nullable = false)
	protected Date endDate_customerPlan;
	
	@Column(nullable = false)
	protected Integer status_customerPlan;

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
	 * @return the startdate_customerPlan
	 */
	public Date getStartdate_customerPlan() {
		return startdate_customerPlan;
	}

	/**
	 * @param startdate_customerPlan the startdate_customerPlan to set
	 */
	public void setStartdate_customerPlan(Date startdate_customerPlan) {
		this.startdate_customerPlan = startdate_customerPlan;
	}

	/**
	 * @return the endDate_customerPlan
	 */
	public Date getEndDate_customerPlan() {
		return endDate_customerPlan;
	}

	/**
	 * @param endDate_customerPlan the endDate_customerPlan to set
	 */
	public void setEndDate_customerPlan(Date endDate_customerPlan) {
		this.endDate_customerPlan = endDate_customerPlan;
	}

	/**
	 * @return the status_customerPlan
	 */
	public Integer getStatus_customerPlan() {
		return status_customerPlan;
	}

	/**
	 * @param status_customerPlan the status_customerPlan to set
	 */
	public void setStatus_customerPlan(Integer status_customerPlan) {
		this.status_customerPlan = status_customerPlan;
	}
	
	
	

}
