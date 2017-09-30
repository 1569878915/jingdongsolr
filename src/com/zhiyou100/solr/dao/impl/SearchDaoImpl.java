package com.zhiyou100.solr.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Repository;

import com.zhiyou100.solr.dao.SearchDao;
import com.zhiyou100.solr.modle.ProductModel;
import com.zhiyou100.solr.modle.Search;

@Repository
public class SearchDaoImpl implements SearchDao {
	/* [queryString=, price=40-49, sort=1, catalog_name=产品配件] */
	@Override
	public List<ProductModel> findTheList(Search sh) {
		List<ProductModel> list1 = new ArrayList<ProductModel>();
		System.out.println("----" + sh);
		SolrServer server = new HttpSolrServer("http://localhost:8081/solr");
		SolrQuery query = new SolrQuery();
		// product_price 是金属的 query
		// query.set("q", "product_price:金属");
		

		if (sh.getQueryString() == null || sh.getQueryString() == "") {
			query.set("q", "product_name:*");
		} else {
			query.set("q", "product_name:" + sh.getQueryString());
		}
		if (sh.getPrice() == null || sh.getPrice() == "") {
			query.set("fq", "product_price:[0 TO 10]");
		} else {
			 String replace = sh.getPrice().replace("-", " TO ");
			 System.out.println("----分割"+replace);
			 //+ "["+replace+"]"
			query.set("fq", "product_price:[0 TO 10]" );
		}
		if (sh.getCatalog_name() == "" || sh.getCatalog_name() == null) {
			query.set("fq", "product_catalog_name:*");
		} else {
			query.set("fq", "product_catalog_name:" + sh.getCatalog_name());
		}

		// 枚举类型 Sort 排序
		if (sh.getSort() == "1" && sh.getSort() == "" || sh.getSort() == null) {
			query.setSort("product_price", ORDER.asc);
		} else {
			query.setSort("product_price", ORDER.desc);
		}

		query.setStart(0);
		query.setRows(15);
		query.set("fl", "product_name,id,product_price,description,product_catalog_name,product_picture");
		query.set("df", "product_name");

		query.setHighlight(true);
		query.addHighlightField("product_name");
		query.setHighlightSimplePre("<span style='color:red'>");
		query.setHighlightSimplePost("</span>");
		// 通过查询获取对应的结果
		QueryResponse response;
		try {
			response = server.query(query);
			SolrDocumentList results = response.getResults();
			
			  Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			  System.out.println(results.getNumFound());

			for (SolrDocument document : results) {
				ProductModel pm = new ProductModel();
				pm.setPid((String) document.get("id"));
				pm.setPicture((String) document.get("product_picture"));
				pm.setDescription((String) document.get("product_description"));
				pm.setCatalog_name((String) document.get("product_catalog_name"));
				//pm.setName((String) document.get("product_name"));
				pm.setPrice((float) document.get("product_price"));
				

				/*System.out.println("ssssssssid" + document.get("id"));
				System.out.println(document.get("product_catalog_name"));*/
				System.out.println(document.get("product_price")); //
			/*	System.out.println(document.get("id"));*/

				
				  Map<String, List<String>> map =
				  highlighting.get(document.get("id")); List<String> list =
				  map.get("product_name"); 
				 // System.out.println(list.get(0));
				  pm.setName(list.get(0));
				  list.get(0);
				  list1.add(pm);
				  }
		} catch (SolrServerException e) {

			e.printStackTrace();
		}

		return list1;
	}

}