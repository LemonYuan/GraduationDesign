package scau.services;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import scau.mappers.ICustomerDAO;
import scau.models.Customer;

@Service
public class CustomerServices implements ICustomerServices {
	@Autowired
	ICustomerDAO iCustomerDAO;

	public ModelAndView getInformation() {
		// Customer customer = iCustomerDAO.selectCustomerByID(1);
		List<Customer> customer_list = iCustomerDAO.getAllCustomer();
		System.out.println("所有的用户数为：" + customer_list.size());
		ModelAndView modelAndView = new ModelAndView("echartsTest");
		modelAndView.addObject("customers", customer_list);
		return modelAndView;
	}

	public JsonObject getCustomerNum() {
		List<LinkedHashMap> customer_ist = iCustomerDAO.getCustomerNumByStore();

		JsonObject jo = new JsonObject();
		JsonArray categories = new JsonArray();
		JsonArray data = new JsonArray();

		for (int i = 0; i < customer_ist.size(); i++) {
			LinkedHashMap hm = customer_ist.get(i);
			Iterator iter = hm.entrySet().iterator();
			int index = 0;
			while (iter.hasNext()) {
				Entry entry = (Entry) iter.next();
				System.out.println(entry.getKey() + "  " + entry.getValue());
				if (index == 0) {
					JsonPrimitive tem_js = new JsonPrimitive(entry.getValue().toString());
					categories.add(tem_js);
					index = 1;
				} else {
					JsonPrimitive tem_js = new JsonPrimitive(entry.getValue().toString());
					data.add(tem_js);
					index = 0;
				}

			}
		}
		jo.add("categories", categories);
		jo.add("data", data);
		System.out.println(jo.toString());
		return jo;
	}

	public ICustomerDAO getiCustomerDAO() {
		return iCustomerDAO;
	}

	public void setiCustomerDAO(ICustomerDAO iCustomerDAO) {
		this.iCustomerDAO = iCustomerDAO;
	}

}
