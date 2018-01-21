package org.sunbeam.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("login")
public class loginController 
{
	public loginController() {
	System.out.println("Inside User Controller....");
	
	}
		
	
	@RequestMapping("/admin") 
	public String admin(){
		System.out.println("going to Admin page ....");
	    return "/login/Admin"; 
	} 
	
	@GetMapping("/jobseeker")
	public String oneget(){
		System.out.println("going to Jobseeker page ....");
		return "/login/Jobseeker";
	}
	
	@PostMapping("/company")
	public String onepost(){
		System.out.println("going to Company page ....");
		return "/login/Company";
	}


}
