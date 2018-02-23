package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService)container.getBean("userService");
		
		UserVo vo = new UserVo();
		vo.setId("test");
		vo.setPassword("test123");
		userService.getUser(vo);
		
		UserVo user =userService.getUser(vo);
		
		if(user !=null) {
			System.out.println(user.getName());
		}else {
			System.out.println("�α����");
		}
		
	}

}
