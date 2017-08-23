package models.domain;

import javax.persistence.*;
/**
*
* @author Pedro Ocando
* 2017
*/

@Entity
@Table(name = "countries")
public class Country extends AbstractEntity{
	@Column(nullable = false,unique= true)
	protected String name_country;

	/**
	 * @return the name_country
	 */
	public String getName_country() {
		return name_country;
	}

	/**
	 * @param name_country the name_country to set
	 */
	public void setName_country(String name_country) {
		this.name_country = name_country;
	}
	
}
