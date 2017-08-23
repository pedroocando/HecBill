package models.domain;
import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "tags")
public class Tag extends AbstractEntity  {
	@Column(nullable = false)
	protected String name_tag;
	
	@Column(nullable = false)
	protected String description_tag;

	/**
	 * @return the name_tag
	 */
	public String getName_tag() {
		return name_tag;
	}

	/**
	 * @param name_tag the name_tag to set
	 */
	public void setName_tag(String name_tag) {
		this.name_tag = name_tag;
	}

	/**
	 * @return the description_tag
	 */
	public String getDescription_tag() {
		return description_tag;
	}

	/**
	 * @param description_tag the description_tag to set
	 */
	public void setDescription_tag(String description_tag) {
		this.description_tag = description_tag;
	}
	
	

}
