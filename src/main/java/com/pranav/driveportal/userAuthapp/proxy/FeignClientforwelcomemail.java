package com.pranav.driveportal.userAuthapp.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="mail-sender")
public interface FeignClientforwelcomemail{
	
	@GetMapping(value="/send-mail/{to}/{title}/{message}")
	public String sendMail(@PathVariable String to,@PathVariable String title,@PathVariable String message);

}
