package com.highradius.jdbcassignment;

public class InfinityPOJO {
	String first;
	String last;
	int id;
	String alias;
	String quote;
	public InfinityPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InfinityPOJO(String first, String last, int id, String alias, String quote) {
		super();
		this.first = first;
		this.last = last;
		this.id = id;
		this.alias = alias;
		this.quote = quote;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	
}
