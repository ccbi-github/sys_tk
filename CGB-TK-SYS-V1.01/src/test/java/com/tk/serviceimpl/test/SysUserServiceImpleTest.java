package com.tk.serviceimpl.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tk.common.vo.PageObject;
import com.tk.sys.service.SysUserService;

public class SysUserServiceImpleTest {

	@Autowired
	private SysUserService sysUserService;

	private ClassPathXmlApplicationContext context;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring-configs.xml");
		sysUserService = context.getBean("sysUserServiceImpl", SysUserService.class);

	}

	@Test
	public void testFindAllObjectAndVipPage() {
		
		
	}

}