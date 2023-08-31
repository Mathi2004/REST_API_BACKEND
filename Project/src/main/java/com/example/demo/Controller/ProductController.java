package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Model.ProductModel;
import com.example.demo.Service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService ps;
    @PostMapping("addproduct")
    public ProductModel addproduct(@RequestBody ProductModel pm)
    {
    	return ps.saveproductinfo(pm);
    }
    @PostMapping("addproductdetails")
    public List<ProductModel> addproductdetails(@RequestBody List<ProductModel> pm)
    {
    	return ps.saveproductdetails(pm);
    }
    @GetMapping("showproductdetails")
    public List<ProductModel> display()
    {
    	return ps.showproductinfo();
    }
  
    //sorting
    @GetMapping("sortproduct/{str}")
    public List<ProductModel> sortproduct(@PathVariable String str)
    {
   	 return ps.sortproductinfo(str);
    }
    //paging
    @GetMapping("pagingproduct/{pgno}/{pgsize}")
    public List<ProductModel> productpage(@PathVariable int pgno,@PathVariable int pgsize)
    {
    return ps.productPageinfo(pgno, pgsize);
    }
    //sort and paging
    @GetMapping("productsortpaging/{pgno}/{pgsize}/{str}")
    public List<ProductModel> productsortpage(@PathVariable int pgno,@PathVariable int pgsize,@PathVariable String str)
    {
   	 return ps.productsortpaging(pgno, pgsize, str);
    }
    //get productId
    @GetMapping("getProduct/{productId}")
    public List<ProductModel> getProductproductIdinfo(@PathVariable  int productId)
    {
 	   return ps.getproductproductId(productId);
    }
    //delete productId
    @DeleteMapping("deleteProduct/{productId}")
    public String removeProductproductIdinfo(@PathVariable int productId)
    {
    	return ps.deleteproductproductIdinfo(productId)+"deleted";
    }
    //update Product_id
    @PutMapping("updateproduct/{productId}/{newproductId}")
    public String modifyproductIdinfo(@PathVariable int productId,@PathVariable int newproductId)
    {
    	return ps.updateproductproductIdinfo(productId, newproductId)+"updated";
    }
    @PutMapping("updateProduct")
    public ProductModel modifyProduct(@RequestBody ProductModel pm)
    {
    	return ps.updateproduct(pm);
    }
    @PutMapping("updateByProductId/{ProductItemId}")
    public String modifyByProductId(@PathVariable int ProductItemId,@RequestBody ProductModel pm)
    {
    	return ps.updateByIdproduct(ProductItemId, pm);
    }
    @DeleteMapping("deleteProduct")
    public void removeProduct(@RequestBody ProductModel pm)
    {
    	ps.deleteproductinfo(pm);;
    }
    @DeleteMapping("deleteByProductId/{ProductItemId}")
    public void removeByProductId(@PathVariable int  ProductItemId)
    {
    	ps.deleteByIdproduct(ProductItemId);
    }
    
    
}
