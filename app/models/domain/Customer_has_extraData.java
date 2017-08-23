package models.domain;
import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "customer_has_extraData")
public class Customer_has_extraData extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "customers", referencedColumnName = "id")
	protected Integer id_customer;
	
	@Column(nullable = false)
	protected Integer id_extraData;
	
	@Column(nullable = false)
	protected String value_extraData;

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
	 * @return the id_extraData
	 */
	public Integer getId_extraData() {
		return id_extraData;
	}

	/**
	 * @param id_extraData the id_extraData to set
	 */
	public void setId_extraData(Integer id_extraData) {
		this.id_extraData = id_extraData;
	}

	/**
	 * @return the value_extraData
	 */
	public String getValue_extraData() {
		return value_extraData;
	}

	/**
	 * @param value_extraData the value_extraData to set
	 */
	public void setValue_extraData(String value_extraData) {
		this.value_extraData = value_extraData;
	}
	
	

}
