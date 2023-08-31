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


import com.example.demo.Model.CategoryModel;
import com.example.demo.Service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    CategoryService cs;
    @PostMapping("addcategory")
    public CategoryModel categoryadd(@RequestBody CategoryModel cm)
    {
    	return cs.categorysaveinfo(cm);
    }
    @PostMapping("addncategory")
    public List<CategoryModel> categoryadddetails(@RequestBody List<CategoryModel> cm)
    {
    	return cs.categorysavedetailsinfo(cm);
    }
    @GetMapping("showcategorydetails")
    public List<CategoryModel> display()
    {
    	return cs.categoryshowinfo();
    }
  
    //sorting
    @GetMapping("sortcategory/{str}")
    public List<CategoryModel> categorysort(@PathVariable String str)
    {
   	 return cs.categorysortinfo(str);
    }
    //paging
    @GetMapping("pagingcategory/{pgno}/{pgsize}")
    public List<CategoryModel> categorypage(@PathVariable int pgno,@PathVariable int pgsize)
    {
    return cs.categoryPageinfo(pgno, pgsize);
    }
    //sort and paging
    @GetMapping("sortpagingcategory/{pgno}/{pgsize}/{str}")
    public List<CategoryModel> categorysortpage(@PathVariable int pgno,@PathVariable int pgsize,@PathVariable String str)
    {
   	 return cs.categorysortpaginginfo(pgno, pgsize, str);
    }
    //get categoryID
    @GetMapping("getcategory/{categoryID}")
    public List<CategoryModel> getcategory(@PathVariable  int categoryID)
    {
 	   return cs.getinfocategoryinfo(categoryID);
    }
    //delete categoryID
    @DeleteMapping("deletecategory/{categoryID}")
    public String removecategory(@PathVariable int categoryID)
    {
    	return cs.deleteinfocategoryinfo(categoryID)+"deleted";
    }
    //update cart_id
    @PutMapping("updatecategory/{categoryID}/{newcategoryID}")
    public String modifycategoryID(@PathVariable int categoryID,@PathVariable int newcategoryID)
    {
    	return cs.updateinfocategoryinfo(categoryID, newcategoryID)+"updated";
    }
    @PutMapping("categoryupdate")
    public CategoryModel categorymodify(@RequestBody CategoryModel cm)
    {
    	return cs.categoryupdateinfo(cm);
    }
    @PutMapping("categoryupdatebyid/{categoryID}")
    public String categorymodifyById(@PathVariable int categoryID,@RequestBody CategoryModel cm)
    {
    	return cs.categoryupdateByIdinfo(categoryID, cm);
    }
    @DeleteMapping("categorydelete")
    public void categoryremove(@RequestBody CategoryModel cm)
    {
    	cs.categorydeleteinfo(cm);;
    }
    @DeleteMapping("categorydeleteBy/{categoryID}")
    public void categoryremoveById(@PathVariable int  categoryID)
    {
    	cs.categorydeleteByIdinfo(categoryID);
    }
    
    
}
