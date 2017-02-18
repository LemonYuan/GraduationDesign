package scau.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

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
	public @ResponseBody JsonObject getCustomerNum(@RequestParam(value="x") String x,@RequestParam(value="y") String y,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(x+y);
		return iCustomerServices.getCustomerNum(x,y);
	}
	
	public ICustomerServices getiCustomerServices() {
		return iCustomerServices;
	}

	public void setiCustomerServices(ICustomerServices iCustomerServices) {
		this.iCustomerServices = iCustomerServices;
	}

}