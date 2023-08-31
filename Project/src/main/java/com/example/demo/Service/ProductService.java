package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.Model.ProductModel;
import com.example.demo.Repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo pr;
    public ProductModel saveproductinfo(ProductModel pm)
    {
    	return pr.save(pm);
    }
    public List<ProductModel> saveproductdetails(List<ProductModel> pm)
    {
    	return pr.saveAll(pm);
    }
    public List<ProductModel> showproductinfo()
    {
    	return pr.findAll();
    }
    //sorting
    public List<ProductModel> sortproductinfo(String s)
    {
    	return pr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
    }
    //paging
    public List<ProductModel> productPageinfo(int pgno,int pgsize)
    {
     Page<ProductModel> p=pr.findAll(PageRequest.of(pgno,pgsize));
    return p.getContent();
    }
    //sorting and paging 
    public List<ProductModel> productsortpaging(int pgno,int pgsize,String str)
    {
    Page<ProductModel> p=pr.findAll(PageRequest.of(pgno, pgsize,Sort.by(str)));
    	return p.getContent();
    }
    //get productId
    public List<ProductModel> getproductproductId(int productid)
    {
    	return pr.productIdinfo1(productid);
    }
    //delete productId
    public int deleteproductproductIdinfo(int productid)
    {
    	return pr.deleteproductId1(productid);
    }
    //update productId
    public int updateproductproductIdinfo(int productid,int newproductid)
    {
    	return pr.updateproductId1(productid, newproductid);
    }
    
    public ProductModel updateproduct(ProductModel pm)
    {
    	return pr.saveAndFlush(pm);
    }
    public String updateByIdproduct(int productid,ProductModel pm)
    {
    	pr.saveAndFlush(pm);
    	if(pr.existsById(productid))
    	{
    		return "update";
    	}
    	else
    	{
    		return "enter valid id";
    	}
    }
    public void deleteproductinfo(ProductModel pm)
    {
    	 pr.delete(pm);
    }
    public void deleteByIdproduct(int productid)
    {
    	pr.deleteById(productid);
    }
    
}

