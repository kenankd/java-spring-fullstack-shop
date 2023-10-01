package com.greenleaf.shop.repository;

import com.greenleaf.shop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findByGender(String gender, Pageable pageable);
    @Query("SELECT p FROM Product p JOIN p.subtypeCategory c JOIN c.parentCategory c1 WHERE c1.name = :categoryName")
    Page<Product> findByCategory(@Param("categoryName") String categoryName, Pageable pageable);
}
