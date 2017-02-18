package scau.services;

import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

public interface ICustomerServices {
	public ModelAndView getInformation();
	public JsonObject getCustomerNum(String x,String y);
}
