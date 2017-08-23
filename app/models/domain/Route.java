package models.domain;
import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "routes")
public class Route extends AbstractEntity {
	@Column(nullable = false)
	protected String name_route;
	
	@Column(nullable = false)
	protected String description_route;
	
	@Column(nullable = false)
	protected Integer route_type;
	
	@Column(nullable = false)
	protected Integer status_route;

	/**
	 * @return the name_route
	 */
	public String getName_route() {
		return name_route;
	}

	/**
	 * @param name_route the name_route to set
	 */
	public void setName_route(String name_route) {
		this.name_route = name_route;
	}

	/**
	 * @return the description_route
	 */
	public String getDescription_route() {
		return description_route;
	}

	/**
	 * @param description_route the description_route to set
	 */
	public void setDescription_route(String description_route) {
		this.description_route = description_route;
	}

	/**
	 * @return the route_type
	 */
	public Integer getRoute_type() {
		return route_type;
	}

	/**
	 * @param route_type the route_type to set
	 */
	public void setRoute_type(Integer route_type) {
		this.route_type = route_type;
	}

	/**
	 * @return the status_route
	 */
	public Integer getStatus_route() {
		return status_route;
	}

	/**
	 * @param status_route the status_route to set
	 */
	public void setStatus_route(Integer status_route) {
		this.status_route = status_route;
	}
	
	
}
