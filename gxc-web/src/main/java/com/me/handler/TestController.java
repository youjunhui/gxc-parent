package com.me.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.dal.biz.AccessListDao;

@Controller
@RequestMapping("djb/testController")
public class TestController<T> {
	
//	@Autowired
//	private TestService testService;
	
	@Autowired
	public AccessListDao accessListDao;
	
	@RequestMapping("/getbyid")
	public T getById() {
//		return testService.getById();
		
		return (T) accessListDao.getById(1l);
	}
}
