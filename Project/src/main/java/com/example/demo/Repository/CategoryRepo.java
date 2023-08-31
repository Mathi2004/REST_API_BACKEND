package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.CategoryModel;

import jakarta.transaction.Transactional;

public interface CategoryRepo extends JpaRepository<CategoryModel, Integer>{

	@Query(value="select * from maincategory where categoryID=:a",nativeQuery=true)
    public List<CategoryModel> categoryget(@Param("a") int categoryID);
	@Transactional
	@Modifying
	@Query(value="delete from maincategory where categoryID=:b",nativeQuery=true)
    public Integer categorydelete(@Param("b") int categoryID);
	@Modifying
	@Transactional
	@Query(value="update maincategory c set c.categoryID=?1 where c.categoryID=?2",nativeQuery = true)
	public Integer  categoryupdate( int categoryID, int newcategoryID);
}
