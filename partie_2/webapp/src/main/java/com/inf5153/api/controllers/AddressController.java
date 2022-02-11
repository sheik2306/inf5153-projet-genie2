package com.inf5153.api.controllers;

import java.util.List;
import com.inf5153.api.models.Address;
import com.inf5153.api.services.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


// @CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping(value = "/addresses")
public class AddressController {

      @Autowired
      AddressService addressService;
    

    @GetMapping("")
	public ModelAndView addresses() {
        //  List<Address> addresses = addressDAO.getAll();
        List<Address> addresses = addressService.fetchAll();
        ModelAndView mav = new ModelAndView("views/addressList");
		mav.addObject("addresses",addresses);
		return mav;
	}


    // Get 'empty' model for form URL to insert data
    @RequestMapping(value="/form", method = RequestMethod.GET)    
    public String showform(Model m){    
        m.addAttribute("address", new Address());  
        return "views/addressForm";   
    }   

    // save 'filled' model from form url inside database
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("address") Address address){ 
        addressService.createOrSave(address);
        return "redirect:/addresses";//will redirect to viewemp request mapping    
    }    

      /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/edit/{id}")    
    public String edit(@PathVariable int id, Model m){    
         Address address = addressService.fetchOneById(id);
        m.addAttribute("address",address);  
        return "views/addressEdit";    
    }    
    
    /* It updates model object. */    
    @RequestMapping(value="/edit/save",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("address") Address address){   
         addressService.createOrSave(address);
        return "redirect:/addresses";    
    }  



    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        addressService.delete(id);
        return "redirect:/addresses";    
    }   
    
}
