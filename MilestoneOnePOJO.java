package com.highradius.milestoneONE;

public class MilestoneOnePOJO {
	private String business_code;
	private String cust_number;
	private String name_customer;
	private String clear_date;
	private int business_year;
	private long doc_id;
	private String posting_date;
	private String document_create_date;
	private String due_in_date;
	private String invoice_currency;
	private String document_type;
	private short posting_id;
	private String area_business;
	private double total_open_amount;
	private String baseline_create_date;
	private String cust_payment_terms;
	private long invoice_id;
	private short isOpen;
	
	//Getters and Setters
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public String getClear_date() {
		return clear_date;
	}
	public void setClear_date(String clear_date) {
		this.clear_date = clear_date;
	}
	public int getBusiness_year() {
		return business_year;
	}
	public void setBusiness_year(String business_year) {
		this.business_year = (int)Float.parseFloat(business_year);
	}
	public long getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = (long)Double.parseDouble(doc_id);
	}
	public String getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(String posting_date) {
		this.posting_date = posting_date;
	}
	public String getDocument_create_date() {
		return document_create_date;
	}
	public void setDocument_create_date(String document_create_date) {
		this.document_create_date = document_create_date;
	}
	public String getDue_in_date() {
		return due_in_date;
	}
	public void setDue_in_date(String due_in_date) {
		this.due_in_date = due_in_date.substring(0,8);
	}
	public String getInvoice_currency() {
		return invoice_currency;
	}
	public void setInvoice_currency(String invoice_currency) {
		this.invoice_currency = invoice_currency;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public short getPosting_id() {
		return posting_id;
	}
	public void setPosting_id(String posting_id) {
		this.posting_id = (short)Float.parseFloat(posting_id);
	}
	public String getArea_business() {
		return area_business;
	}
	public void setArea_business(String area_business) {
		this.area_business = area_business;
	}
	public double getTotal_open_amount() {
		return total_open_amount;
	}
	public void setTotal_open_amount(String total_open_amount) {
		this.total_open_amount = Double.parseDouble(total_open_amount);
	}
	public String getBaseline_create_date() {
		return baseline_create_date;
	}
	public void setBaseline_create_date(String baseline_create_date) {
		this.baseline_create_date = baseline_create_date.substring(0,8);
	}
	public String getCust_payment_terms() {
		return cust_payment_terms;
	}
	public void setCust_payment_terms(String cust_payment_terms) {
		this.cust_payment_terms = cust_payment_terms;
	}
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(String invoice_id) {
		this.invoice_id =(long)Double.parseDouble(invoice_id);
	}
	public short getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = (short)Float.parseFloat(isOpen);
	}
	
}
