package com.example.demo.controller;

import java.text.DateFormat;
//import java.util.Date;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.example.demo.DemoApplication;
  
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =DemoApplication.class)//较新版的Spring Boot取消了@SpringApplicationConfiguration这个注解，用@SpringBootTest就可以了https://blog.csdn.net/office5845/article/details/77749350
//@SpringApplicationConfiguration(classes = Application.class)Application是启动类
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
		String formattedDate = dateFormat.format(date);
		
		userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456","s"));
		userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
		userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

		Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa1"));
	}

}

