package models.domain;
import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "cities")
public class City extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "countries", referencedColumnName = "id")
	protected Integer id_country;
	
	@Column(nullable = false,unique= true)
	protected String name_city;

	/**
	 * @return the id_country
	 */
	public Integer getId_country() {
		return id_country;
	}

	/**
	 * @param id_country the id_country to set
	 */
	public void setId_country(Integer id_country) {
		this.id_country = id_country;
	}

	/**
	 * @return the name_city
	 */
	public String getName_city() {
		return name_city;
	}

	/**
	 * @param name_city the name_city to set
	 */
	public void setName_city(String name_city) {
		this.name_city = name_city;
	}
	
}
