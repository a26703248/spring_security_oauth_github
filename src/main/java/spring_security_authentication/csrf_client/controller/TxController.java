package spring_security_authentication.csrf_client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TxController {
	
	@RequestMapping("/")
	public String index(Authentication authentication) {
		String name = authentication.getName();
		System.out.println("Hello " + name);
		return "Hello " + name;
	}
	
	@PostMapping("/tx")
	public String tx(Authentication authentication, HttpServletRequest request) {
		String name = authentication.getName();
		System.out.println(name + "交易了 100 元");
		return name + "交易了 100 元";
	}
}
