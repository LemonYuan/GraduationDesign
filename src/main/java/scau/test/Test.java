package scau.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import scau.mappers.ICustomerDAO;
import scau.models.Customer;


public class Test {
	private static ApplicationContext ctx;
	static
	{
	ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	public static void main(String[] args)
	{
		ICustomerDAO mapper = (ICustomerDAO)ctx.getBean("ICustomerDAO");
	//测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
	System.out.println("得到用户id=1的用户信息");
	Customer user = mapper.selectCustomerByID(1);
	System.out.println(user.getFirst_name());

	}
	}