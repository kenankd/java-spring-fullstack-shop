package com.greenleaf.shop.service;

import com.greenleaf.shop.model.Product;
import com.greenleaf.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Page<Product> findProducts(Integer pageNum, String category, String gender){
        int pageSize=6;
        //change this later
        if(gender!=null && gender.equals("null")) gender=null;
        if(gender!=null && gender.equals("null")) gender=null;
        if(category!=null && category.equals("null")) category=null;
        Pageable pageable=PageRequest.of(pageNum-1,pageSize);
        if(category==null && gender==null) return productRepository.findAll(pageable);
        if(category == null) return productRepository.findByGender(gender,pageable);
        if(gender == null) return productRepository.findByCategory(category,pageable);
        return productRepository.findByCategoryAndGender(category,gender,pageable);

    }
}
