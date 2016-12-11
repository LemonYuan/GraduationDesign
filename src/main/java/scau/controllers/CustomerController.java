package scau.controllers;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import scau.mappers.ICustomerDAO;
import scau.models.Customer;
import scau.services.ICustomerServices;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerServices iCustomerServices;

	@RequestMapping("/information")
	public ModelAndView getInformation(HttpServletRequest request, HttpServletResponse response) {
		return iCustomerServices.getInformation();
	}
	
	@RequestMapping("/customerNumByStore")
	public @ResponseBody JsonObject getCustomerNum(HttpServletRequest request, HttpServletResponse response) {
		return iCustomerServices.getCustomerNum();
	}
	
	public ICustomerServices getiCustomerServices() {
		return iCustomerServices;
	}

	public void setiCustomerServices(ICustomerServices iCustomerServices) {
		this.iCustomerServices = iCustomerServices;
	}

}