package com.zhiyou100.solr.modle;

public class Search {

	private String queryString;
	private String price;
	private String sort;
	private String catalog_name;

	// catalog_name
	// private int totalHits;
	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCatalog_name() {
		return catalog_name;
	}

	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}

	@Override
	public String toString() {
		return "Search [queryString=" + queryString + ", price=" + price + ", sort=" + sort + ", catalog_name="
				+ catalog_name + "]";
	}

}
