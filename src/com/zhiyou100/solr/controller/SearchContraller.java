package com.zhiyou100.solr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.solr.modle.ProductModel;
import com.zhiyou100.solr.modle.Search;
import com.zhiyou100.solr.service.SearchService;


@Controller
public class SearchContraller {
	@Autowired
	SearchService ss;

	@RequestMapping(value = "/list.action" )
	public String logout(Search sh, Model md) {
		
		System.out.println(sh);
		List<ProductModel> list =ss.findTheList(sh);
		System.out.println(list);
		md.addAttribute("catalog_name", sh.getCatalog_name());
		md.addAttribute("sort", sh.getSort());
		
		md.addAttribute("price", sh.getPrice());
		md.addAttribute("queryString", sh.getQueryString());
		md.addAttribute("list", list);
		return "product_list";

	}

}
