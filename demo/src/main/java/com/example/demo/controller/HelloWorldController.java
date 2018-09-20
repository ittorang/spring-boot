package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    /*
     * 
     *   json 接口开发
			在以前的spring 开发的时候需要我们提供json接口的时候需要做那些配置呢
        	添加 jackjson 等相关jar包
        	配置spring controller扫描
        	对接的方法添加@ResponseBody

		就这样我们会经常由于配置错误，导致406错误等等，spring boot如何做呢，只需要类添加 @RestController 即可，默认类中的方法都会以json的格式返回
     * 
     * 
     * 
     * 
     */
    @RequestMapping("/getUser")
    public User getUser() {
    	User user=new User();
    	user.setUserName("小明");
    	user.setPassWord("xxxx");
        return user;
    }
}