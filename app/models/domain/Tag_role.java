package models.domain;

import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "tag_roles")
public class Tag_role extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "roles", referencedColumnName = "id")
	protected Integer id_role;
	
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "tags", referencedColumnName = "id")
	protected Integer id_tag;

	/**
	 * @return the id_role
	 */
	public Integer getId_role() {
		return id_role;
	}

	/**
	 * @param id_role the id_role to set
	 */
	public void setId_role(Integer id_role) {
		this.id_role = id_role;
	}

	/**
	 * @return the id_tag
	 */
	public Integer getId_tag() {
		return id_tag;
	}

	/**
	 * @param id_tag the id_tag to set
	 */
	public void setId_tag(Integer id_tag) {
		this.id_tag = id_tag;
	}
	
	
}
