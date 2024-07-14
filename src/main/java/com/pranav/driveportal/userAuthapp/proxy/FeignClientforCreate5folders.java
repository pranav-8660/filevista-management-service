package com.pranav.driveportal.userAuthapp.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("awsbridge-application")
public interface FeignClientforCreate5folders {
	
	//  http://localhost:5000/aws-client-handler/create-five-folders/userName/{username}
	
	@GetMapping(value="/aws-client-handler/create-five-folders/userName/{username}")
	public String create5FoldersafterSignup(@PathVariable String username);
	

}
