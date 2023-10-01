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
    @Query("SELECT * from product p INNER JOIN category c ON p.subtype_category_id=c.id INNER JOIN category c1 ON c.parent_id=c1.id WHERE c1.name= :categoryName;")
    Page<Product> findByCategory(@Param("categoryName") String categoryName, Pageable pageable);
}
