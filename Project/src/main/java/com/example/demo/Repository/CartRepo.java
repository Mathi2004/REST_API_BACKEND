package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.CartModel;

import jakarta.transaction.Transactional;

public interface CartRepo extends JpaRepository<CartModel, Integer>{
	@Query(value="select * from maincart where cart_id=:a",nativeQuery=true)
    public List<CartModel> productIdinfo(@Param("a") int cart_id);
	@Transactional
	@Modifying
	@Query(value="delete from maincart where cart_id=:b",nativeQuery=true)
    public Integer deleteproductId(@Param("b") int cart_id);
	@Modifying
	@Transactional
	@Query(value="update maincart  set cart_id=?1 where cart_id=?2",nativeQuery = true)
	public Integer  updateproductId( int cart_id, int newcart_id);
	
}
