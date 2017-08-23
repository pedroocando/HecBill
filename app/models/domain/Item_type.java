package models.domain;
import javax.persistence.*;

/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "invoice_lines")
public class Item_type extends AbstractEntity {
	@Column(nullable = false)
	protected String description_itemType;

	/**
	 * @return the description_itemType
	 */
	public String getDescription_itemType() {
		return description_itemType;
	}

	/**
	 * @param description_itemType the description_itemType to set
	 */
	public void setDescription_itemType(String description_itemType) {
		this.description_itemType = description_itemType;
	}
	
	

}
