package cn.myforever;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.myforever.service.MyService;

public class AppMySpringTransaction {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app =new ClassPathXmlApplicationContext("spring.xml");
		MyService myService =(MyService) app.getBean("myService");
		//myService.add();
		myService.add1();
	}
}
