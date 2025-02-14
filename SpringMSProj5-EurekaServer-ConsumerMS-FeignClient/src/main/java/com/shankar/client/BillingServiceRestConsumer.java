package com.shankar.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Service")
public interface BillingServiceRestConsumer {
	@GetMapping("/billing/info")
	public String getBillingInfo() ;

}
