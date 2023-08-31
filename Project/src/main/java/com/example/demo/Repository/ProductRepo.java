package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.ProductModel;


import jakarta.transaction.Transactional;

public interface ProductRepo extends JpaRepository<ProductModel, Integer>{
	@Query(value="select * from mainproduct where productid=:a",nativeQuery=true)
    public List<ProductModel> productIdinfo1(@Param("a") int productid);
	@Transactional
	@Modifying
	@Query(value="delete from mainproduct where productid=:b",nativeQuery=true)
    public Integer deleteproductId1(@Param("b") int productid);
	@Modifying
	@Transactional
	@Query(value="update mainproduct c set c.productid=?1 where c.productid=?2",nativeQuery = true)
	public Integer  updateproductId1( int productid, int newproductid);
}
