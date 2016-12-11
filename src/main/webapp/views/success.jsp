<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,scau.models.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<body>
<%
   ArrayList customer_list=(ArrayList)request.getAttribute("customers");
if(customer_list!=null)
{
	
  for(int i=0;i<customer_list.size();i++) {  
	  Customer customer=(Customer)customer_list.get(i);
	  out.print("id："+customer.getCustomer_id()+"名字: "+customer.getFirst_name());
   }
}


%>

</body>
</html>
