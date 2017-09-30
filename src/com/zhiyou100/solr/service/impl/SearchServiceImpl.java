package com.zhiyou100.solr.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.solr.dao.SearchDao;
import com.zhiyou100.solr.modle.ProductModel;
import com.zhiyou100.solr.modle.Search;
import com.zhiyou100.solr.service.SearchService;



@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchDao sm;

	@Override
	public List<ProductModel> findTheList(Search sh) {
		// TODO Auto-generated method stub
		return sm.findTheList( sh);
	}

	/*@Override
	public List<Search> findTheList(Search sh) {
		
		return sm.findTheList( sh);
	}
*/
	
	/* [queryString=, price=40-49, sort=1, catalog_name=产品配件] */
	/*@Override
	public List<ProductModel> findTheList(Search sh) {
		List<ProductModel> list1 = new ArrayList<ProductModel>();
		System.out.println("----" + sh);
		SolrServer server = new HttpSolrServer("http://localhost:8081/solr");
		SolrQuery query = new SolrQuery();
		// product_price 是金属的 query
		// query.set("q", "product_price:金属");
		if (!("").equals(sh.getQueryString()) && sh.getQueryString() != null) {
			query.set("q", "product_name:" + sh.getQueryString());
		}
		if (!("").equals(sh.getPrice()) && sh.getPrice() != null) {
			query.set("fq", "product_price:" + sh.getPrice().replace("-", " TO "));
		}

		if (!("").equals(sh.getCatalog_name()) && sh.getCatalog_name() != null) {
			query.set("fq", "product_catalog_name:" + sh.getCatalog_name());
		}*/

	
	
	
}
