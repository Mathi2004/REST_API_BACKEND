package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CustomerModel;
import com.example.demo.Service.CustomerService;


@RestController
public class CustomerController {
   @Autowired
   CustomerService cs;
   @PostMapping("addstudent")
   public CustomerModel add(@RequestBody CustomerModel cm)
   {
	   return cs.saveinfo(cm);
   }
   @PostMapping("addnstudent")
   public List<CustomerModel> adddetails(@RequestBody List<CustomerModel> cm)
   {
	   return cs.savedetails(cm);
   }
   @GetMapping("showdetails")
   public List<CustomerModel> show()
   {
	   return cs.showinfo();
   }
   @GetMapping("showbyId/{CustomerId}")
   public Optional<CustomerModel> showId(@PathVariable int CustomerId)
   {
	   return cs.showById(CustomerId);
   }
   //sorting
   @GetMapping("customersort/{str}")
   public List<CustomerModel> customersort(@PathVariable String str)
   {
  	 return cs.sortcustomerinfo(str);
   }
   //paging
   @GetMapping("customerpaging/{pgno}/{pgsize}")
   public List<CustomerModel> customerpaging(@PathVariable int pgno,@PathVariable int pgsize)
   {
   return cs.getbycustomerPage(pgno, pgsize);
   }
   //sort and paging
   @GetMapping("customersortpaging/{pgno}/{pgsize}/{str}")
   public List<CustomerModel> customersortpage(@PathVariable int pgno,@PathVariable int pgsize,@PathVariable String str)
   {
  	 return cs.sortcustomerpaging(pgno, pgsize, str);
   }
   @PutMapping("update")
   public CustomerModel modify(@RequestBody CustomerModel cm)
   {
	   return cs.changeinfo(cm);
   }
   @PutMapping("updatebyId/{id}")
   public String modifybyId(@PathVariable int CustomerId,@RequestBody CustomerModel cm)
   {
	   return cs.changebyId(CustomerId, cm);
   }
   @DeleteMapping("delete")
   public void erase(@RequestBody CustomerModel cm)
   {
	   cs.deleteinfo(cm);
   }
   @DeleteMapping("deletebyId/{CustomerId}")
   public void erasebyId(@PathVariable int CustomerId)
   {
	   cs.deletebyId(CustomerId);
   }
}
