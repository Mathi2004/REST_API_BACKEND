package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.Model.CustomerModel;
import com.example.demo.Repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo cr;
    public CustomerModel saveinfo(CustomerModel cm)
    {
    	return cr.save(cm);
    }
    public List<CustomerModel> savedetails(List<CustomerModel> cm)
    {
    	return cr.saveAll(cm);
    }
    public List<CustomerModel> showinfo()
    {
    	return cr.findAll();
    }
    public Optional<CustomerModel> showById(int CustomerId)
    {
    	return cr.findById(CustomerId);
    }
  //sorting
    public List<CustomerModel> sortcustomerinfo(String s)
    {
    	return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
    }
    //paging
    public List<CustomerModel> getbycustomerPage(int pgno,int pgsize)
    {
     Page<CustomerModel> p=cr.findAll(PageRequest.of(pgno,pgsize));
    return p.getContent();
    }
    //sorting and paging 
    public List<CustomerModel> sortcustomerpaging(int pgno,int pgsize,String str)
    {
    Page<CustomerModel> p=cr.findAll(PageRequest.of(pgno, pgsize,Sort.by(str)));
    	return p.getContent();
    }
    public CustomerModel changeinfo(CustomerModel cm)
    {
    	return cr.saveAndFlush(cm);
    }
    public String changebyId(int CustomerId,CustomerModel cm)
    {
        cr.saveAndFlush(cm);
        if(cr.existsById(CustomerId))
        {
        	return "updated";
        }
        else
        {
        	return "enter valid id";
        }
    }
    public void deleteinfo(CustomerModel cm)
    {
        cr.delete(cm);
    }
    public void deletebyId(int CustomerId)
    {
    	cr.deleteById(CustomerId);
    }
    
}
