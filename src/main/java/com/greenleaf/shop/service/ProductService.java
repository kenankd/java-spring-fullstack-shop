package com.greenleaf.shop.service;

import com.greenleaf.shop.model.Product;
import com.greenleaf.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Page<Product> findProducts(Integer pageNum){
        int pageSize=6;
        Pageable pageable=PageRequest.of(pageNum-1,pageSize);
        return productRepository.findAll(pageable);
    }
}
