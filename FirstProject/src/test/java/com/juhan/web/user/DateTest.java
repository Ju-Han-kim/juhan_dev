package com.juhan.web.user;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DateTest {
	
	@Test
	public void date() {
		
		Date now = new Date(System.currentTimeMillis());
		Date next = new Date(System.currentTimeMillis() + 60*60*24*1000);
		
		System.out.println(next.getTime() - now.getTime());
		
	}
	
}
