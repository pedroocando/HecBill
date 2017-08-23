package models.domain;
import javax.persistence.*;

/**
*
* @author Pedro Ocando
* 2017
*/
@Entity
@Table(name = "invoice_lines")
public class Invoice_line extends AbstractEntity {
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "invoices", referencedColumnName = "id")
	protected Integer id_invoice;
	
	@Column(nullable = false)
	@ManyToOne
	//@JoinColumn(name = "item_types", referencedColumnName = "id")
	protected Integer id_itemType;
	
	@Column(nullable = false)
	protected Double itemAmount_invoiceLine;
	
	@Column(nullable = false)
	protected String description_invoiceLine;
	
	@Column(nullable = false)
	protected Double taxAmount_invoiceLine;

	/**
	 * @return the id_invoice
	 */
	public Integer getId_invoice() {
		return id_invoice;
	}

	/**
	 * @param id_invoice the id_invoice to set
	 */
	public void setId_invoice(Integer id_invoice) {
		this.id_invoice = id_invoice;
	}

	/**
	 * @return the id_itemType
	 */
	public Integer getId_itemType() {
		return id_itemType;
	}

	/**
	 * @param id_itemType the id_itemType to set
	 */
	public void setId_itemType(Integer id_itemType) {
		this.id_itemType = id_itemType;
	}

	/**
	 * @return the itemAmount_invoiceLine
	 */
	public Double getItemAmount_invoiceLine() {
		return itemAmount_invoiceLine;
	}

	/**
	 * @param itemAmount_invoiceLine the itemAmount_invoiceLine to set
	 */
	public void setItemAmount_invoiceLine(Double itemAmount_invoiceLine) {
		this.itemAmount_invoiceLine = itemAmount_invoiceLine;
	}

	/**
	 * @return the description_invoiceLine
	 */
	public String getDescription_invoiceLine() {
		return description_invoiceLine;
	}

	/**
	 * @param description_invoiceLine the description_invoiceLine to set
	 */
	public void setDescription_invoiceLine(String description_invoiceLine) {
		this.description_invoiceLine = description_invoiceLine;
	}

	/**
	 * @return the taxAmount_invoiceLine
	 */
	public Double getTaxAmount_invoiceLine() {
		return taxAmount_invoiceLine;
	}

	/**
	 * @param taxAmount_invoiceLine the taxAmount_invoiceLine to set
	 */
	public void setTaxAmount_invoiceLine(Double taxAmount_invoiceLine) {
		this.taxAmount_invoiceLine = taxAmount_invoiceLine;
	}
	
	
	
	
}
