package com.lawencon.booting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.booting.dao.ProductsDao;

@Service
@Transactional
public class ProductsServiceImpl {

	@Autowired
	private ProductsDao productsDao;
}