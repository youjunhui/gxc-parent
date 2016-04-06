package com.me.handler;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.dal.biz.AccessListDao;
import com.me.model.dal.AccessListDO;

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
			AccessListDO accessListDO = new AccessListDO();
			accessListDO.setId(BigDecimal.valueOf(1724L));
			accessListDO = accessListDao.getByKey(accessListDO);
			System.out.println(accessListDO.getBizSeqno());
		return null;
	}
}
