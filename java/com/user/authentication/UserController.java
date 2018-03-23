package com.user.authentication;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String authenticateUser(@PathVariable("id") String id ) {
		
		return "123";
	}

}
