package com.example.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CategoryModel;
import com.example.demo.Repository.CategoryRepo;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo cr;
    //add
    public CategoryModel categorysaveinfo(CategoryModel cm)
    {
    	return cr.save(cm);
    }
    //addndetails
    public List<CategoryModel> categorysavedetailsinfo(List<CategoryModel> cm)
    {
    	return cr.saveAll(cm);
    }
    //show
    public List<CategoryModel> categoryshowinfo()
    {
    	return cr.findAll();
    }
    //sorting
    public List<CategoryModel> categorysortinfo(String s)
    {
    	return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
    }
    //paging
    public List<CategoryModel> categoryPageinfo(int pgno,int pgsize)
    {
     Page<CategoryModel> p=cr.findAll(PageRequest.of(pgno,pgsize));
    return p.getContent();
    }
    //sorting and paging 
    public List<CategoryModel> categorysortpaginginfo(int pgno,int pgsize,String str)
    {
    Page<CategoryModel> p=cr.findAll(PageRequest.of(pgno, pgsize,Sort.by(str)));
    	return p.getContent();
    }
    //get productId
    public List<CategoryModel> getinfocategoryinfo(int categoryID)
    {
    	return cr.categoryget(categoryID);
    }
    //delete productId
    public int deleteinfocategoryinfo(int categoryID)
    {
    	return cr.categorydelete(categoryID);
    }
    //update productId
    public int updateinfocategoryinfo(int categoryID,int newcategoryID)
    {
    	return cr.categoryupdate(categoryID, newcategoryID);
    }
    //update
    public CategoryModel categoryupdateinfo(CategoryModel cm)
    {
    	return cr.saveAndFlush(cm);
    }
    //update by id
    public String categoryupdateByIdinfo(int categoryID,CategoryModel cm)
    {
    	cr.saveAndFlush(cm);
    	if(cr.existsById(categoryID))
    	{
    		return "update";
    	}
    	else
    	{
    		return "enter valid id";
    	}
    }
    //delete
    public void categorydeleteinfo(CategoryModel cm)
    {
    	 cr.delete(cm);
    }
    //delete by id
    public void categorydeleteByIdinfo(int categoryID)
    {
    	cr.deleteById(categoryID);
    }
    
}
