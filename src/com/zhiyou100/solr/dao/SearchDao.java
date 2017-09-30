package com.zhiyou100.solr.dao;

import java.util.List;

import com.zhiyou100.solr.modle.ProductModel;
import com.zhiyou100.solr.modle.Search;

public interface SearchDao {

	List<ProductModel> findTheList(Search sh);

	


}
