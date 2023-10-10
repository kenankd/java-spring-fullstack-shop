package com.greenleaf.shop.repository;

import com.greenleaf.shop.model.Contact;
import com.greenleaf.shop.model.Product;
import com.greenleaf.shop.model.ShoppingCart;
import com.greenleaf.shop.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {


}
