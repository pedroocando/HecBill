package models.domain;
import javax.persistence.*;
import play.data.validation.Constraints;
/**
*
* @author Pedro Ocando
* 2017
*/

@Entity
@Table(name = "frecuencies")
public class Frecuency extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "partners", referencedColumnName = "id")
	protected Integer id_partner;
	
	@Column(nullable = false)
	protected String day_frecuency;
	
	@Column(nullable = false)
	protected String month_frecuency;
	
	@Column(nullable = false)
	protected String dayOfWeek_frecuency;
	
	@Column(nullable = false)
	protected String name_frecuency;

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
	 * @return the day_frecuency
	 */
	public String getDay_frecuency() {
		return day_frecuency;
	}

	/**
	 * @param day_frecuency the day_frecuency to set
	 */
	public void setDay_frecuency(String day_frecuency) {
		this.day_frecuency = day_frecuency;
	}

	/**
	 * @return the month_frecuency
	 */
	public String getMonth_frecuency() {
		return month_frecuency;
	}

	/**
	 * @param month_frecuency the month_frecuency to set
	 */
	public void setMonth_frecuency(String month_frecuency) {
		this.month_frecuency = month_frecuency;
	}

	/**
	 * @return the dayOfWeek_frecuency
	 */
	public String getDayOfWeek_frecuency() {
		return dayOfWeek_frecuency;
	}

	/**
	 * @param dayOfWeek_frecuency the dayOfWeek_frecuency to set
	 */
	public void setDayOfWeek_frecuency(String dayOfWeek_frecuency) {
		this.dayOfWeek_frecuency = dayOfWeek_frecuency;
	}

	/**
	 * @return the name_frecuency
	 */
	public String getName_frecuency() {
		return name_frecuency;
	}

	/**
	 * @param name_frecuency the name_frecuency to set
	 */
	public void setName_frecuency(String name_frecuency) {
		this.name_frecuency = name_frecuency;
	}
	
	
	
}
