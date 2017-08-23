package models.domain;
import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "route_tags")
public class Route_tag extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "routes", referencedColumnName = "id")
	protected Integer id_route;
	
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "tags", referencedColumnName = "id")
	protected Integer id_tag;

	/**
	 * @return the id_route
	 */
	public Integer getId_route() {
		return id_route;
	}

	/**
	 * @param id_route the id_route to set
	 */
	public void setId_route(Integer id_route) {
		this.id_route = id_route;
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
