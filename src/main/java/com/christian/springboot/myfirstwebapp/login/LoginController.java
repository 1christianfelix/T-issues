package com.christian.springboot.myfirstwebapp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	
	// /login?name=John
	@RequestMapping("login")
	public String gotoLogin(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		return "login";
	}

}
