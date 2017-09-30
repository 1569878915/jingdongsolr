package com.zhiyou100.solr.service;

import java.util.List;

import com.zhiyou100.solr.modle.ProductModel;
import com.zhiyou100.solr.modle.Search;

public interface SearchService {

	

	
	List<ProductModel> findTheList(Search sh);



}
