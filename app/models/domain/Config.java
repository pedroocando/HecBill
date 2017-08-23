package models.domain;
import javax.persistence.*;

/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "configs")
public class Config extends AbstractEntity {
	
	@Column(nullable = false,unique= true)
	protected String key_config;
	
	@Column(nullable = false)
	protected String value_config;

	/**
	 * @return the key_config
	 */
	public String getKey_config() {
		return key_config;
	}

	/**
	 * @param key_config the key_config to set
	 */
	public void setKey_config(String key_config) {
		this.key_config = key_config;
	}

	/**
	 * @return the value_config
	 */
	public String getValue_config() {
		return value_config;
	}

	/**
	 * @param value_config the value_config to set
	 */
	public void setValue_config(String value_config) {
		this.value_config = value_config;
	}
	
	

}
