package models.domain;
import java.util.Date;

import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "roles", referencedColumnName = "id")
	protected Integer id_role;
	
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "partners", referencedColumnName = "id")
	protected Integer id_partner;
	
	@Column(nullable = false)
	protected String name_user;
	
	@Column(nullable = false)
	protected String lastName_user;
	
	@Column(nullable = false)
	private String pass_user;
	
	@Column(nullable = false)
	protected Date lastDateLogin_user;
	
	@Column(nullable = false)
	protected Integer status_user; // 1:Activo - 0:Inactivo

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
	 * @return the name_user
	 */
	public String getName_user() {
		return name_user;
	}

	/**
	 * @param name_user the name_user to set
	 */
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	/**
	 * @return the lastName_user
	 */
	public String getLastName_user() {
		return lastName_user;
	}

	/**
	 * @param lastName_user the lastName_user to set
	 */
	public void setLastName_user(String lastName_user) {
		this.lastName_user = lastName_user;
	}

	/**
	 * @return the pass_user
	 */
	public String getPass_user() {
		return pass_user;
	}

	/**
	 * @param pass_user the pass_user to set
	 */
	public void setPass_user(String pass_user) {
		this.pass_user = pass_user;
	}

	/**
	 * @return the lastDateLogin_user
	 */
	public Date getLastDateLogin_user() {
		return lastDateLogin_user;
	}

	/**
	 * @param lastDateLogin_user the lastDateLogin_user to set
	 */
	public void setLastDateLogin_user(Date lastDateLogin_user) {
		this.lastDateLogin_user = lastDateLogin_user;
	}

	/**
	 * @return the status_user
	 */
	public Integer getStatus_user() {
		return status_user;
	}

	/**
	 * @param status_user the status_user to set
	 */
	public void setStatus_user(Integer status_user) {
		this.status_user = status_user;
	}
	
	
}
