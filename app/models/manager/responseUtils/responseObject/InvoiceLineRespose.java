package models.manager.responseUtils.responseObject;
/**
*
* @author Pedro Ocando
* 2017
*/
public class InvoiceLineRespose extends AbstractEntityResponse {
	public Integer id_invoice;
	
	public Integer id_itemType;
	
	public Double itemAmount_invoiceLine;
	
	public String description_invoiceLine;
	
	public Double taxAmount_invoiceLine;
}
