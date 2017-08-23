package models.domain;
import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "customer_has_extraData")
public class ExtraData_customer extends AbstractEntity {
	@Column(nullable = false)
	protected String name_extraData;

	/**
	 * @return the name_extraData
	 */
	public String getName_extraData() {
		return name_extraData;
	}

	/**
	 * @param name_extraData the name_extraData to set
	 */
	public void setName_extraData(String name_extraData) {
		this.name_extraData = name_extraData;
	}
	
	

}
