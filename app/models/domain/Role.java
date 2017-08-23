package models.domain;
import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity{
	@Column(nullable = false)
	protected String name_role;

	/**
	 * @return the name_role
	 */
	public String getName_role() {
		return name_role;
	}

	/**
	 * @param name_role the name_role to set
	 */
	public void setName_role(String name_role) {
		this.name_role = name_role;
	}
	
	
}
